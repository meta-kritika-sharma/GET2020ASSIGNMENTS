import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class addStudentDetails.
 */
// @WebServlet("/addStudentDetails")
public class addStudentDetails extends HttpServlet {
	
	private static final long serialVersionUID = 1;
	public addStudentDetails() {
		super();
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstNameOfStudent");
		String lastName = request.getParameter("lastNameOfStudent");
		String fatherName = request.getParameter("nameOfFather");
		String mail = request.getParameter("mail");
		int classOfStudent = Integer.parseInt(request
				.getParameter("classOfStudent"));
		int age = Integer.parseInt(request.getParameter("ageOfStudent"));

		try {
			Connection connection = DbConnection.createConnection();
			ResultSet outputTable = selectDataFromTable(connection);
			int flag = 0;
			
			//Checking if email id is already present into the database.
			while (outputTable.next()) {

				if (outputTable.getString("MailId").equals(mail)) {
					flag = 1;
					break;
				}
			}

			if (flag == 0) {
				insertDataIntoTable(connection, firstName, lastName,
						fatherName, mail, classOfStudent, age);
				out.println("Successful insertion");
			}

			else {
				sweetAlert(request, response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	/**
	 * Insert data into table.
	 *
	 * @param connection the connection object
	 * @param firstname is the first name of the student
	 * @param lastname the last name of the student
	 * @param fatherName is the father's name
	 * @param mail is the mail id 
	 * @param classofStudent the class of student
	 * @param age the age
	 * @throws SQLException the SQL exception
	 */
	private void insertDataIntoTable(Connection connection, String firstname,
			String lastname, String fatherName, String mail,
			int classofStudent, int age) throws SQLException {
		PreparedStatement st = (PreparedStatement) connection
				.prepareStatement("insert into studentdetails values(?,?,?,?,?,?)");
		st.setString(1, firstname);
		st.setString(2, lastname);
		st.setString(3, fatherName);
		st.setString(4, mail);
		st.setInt(5, classofStudent);
		st.setInt(6, age);
		st.executeUpdate();
	}

	/**
	 * Select data from table.
	 *
	 * @param connection the connection
	 * @return the result set containing the table obtained from the database after the execution of select query.
	 * @throws SQLException the SQL exception
	 */
	private ResultSet selectDataFromTable(Connection connection)
			throws SQLException {
		Statement statement = (Statement) connection.createStatement();
		ResultSet outputTable = statement
				.executeQuery("select * from studentdetails");
		return outputTable;
	}
 
	// Method to generate sweet alert.
	private void sweetAlert(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		out.println("<script>$(document).ready(function(){swal('Email ID Already Registered','Unsuccessfull !', 'error')});</script>");
		request.getRequestDispatcher("addStudentDetail.html").include(request,
				response);
		;

	}

}
