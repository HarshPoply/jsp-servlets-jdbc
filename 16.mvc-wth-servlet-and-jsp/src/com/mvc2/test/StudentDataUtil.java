package com.mvc2.test;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {

	public static List<Student> getStudents()  {
		
		// create an empty list
		List<Student> students = new ArrayList<>();
		
		// add sample data
		students.add(new Student("Harsh","Poplay","harsh.poplay@gmnail.com"));
		students.add(new Student("Abhimanyu","Yadav","abhi.yadav@gmnail.com"));
		students.add(new Student("Rohit","Kalra","rohit.kalra@gmnail.com"));
		students.add(new Student("Pankaj","Parkash","pankaj.parkash@gmnail.com"));
		
		// return the list
		return students;
	}
}
