package com.example.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.Vehicle;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	/**
	 * @param mail
	 * @param password
	 * @return count
	 * @throws HibernateException
	 */
	@Query("select count(*) from Employee where mail=:mail and password=:password")
	public long validateUser(@Param("mail") String mail, @Param("password") String password) throws HibernateException;

	/**
	 * @param mail
	 * @return count
	 * @throws HibernateException
	 */
	@Query("select count(*) from Employee where mail=:mail")
	public long checkUserExists(@Param("mail") String mail) throws HibernateException;

	/**
	 * @param mail
	 * @return name of image
	 * @throws HibernateException
	 */
	@Query("select imageName from Employee where mail=:mail")
	public String checkImageExists(@Param("mail") String mail) throws HibernateException;

	/**
	 * @param name
	 * @param mail
	 * @return 1 if updated successfully, 0 otherwise.
	 * @throws HibernateException
	 */
	@Modifying
	@Query("update Employee set imageName=:name where mail=:mail")
	public int addImageName(String name, String mail) throws HibernateException;

	/**
	 * @param mail
	 * @param mailId
	 * @return object array of details of friends
	 * @throws HibernateException
	 */
	@Query(value = "select * from employeedetails WHERE mail !=:mail and organisation = (select organisation from employeedetails where mail =:mailId)", nativeQuery = true)
	public List<Object[]> showFriends(@Param("mail") String mail, @Param("mailId") String mailId) throws HibernateException;

	/**
	 * @param mail
	 * @return object array of employee details
	 * @throws HibernateException
	 */
	@Query("from Employee where mail=:mail")
	public List<Object[]> showEmployee(@Param("mail") String mail) throws HibernateException;

}
