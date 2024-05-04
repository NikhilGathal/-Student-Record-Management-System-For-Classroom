package ClassroomManagementSystem.controller;

import java.io.IOException;
import java.util.ArrayList;
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


@WebServlet("/signup")
public class Signupservlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");

		String course1=req.getParameter("course1");
		String course2=req.getParameter("course2");
		String course3=req.getParameter("course3");
		String course4=req.getParameter("course4");
		
		
		
		List<String> c = new ArrayList<String>();
		c.add(course1);
		c.add(course2);
		c.add(course3);
		c.add(course4);
		
		ServletContext context = getServletContext();
		int f = 0;
		int remainfees = 0;
		int paidfees=Integer.parseInt(req.getParameter("fees"));
		
		
		String course = "" ;
		
		
		
		for (String string : c) {
			if(string != null)
			{
				
				course = course  + string + ",";
				
				System.out.println(string);
			f = f + Integer.parseInt(context.getInitParameter(string));
//				System.out.println("Java fees is "  +  f);
//				System.out.println("Paid fees");
				remainfees = f - paidfees;
				System.out.println("Remain fees is "  +  remainfees);
				
			}
		}
		
		String x = "";
		for(int i=0;i<course.length();i++)
		{
			if(i == course.length()-1)
			{
				
			}
			else
			{
				x = x + course.charAt(i);
			}
		}
		
		
		System.out.println("course is" + x);
		
		
		
//		
//		if(course1 != null)
//		{
//			 course = req.getParameter("course1");
//			 System.out.println(course);
//		}
//		else if(course2 != null)
//		{
//			 course = req.getParameter("course2");
//			 System.out.println(course);
//		}
//		else if(course3 != null)
//		{
//			 course = req.getParameter("course3");
//			 System.out.println(course);
//		}
//		else
//		{
//			 course = req.getParameter("course4");
//			 System.out.println(course);
//		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		long phone=Long.parseLong(req.getParameter("phone"));
//		int paidfees=Integer.parseInt(req.getParameter("fees"));
		
//		ServletContext context = getServletContext();
//		int f = 0;
//		int remainfees = 0;
//		
//		
//		if(course.equals("Java"))
//		{
//			f = Integer.parseInt(context.getInitParameter("Java"));
//			System.out.println("Java fees is "  +  f);
//			System.out.println("Paid fees");
//			remainfees = f - fees;
//			System.out.println("Remain fees is "  +  remainfees);
//		}
//		else if(course.equals("Python"))
//		{
//			f = Integer.parseInt(context.getInitParameter("Python"));
//			System.out.println("Python fees is "  +  f);
//			System.out.println("Paid fees" + fees);
//			remainfees = f - fees;
//			System.out.println("Remain fees is "  +  remainfees);
//		}
//		else if(course.equals("MERN"))
//		{
//			f = Integer.parseInt(context.getInitParameter("MERN"));
//			System.out.println("MERN fees is "  +  f);
//			System.out.println("Paid fees" + fees);
//			remainfees = f - fees;
//			System.out.println("Remain fees is "  +  remainfees);
//		}
//		else if(course.equals("Devops"))
//		{
//			f = Integer.parseInt(context.getInitParameter("Devops"));
//			System.out.println("Devops fees is "  +  f);
//			System.out.println("Paid fees" + fees);
//			remainfees = f - fees;
//			System.out.println("Remain fees is "  +  remainfees);
//		}
//		else 
//		{
//			f = 0;
//			remainfees = 0;
//		}
		
		
		
		
		Student student=new Student();
		student.setAddress(address);
		student.setEmail(email);
		student.setFees(f);
		student.setName(name);
		student.setPhone(phone);
		student.setCourse(x);
		student.setPaidfees(paidfees);
		student.setRemainfees(remainfees);
		
		
		
//		first i need to check whether this email is already present in the
//		database or not if it is present then i wont t=save this data 
//		if its not present means ill save the data
		
		StudentDao studentDao=new StudentDao();
		List<Student> list=studentDao.getAllStudents();
		boolean value=true;
		for(Student st:list) {
			if(email.equals(st.getEmail())) {
				value=false;
				break;
			}
		}
		
		if(value) {
//			value=true  if that email doesnot exist in the database
//			sign up
			studentDao.saveStudent(student);
			List<Student> list1=studentDao.getAllStudents();
			req.setAttribute("list", list1);
//			req.setAttribute("message","Student Added Successfully");
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}
		
		else {
//			value=false if that email already exist in the db
			req.setAttribute("message", "Student already exist ");
			RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
			dispatcher.include(req, resp);
			
		}
		
		
	}

}
