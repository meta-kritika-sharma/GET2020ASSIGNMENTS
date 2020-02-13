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
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class vehicleRegistration
 */
@WebServlet("/vehicleRegistration")
public class vehicleRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public vehicleRegistration() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String vehicleName = request.getParameter("vehicleName");
		String vehicleType = request.getParameter("typeOfVehicle");
		String vehicleNumber = request.getParameter("vehicleNumber");
		String description = request.getParameter("description");
		int id = Integer.parseInt(request.getParameter("employeeId"));

		Connection connection = DbConnection.createConnection();
		try {
			insertData(connection, vehicleName, vehicleType, vehicleNumber,
					description, id);
			ResultSet result = selectData(connection, vehicleType);
			result.next();
			response.sendRedirect("showPass.html?Employeeid=" + id
					+ "&&typeofvehicle=" + vehicleType + "&&daily="
					+ result.getInt("DailyPrice") + "&&monthly="
					+ result.getInt("MonthlyPrice") + "&&yearly="
					+ result.getInt("YearlyPrice"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void insertData(Connection connection, String vehicleName,
			String vehicleType, String vehicleNumber, String description, int id)
			throws SQLException {

		PreparedStatement statement = (PreparedStatement) connection
				.prepareStatement("insert into vehicledetails (EmployeeId, VehicleName, VehicleType, VehicleNumber, Description) values(?,?,?,?,?)");

		statement.setInt(1, id);
		statement.setString(2, vehicleName);
		statement.setString(3, vehicleType);
		statement.setString(4, vehicleNumber);
		statement.setString(5, description);
		statement.executeUpdate();

	}

	private ResultSet selectData(Connection connection, String vehicleType)
			throws SQLException {

		Statement st = (Statement) connection.createStatement();
		String query = "select * from passdetails where VehicleType='"
				+ vehicleType + "'";
		ResultSet result = st.executeQuery(query);
		return result;
	}
}
