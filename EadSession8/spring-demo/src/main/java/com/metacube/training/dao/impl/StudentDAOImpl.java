package com.metacube.training.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.training.dao.StudentDAO;
import com.metacube.training.model.commands.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private static List<Student> listOfStudents = new ArrayList<Student>();
	private static int numberOfStudents = 1;
	
	/*
	 * @param student object
	 * @return true after adding student details. 
	 */
	
	@Override
	public boolean addStudent(Student student) {
		student.setId(numberOfStudents);
		listOfStudents.add(student);
		numberOfStudents++;
		return true;
	}

	/**
	 * @return listOfstudents
	 */
	@Override
	public List<Student> showStudents() {
		return listOfStudents;
	}
	
	}
