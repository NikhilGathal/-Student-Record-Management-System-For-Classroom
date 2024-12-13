package ClassroomManagementSystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassroomManagementSystem.dao.StudentDao;
import ClassroomManagementSystem.dto.Student;


@WebServlet("/edit")
public class Editservlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String course = req.getParameter("course");
		long phone = Long.parseLong(req.getParameter("phone"));
		int fees = Integer.parseInt(req.getParameter("fees"));
		int remainfees = Integer.parseInt(req.getParameter("remainfees"));
		int paidfees = Integer.parseInt(req.getParameter("paidfees"));
		
		ServletContext context = getServletContext();
		
		
		String course1 = req.getParameter("course1");
		String course2 = req.getParameter("course2");
		String course3 = req.getParameter("course3");
		String course4 = req.getParameter("course4");
		
		List<String> c1 = new ArrayList<String>();
		c1.add(course1);
		c1.add(course2);
		c1.add(course3);
		c1.add(course4);
		
//		String course5 = "";
		
		
		System.out.println("course we got from disp" + course);
		
		for (String string : c1) {
			if(string != null )
			{
				course = course + "," + string  ; 
			}
		}
	
		
		System.out.println("course selected in edit page" + course);
		
		
		String c [] = course.split(",");
		
		int totalf = 0;
		for (String string : c) {
			
			if(string != null)
			{
				System.out.println(string);
				totalf = totalf + Integer.parseInt(context.getInitParameter(string));
				remainfees = totalf - paidfees;
			}
			
			
		}
		
		System.out.println("total fees is" + totalf);
		System.out.println("remain fees" + remainfees);
		System.out.println("paid fees " + paidfees);
		
		StudentDao dao = new StudentDao();
		List<Student> students = dao.getAllStudents();
		boolean value = true;
		//System.out.println(email);
		for (Student student : students) {
//			System.out.println(student.getEmail());
			if (email.equals(student.getEmail())) {
//				email is already present
				if (student.getId() == id) {
//					means it is id of the person im updating
					break;
				} else
				{
//					others email
					value = false;
					break;
				}
			}
		}
		Student student = new Student();
		int f = 0;
		//int remainfees = 0;
		
		
//		if(course.equals("Java"))
//		{
//			f = Integer.parseInt(context.getInitParameter("Java"));
//			student.setFees(f);
//			System.out.println("Java fees is "  +  f);
//			System.out.println("Paid fees" +  paidfees);
//			remainfees = f - paidfees;
//			System.out.println("Remain fees is "  +  remainfees);
//		}
//		else if(course.equals("Python"))
//		{
//			f = Integer.parseInt(context.getInitParameter("Python"));
//			student.setFees(f);
//			System.out.println("Python fees is "  +  f);
//			System.out.println("Paid fees" + paidfees);
//			remainfees = f - paidfees;
//			System.out.println("Remain fees is "  +  remainfees);
//		}
//		else if(course.equals("MERN"))
//		{
//			f = Integer.parseInt(context.getInitParameter("MERN"));
//			student.setFees(f);
//			System.out.println("MERN fees is "  +  f);
//			System.out.println("Paid fees" +  paidfees);
//			remainfees = f - paidfees;
//			System.out.println("Remain fees is "  +  remainfees);
//		}
//		else if(course.equals("Devops"))
//		{
//			f = Integer.parseInt(context.getInitParameter("Devops"));
//			student.setFees(f);
//			System.out.println("Devops fees is "  +  f);
//			System.out.println("Paid fees" +  paidfees);
//			remainfees = f - paidfees;
//			System.out.println("Remain fees is "  +  remainfees);
//		}
		
		
		
		
		
		
//		Student student = new Student();
		student.setAddress(address);
		student.setEmail(email);
		student.setFees(totalf);
		student.setId(id);
		student.setName(name);
		student.setCourse(course);
		student.setPhone(phone);
		student.setRemainfees(remainfees);
		student.setPaidfees(paidfees);

		

		if (value) {
			
			dao.updateStudent(student);
			req.setAttribute("list", students);
			resp.sendRedirect("display");
//			resp.sendRedirect("display.jsp");
//			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
//			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("message", "Email already exist");
			req.setAttribute("student", dao.findStudentById(id));
			RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
			dispatcher.include(req, resp);
		}

	}

}
