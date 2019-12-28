package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helpers.UserHelper;
import pojos.User;
import utilities.Encryption;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private String url;
	private int loginAttempts;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//User has clicked the logout link
		session = request.getSession();

		//check to make sure we've clicked link
		if(request.getParameter("logout") !=null){

			//logout and redirect to front page
			logout();
			url="index.jsp";
		}

		//forward our request along
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get our current session
		session = request.getSession();
		
		// get the number of logins (Prevents brute force attacks)
		if(session.getAttribute("loginAttempts")==null) {
			loginAttempts = 0;
		}
		
		// exceeded logins
		if(loginAttempts > 2) {
			
			String errorMessage = "Error: Number of Login Attempts Exceeded";
			request.setAttribute("errorMessage", errorMessage);
			
			url = "index.jsp";
		}
		else {	// proceed
			// pull the fields from the form
			String username = request.getParameter("username");
			String password = request.getParameter("pass");
			
			// encrypt the password to check against what stored in the DB
			Encryption pws = new Encryption();
			String encryptedPass = pws.SHA1(password);
			
			// create a user helper class to make database calls, and call authenticate user method
			UserHelper uh = new UserHelper();
			User user = uh.authenticateUser(username, encryptedPass);
			
			// we have found a user that matches the credentials
			if(user!=null) {
				
				// invalidate the current session, then get new session for our user (combats: session hijacking)
				session.invalidate();
				session = request.getSession(true);
				session.setAttribute("user", user);
				url = "UserAccount.jsp";
			}
			else {	// user don't exist, redirect to previous page and show error
				String errorMessage = "Error: Unrecognized Username or Password<br>Login attempts remaining: "+(3-(loginAttempts));
				request.setAttribute("errorMessage", errorMessage);

				//track login attempts (combats: brute force attacks)
				session.setAttribute("loginAttempts", loginAttempts++);
				url = "index.jsp";
			}
 		}
		//forward our request along
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	public void logout() {
		session.invalidate();
	}
}
