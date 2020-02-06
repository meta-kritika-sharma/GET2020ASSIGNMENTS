import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class friends
 */
@WebServlet("/friends")
public class friends extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public friends() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			PrintWriter out = response.getWriter();
			PreparedStatement statement = (PreparedStatement) DbConnection
					.createConnection()
					.prepareStatement(
							"SELECT EmployeeName, Mail from employeedetails WHERE Mail != ? and Organisation = (select Organisation from employeedetails where Mail = ?)");
			HttpSession session = request.getSession();
			statement.setString(1, (String) session.getAttribute("mail"));
			statement.setString(2, (String) session.getAttribute("mail"));
			ResultSet result = statement.executeQuery();
			request.setAttribute("list", result);
			request.getRequestDispatcher("friend.jsp").forward(request,
					response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
