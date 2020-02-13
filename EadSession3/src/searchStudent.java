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

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class searchStudent
 */
@WebServlet("/searchStudent")
public class searchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Search Result</title>");
		String showClass = request.getParameter("classText");
		String query = null;
		String message="";
		//Executed if search button is clicked.
		if (showClass == null) {
			String searchTextFirstName = request
					.getParameter("searchByFirstName");
			String searchTextLastName = request
					.getParameter("searchByLastName");
			searchTextFirstName = searchTextFirstName.trim();
			searchTextLastName = searchTextLastName.trim();

			if ((searchTextLastName.equals(""))
					&& (searchTextFirstName.equals(""))) {
				message = "At least one field should be filled.";
				sweetAlert(request, response,message);
			}

			else {
				query = selectByFirstAndLastName(searchTextFirstName,
						searchTextLastName);
			}
			out.println(query);
		}

		//Executed if show button is clicked.
		else {
			if (showClass.equals("")) {
				message = "Field can't be blank";
				sweetAlert(request, response,message);
			} else {
				query = selectByClass(showClass);
			}
		}
		Connection connection = null;
		try {
			connection = DbConnection.createConnection();
			Statement statement = (Statement) connection.createStatement();

			ResultSet resultTable = statement.executeQuery(query);

			int count =0;
			while (resultTable.next()) {
				out.print("<table border='1'>");
				out.print("<tr><th>First Name</th><th>Last Name</th><th>Father's Name</th><th>Mail</th><th>Class></th><th>Age</th></tr>");
				out.print("<tr><td>" + resultTable.getString("FirstName")
						+ "</td><td>" + resultTable.getString("LastName")
						+ "</td>" + "<td>"
						+ resultTable.getString("NameOfFather") + "</td><td>"
						+ resultTable.getString("MailId") + "</td><td>"
						+ resultTable.getString("Class") + "</td><td>"
						+ resultTable.getString("Age") + "</td></tr>");
				count=1;
			}
			out.print("</table></body></html>");

			if (count ==0){
				message = "Data not found.";
				sweetAlert(request, response,message);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void sweetAlert(HttpServletRequest request,
			HttpServletResponse response, String message) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		out.println("<script>$(document).ready(function(){swal("+message+",'Unsuccessfull !', 'error')});</script>");
		request.getRequestDispatcher("searchStudent.html").include(request,
				response);
		;
	}

	private String selectByFirstAndLastName(String searchTextFirstName,
			String searchTextLastName) {
		String query = "select * from studentdetails where FirstName='"
				+ searchTextFirstName + "'or LastName='" + searchTextLastName
				+ "'";
		return query;
	}

	private String selectByClass(String showClass) {
		String query = "select * from studentdetails where Class='" + showClass
				+ "'";
		return query;
	}

}
