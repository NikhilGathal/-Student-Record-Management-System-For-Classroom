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

@WebServlet("/display")
public class DisplayStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create StudentDao to interact with the database
        StudentDao studentDao = new StudentDao();
        
        // Get student list from the database
        List<Student> students = studentDao.getAllStudents();

        // Set student list as a request attribute
        req.setAttribute("list", students);

        // Forward the request to display.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
        dispatcher.forward(req, resp);
//        resp.sendRedirect("display.jsp");
    }
}