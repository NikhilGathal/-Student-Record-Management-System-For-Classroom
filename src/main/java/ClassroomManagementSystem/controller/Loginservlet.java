package ClassroomManagementSystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassroomManagementSystem.dao.StudentDao;
import ClassroomManagementSystem.dto.Student;




@WebServlet("/login")
public class Loginservlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		StudentDao studentDao = new StudentDao();
		List<Student> list = studentDao.getAllStudents();
		Student student = new Student();
		
		
		//System.out.println(student.getCourse());
		
		if(email.equals("nikhilgathal@gmail.com") )
		{
			
			if(password.equals("@Nikhil77"))
			{
				req.setAttribute("list", list);
//				resp.sendRedirect("display.jsp");
				resp.sendRedirect("display");
//				RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
//				dispatcher.forward(req, resp);
			}
			
			else	
			{
				req.setAttribute("message", "Invalid Password");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
			
		}else
		{
			req.setAttribute("message", "Invalid Email");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
		
		
		
	}	

		
}
