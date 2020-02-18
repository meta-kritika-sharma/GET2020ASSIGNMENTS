package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.commands.Student;

public interface StudentDAO {
	
	/*
	 * @param student object
	 * @return true after adding student details. 
	 */
	
	public boolean addStudent(Student newStudent);
	
	/*
	 * @return listOfstudents
	 */

	public List<Student> showStudents();
}
