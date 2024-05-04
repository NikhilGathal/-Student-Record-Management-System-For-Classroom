package ClassroomManagementSystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassroomManagementSystem.dao.StudentDao;
import ClassroomManagementSystem.dto.Student;



@WebServlet("/update")
public class Updateservlet extends HttpServlet{

	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		StudentDao dao = new StudentDao();
		Student student = dao.findStudentById(id);
		
		// for cookies code
		
		req.setAttribute("message", "Welcome to edit page");
		req.setAttribute("student", student);
		RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
		dispatcher.forward(req, resp);

		
		

		
 
	}
}
