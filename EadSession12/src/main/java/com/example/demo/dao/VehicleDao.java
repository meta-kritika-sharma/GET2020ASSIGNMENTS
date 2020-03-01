package com.example.demo.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Vehicle;

@Repository
public interface VehicleDao extends CrudRepository<Vehicle, Integer> {

	/**
	 * @param plan
	 * @param price
	 * @param employee
	 * @return 1 if successfully updated, 0 otherwise.
	 */
	@Modifying
	@Query("update Vehicle set plan=:plan, price=:price where employee =:employee")
	int getPass(@Param("plan") String plan, @Param("price") int price, @Param("employee") Employee employee);

	/**
	 * @param vehicleType
	 * @return object array of prices.
	 */
	@Query(value = "select DailyPrice,MonthlyPrice,YearlyPrice from passdetails where VehicleType=:vehicleType", nativeQuery = true)
	List<Object[]> addVehicleDetails(@Param("vehicleType") String vehicleType);

	/**
	 * @param key
	 * @return vehicle details.
	 */
	@Query("from Vehicle where employee=:employee")
	List<Object[]> showVehicle(@Param("employee") Employee key);
}
