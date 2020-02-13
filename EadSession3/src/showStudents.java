import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class showStudents
 */
@WebServlet("/showStudents")
public class showStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public showStudents() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Connection connection = DbConnection.createConnection();

		PrintWriter out = response.getWriter();

		String query = "select * from studentdetails";

		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultTable = statement.executeQuery(query);
			out.print("<html><head><title>Student Details</title></head><body>");
			out.print("<table border='1'><tr><th>FirstName</th><th>LastName</th><th>Father'sName</th><th>Mail Id</th><th>Class</th><th>Age</th></tr>");

			while (resultTable.next()) {
				String firstName = resultTable.getString("FirstName");
				String lastName = resultTable.getString("LastName");
				String nameOfFather = resultTable.getString("NameOfFather");
				String mail = resultTable.getString("MailId");
				int classOfStudent = resultTable.getInt("Class");
				int age = resultTable.getInt("Age");
				out.print("<tr><form action = 'editDetails' method='post'><td><input type = 'text' name='firstName' readonly  value ='"
						+ firstName
						+ "'></td><td><input type = 'text' name='lastName'  readonly value ='"
						+ lastName
						+ "'></td><td><input type = 'text' name='nameOfFather' readonly value ='"
						+ nameOfFather
						+ "'></td><td><input type = 'text' name='studentmailid' readonly value ='"
						+ mail
						+ "'></td><td><input type = 'text' name='studentClass' readonly value ='"
						+ classOfStudent
						+ "'></td><td><input type = 'text' name='studentAge' readonly value ='"
						+ age
						+ "'></td><td><input type='submit' name='submitButton' value = 'Edit'></form></td></tr>");
			}
			out.print("</table></body></html>");

			statement.close();
			connection.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
