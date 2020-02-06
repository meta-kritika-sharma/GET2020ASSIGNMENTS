
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class editDetails
 */
@WebServlet("/editDetails")
public class editDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public editDetails() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("empid"));
		Connection connection = DbConnection.createConnection();
		String query = "update employeedetails set EmployeeName=?, Gender=?, Mail=? where Employeeid="
				+ id;
		try {
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(query);
			statement.setString(1, request.getParameter("empName"));
			statement.setString(2, request.getParameter("empGender"));
			statement.setString(3, request.getParameter("empMail"));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
