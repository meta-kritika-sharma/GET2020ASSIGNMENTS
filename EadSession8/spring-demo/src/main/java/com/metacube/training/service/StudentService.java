package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.commands.Student;

public interface StudentService {

	/*
	 * @param student object
	 * @return true after adding student details. 
	 */

	boolean addStudent(Student student);
	
	/*
	 * @return listOfstudents
	 */

	List<Student> showStudents();
}
