import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editDetails
 */
@WebServlet("/editDetails")
public class editDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editDetails() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String fatherName = request.getParameter("nameOfFather");
		String emailid = request.getParameter("studentmailid");
		String studentClass = request.getParameter("studentClass");
		String age = request.getParameter("studentAge");

		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Edit Student Details</title></head><body><form action='updateStudentDetails' method='POST' >"
				+ "<div>First Name</div><div><input type='text' name='editfirstNameOfStudent' placeholder='Enter first name' value='"
				+ fname
				+ "'></div><div>Last Name</div><div><input type='text' name='editlastNameOfStudent' value='"
				+ lname
				+ "'placeholder='Enter last name'>"
				+ "</div><div>Father's Name</div><div><input type='text' name='editnameOfFather' value='"
				+ fatherName
				+ "'placeholder='Enter father's name'></div><div>E-Mail</div><div><input type='email' name='editmail' value='"
				+ emailid
				+ "'placeholder='Enter mail-ID'>"
				+ "</div><div>Class</div><div><input type='number' name='editclassOfStudent' value='"
				+ studentClass
				+ "' placeholder='Enter class'></div><div>Age</div><div><input type='number' name='editageOfStudent' value='"
				+ age
				+ "' placeholder='Enter age'></div>"
				+ "<div><input type='submit' onClick='return validate()'></div></form>");
	}

}
