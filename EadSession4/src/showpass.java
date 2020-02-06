
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class showpass
 */
@WebServlet("/showpass")
public class showpass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public showpass() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String passType = request.getParameter("pass");
		String typeOfVehicle = request.getParameter("hiddenvehicle");
		int id = Integer.parseInt(request.getParameter("hiddenid"));
		int price;
		Connection connection = DbConnection.createConnection();
		Statement statement;
		try {
			statement = (Statement) connection.createStatement();
			String query = "";

			int flag = 0;
			if (passType.equals("Daily")) {

				query = "select DailyPrice from passdetails where VehicleType='"
						+ typeOfVehicle + "'";
				flag = 1;
			} else if (passType.equals("Monthly")) {
				query = "select MonthlyPrice from passdetails where VehicleType='"
						+ typeOfVehicle + "'";
				flag = 2;
			}

			else {
				query = "select YearlyPrice from passdetails where VehicleType='"
						+ typeOfVehicle + "'";
				flag = 3;
			}
			ResultSet resultTable = statement.executeQuery(query);
			resultTable.next();

			out.println("Pass generated!!");
			if (flag == 1) {
				out.println("Pass price = " + resultTable.getInt("DailyPrice"));
				query = ("update vehicledetails set Plan='Daily', Price="
						+ resultTable.getInt("DailyPrice")
						+ " where EmployeeId=" + id);
			} else if (flag == 2) {
				out.println("Pass price = "
						+ resultTable.getInt("MonthlyPrice"));
				query = ("update vehicledetails set Plan='Monthly', Price="
						+ resultTable.getInt("MonthlyPrice")
						+ " where EmployeeId=" + id);
			} else if (flag == 3) {
				out.println("Pass price = " + resultTable.getInt("YearlyPrice"));
				query = ("update vehicledetails set Plan='Yearly', Price="
						+ resultTable.getInt("YearlyPrice")
						+ " where EmployeeId=" + id);
			}

			Statement st = (Statement) connection.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
