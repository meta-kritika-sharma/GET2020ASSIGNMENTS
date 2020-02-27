package com.metacube.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.StudentDAO;
import com.metacube.training.model.commands.Student;
import com.metacube.training.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDao;
	
	/*
	 * @param student object
	 * @return true after adding student details. 
	 */

	public boolean addStudent(Student student) {
		return studentDao.addStudent(student);
	}

	/*
	 * @return listOfstudents
	 */

	public List<Student> showStudents() {
		return studentDao.showStudents();
	}
}
