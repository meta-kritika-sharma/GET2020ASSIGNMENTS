import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public login() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		Connection connection = null;
		try {
			connection = DbConnection.createConnection();
			int count = selectQuery(connection, login, password);
			if (count == 0) {
				sweetAlert(request, response);

			} else {

				HttpSession session = request.getSession();
				session.setAttribute("mail", login);
				session.setAttribute("password", password);

				String query = "select * from employeedetails, vehicledetails where Mail='"
						+ login
						+ "' and employeedetails.EmployeeId=vehicledetails.EmployeeId";
				Statement statement = (Statement) connection.createStatement();
				ResultSet result = statement.executeQuery(query);
				result.next();

				response.sendRedirect("homepage.html?empName="
						+ result.getString("EmployeeName") + "&&empgender="
						+ result.getString("Gender") + "&&mail="
						+ result.getString("Mail") + "&&org="
						+ result.getString("Organisation") + "&&id="
						+ result.getString("EmployeeId") + "&&vname="
						+ result.getString("VehicleName") + "&&vtype="
						+ result.getString("VehicleType") + "&&vnumber="
						+ result.getString("VehicleNumber"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private int selectQuery(Connection connection, String login, String password)
			throws SQLException {
		int count = 0;
		String query = "select count(*) from employeedetails where Mail='"
				+ login + "' and Password='" + password + "'";
		Statement statement = (Statement) connection.createStatement();
		ResultSet outputTable = statement.executeQuery(query);
		outputTable.next();
		count = outputTable.getInt("count(*)");
		return count;
	}

	private void sweetAlert(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		out.println("<script>$(document).ready(function(){swal('Invalid credentials','Unsuccessfull !', 'error')});</script>");
		request.getRequestDispatcher("login.html").include(request, response);
		;
	}

}
