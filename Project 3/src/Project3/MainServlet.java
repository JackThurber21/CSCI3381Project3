// Jack Thurber
// CSCI 3381 Project 3
package Project3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project1.Patient;
import project1.PatientCollection;
import project1.PatientCollectionADT;


/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientCollection myPats;
	private String id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// constructor for the patient collection from project 1
		myPats = new PatientCollection();
		id ="";
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// This if checks login info
		if (request.getParameter("doLogin") != null) {
			RequestDispatcher rd;
			String name = request.getParameter("username"); 
			String password = request.getParameter("psw");
			if (name.equals("md") && password.equals("pw")) {
				//String label1="selectionList"; 
				String label1Value = "<select name=\"ids\">"; 
				String[] tokens = myPats.toString().split("\n");
				for (int i = 0; i < tokens.length; i++) {
					label1Value += "<option value = \""+tokens[i]+"\">"+tokens[i]+"</option>";
				}			
				label1Value += "</select>"; 
				request.setAttribute("myPatients",label1Value); 
				rd = request.getRequestDispatcher("/Using.jsp");
				rd.forward(request, response); 
			}
			else if(name != "md" || password != "pw"){
				// Redirect to login page
				response.getWriter().append("<meta http-equiv='refresh' content='3;URL=ProjectIndex.html'>"
						+ "<p style='color:red;'>Username or password is incorrect, try again</p>");
			}
		}
		// Goes back to the log in page
		if (request.getParameter("doLogout") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/ProjectIndex.html");   
			rd.forward(request, response);
		}
		// Moves to the modify patient jsp file
		if (request.getParameter("Modpat") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Modifypat.jsp");
			rd.forward(request, response);
		}
		// pushes the modifications through to the patient and returns to using.jsp
		if(request.getParameter("modButton") != null) {
			String label1Value = "<select name=\"ids\">"; 
			String[] tokens = myPats.toString().split("\n");
			for (int i = 0; i < tokens.length; i++) {
				label1Value += "<option value = \""+tokens[i]+"\">"+tokens[i]+"</option>";
			}			
			label1Value += "</select>"; 
			request.setAttribute("myPatients",label1Value); 
			RequestDispatcher rd = request.getRequestDispatcher("/Using.jsp");
			rd.forward(request, response);
		}
		// moves to the deletion jsp file
		if(request.getParameter("DelPat") != null) {
			String label1Value = "<select name=\"ids\">"; 
			String[] tokens = myPats.toString().split("\n");
			for (int i = 0; i < tokens.length; i++) {
				label1Value += "<option value = \""+tokens[i]+"\">"+tokens[i]+"</option>";
			}			
			label1Value += "</select>"; 
			request.setAttribute("myPatients",label1Value); 
			RequestDispatcher rd = request.getRequestDispatcher("/DelPat.jsp");
			rd.forward(request, response);
		}
		// deletes the patient and sends the user back to using.jsp
		if(request.getParameter("delButton") != null) {
			
			String label1Value = "<select name=\"ids\">"; 
			String[] tokens = myPats.toString().split("\n");
			for (int i = 0; i < tokens.length; i++) {
				label1Value += "<option value = \""+tokens[i]+"\">"+tokens[i]+"</option>";
			}			
			label1Value += "</select>"; 
			request.setAttribute("myPatients",label1Value);
			myPats.removePatient(id);
			RequestDispatcher rd = request.getRequestDispatcher("/Using.jsp");
			rd.forward(request, response);
		}
		// takes the user back to using.jsp without making changes
		if(request.getParameter("backButton") != null) {
			String label1Value = "<select name=\"ids\">"; 
			String[] tokens = myPats.toString().split("\n");
			for (int i = 0; i < tokens.length; i++) {
				label1Value += "<option value = \""+tokens[i]+"\">"+tokens[i]+"</option>";
			}			
			label1Value += "</select>"; 
			request.setAttribute("myPatients",label1Value); 
			RequestDispatcher 
			rd = request.getRequestDispatcher("/Using.jsp");
			rd.forward(request, response); 
		}
	}
}








