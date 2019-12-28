package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DbManager;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentDbUtil studentDbUtil;
	private DbManager dbManager = new DbManager();
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			studentDbUtil = new StudentDbUtil(dbManager);
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
			// read the command parameter
			String theCommand = request.getParameter("command");
			
			// if command is missing then default to listing students
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch(theCommand) {
			case "LIST": 
				// list the students....in MVC fashion
				listStudents(request,response);
				break;
			
			case "LOAD":
				loadStudent(request,response);
				break;	
			
				
			case "DELETE": 
				deleteStudent(request,response);
				break;
				
			default: 
				listStudents(request,response);
			}
			
			
		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// read the command parameter
			String theCommand = request.getParameter("command");
			
			// route the appropriate command
			switch(theCommand) {
				case "ADD":
						addStudent(request,response);
						break;
				
				case "SEARCH":
						searchStudents(request,response);
						break;
				
				case "UPDATE": 
					updateStudent(request,response);
					break;
						
				
					
				default:
						listStudents(request,response);
				
			}
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
	}

	private void searchStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read search name from the form data
		String theSearchName = request.getParameter("theSearchName");
		
		// search students from db util
		List<Student> students = StudentDbUtil.searchStudents(theSearchName);
		
		// add students to the request
		request.setAttribute("STUDENT_LIST", students);
		
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
		
	}


	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read student id from the form data
		String theStudentId = request.getParameter("studentId");
		
		// delete student from database
		StudentDbUtil.deleteStudent(theStudentId);
		
		// send them back to "list students" page
		listStudents(request,response);
	}


	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read student information from the form data
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		
		
		// create a new student object
		Student theStudent = new Student(id,firstName,lastName,email);
		
		// perform update on database
		StudentDbUtil.updateStudent(theStudent);
		
		// send them back to the "list students" page
		listStudents(request,response);
	}


	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read student id from the form data
		String theStudentId = request.getParameter("studentId");
		
		// get student form db (db util)
		Student theStudent = StudentDbUtil.getStudentId(theStudentId);
		
		// place student in request attribute
		request.setAttribute("THE_STUDENT", theStudent);
		
		// send to jsp page i.e update-student-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);
	}


	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read student information from the data
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		
		// create a new student object
		Student theStudent = new Student(fname,lname,email);
		
		// add the student to the database
		StudentDbUtil.addStudent(theStudent);
		
		// send back to main page (list-students.jsp)
		// send as redirect to avoid multiple-browser reload issue
		response.sendRedirect(request.getContextPath()+"/StudentControllerServlet");
	}


	private void listStudents(HttpServletRequest request, HttpServletResponse response) 
	 throws Exception {
		
		// get students from db util
		List<Student> students = studentDbUtil.getStudents();
				
		// add students to request
		request.setAttribute("STUDENT_LIST", students);
		
		// send to JSP (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}
}
