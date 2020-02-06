
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class updateStudentDetails
 */
@WebServlet("/updateStudentDetails")
public class updateStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateStudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection connection = DbConnection.createConnection();
		String mail = request.getParameter("editmail");
		String query = "Update studentdetails set FirstName=?, LastName=?, NameOfFather=?, MailId=?, Class=?, Age=? where MailId='"
				+ mail + "'";
		try {
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(query);
			statement.setString(1,
					request.getParameter("editfirstNameOfStudent"));
			statement.setString(2,
					request.getParameter("editlastNameOfStudent"));
			statement.setString(3, request.getParameter("editnameOfFather"));
			statement.setString(4, request.getParameter("editmail"));
			statement.setString(5, request.getParameter("editclassOfStudent"));
			statement.setString(6, request.getParameter("editageOfStudent"));
			statement.executeUpdate();
			
			out.println("Editted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
