import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("employeeName");
		String gender = request.getParameter("gender");
		String mail = request.getParameter("mailId");
		System.out.println(mail);
		String password = request.getParameter("password");
		String organisation = request.getParameter("organisation");
		PrintWriter out = response.getWriter();

		try {
			Connection connection = DbConnection.createConnection();
			String param = " count(*)";
			ResultSet resultTable = selectData(connection, mail, param);
			resultTable.next();
			int count = resultTable.getInt("count");
			System.out.println(count);
			if (count == 0) {
				insertData(connection, name, gender, mail, password,
						organisation);
				request.getRequestDispatcher("vehicleRegistration.html")
						.include(request, response);
				;
				param = " EmployeeId ";
				resultTable = selectData(connection, mail, param);
				resultTable.next();
				int employeeId = resultTable.getInt("count");
				response.sendRedirect("vehicleRegistration.html?empId="
						+ employeeId);

			} else {
				sweetAlert(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void insertData(Connection connection, String name, String gender,
			String mail, String password, String organisation)
			throws SQLException {
		PreparedStatement statement = (PreparedStatement) connection
				.prepareStatement("insert into employeedetails (EmployeeName, Gender,Mail,Password,Organisation) values (?,?,?,?,?)");
		statement.setString(1, name);
		statement.setString(2, gender);
		statement.setString(3, mail);
		statement.setString(4, password);
		statement.setString(5, organisation);
		statement.executeUpdate();
	}

	private ResultSet selectData(Connection connection, String mail,
			String param) throws SQLException {
		Statement statement = (Statement) connection.createStatement();
		String query = "select" + param
				+ "as count from employeedetails where Mail='" + mail + "'";
		ResultSet resultTable = statement.executeQuery(query);
		return resultTable;
	}

	// to create alert if mail already exists in database.
	private void sweetAlert(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		out.println("<script>$(document).ready(function(){swal('Mail Id already exists.','Unsuccessfull !', 'error')});</script>");
		request.getRequestDispatcher("employeeRegistration.html").include(
				request, response);
		;
	}

}
