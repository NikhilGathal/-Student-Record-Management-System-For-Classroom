<%@page import="ClassroomManagementSystem.dto.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<style>
        a 
        {
            text-decoration: none;
           color: red;
        }
      
        button
        {
    color: white;
    border-radius: 10px;
    padding-left: 35px;
    padding-right: 35px;
    padding-top: 15px;
    padding-bottom: 15px;
    font-size: 15px;
    font-family: Arial, Helvetica, sans-serif;
    font-weight: bold;
    background-color: rgb(0, 128, 11);
   
    border: none;
        }

        #s
        {
            position: relative;
           
            left: 100px;  
        }

        #l
        {
            position: relative;
           
            left: 1200px;
        }


        h1
        {
            text-align: center;
        }
        
        .a 
        {
        	position: relative;
        	left : 10px;	
        	background-color : rgb(202, 33, 33);
        
        }
        
         body
        {
            background-color: brown;
            color : white;
        }
        
        
        
    </style>
</head>
<body>

	<h1>Student List</h1>

	<button id="l" onclick="redirectToFirstPage()">Logout</button>
 <button id="s" onclick="redirectToSecondPage()">Add New Student</button>
 
 <br> <br>
 

    <!-- JavaScript function to redirect -->
    <script>
        function redirectToSecondPage() {
            window.location.href = 'signup.jsp';
        }
        
        function redirectToFirstPage() {
            window.location.href = 'login.jsp';
        }
        
    </script>
    
    
   




<%
	List<Student> list = (List) request.getAttribute("list");
	%>
	
	
	<% if(list == null) { %>
	
	<%= "Welcome to display page please come from login page" %>
	
	<% } else { %>
	
	
	
	<table border="10px" align="center" cellspacing="15px"
		cellpadding="15px">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
			<th>Course</th>
			<th>Phone</th>
			<th>Total Fees</th>
			<th>Paid Fees</th>
			<th>Reamin Fees</th>
			<th>Delete</th>
			<th>Update</th>
			
		</tr>


		<%
		for (Student student : list) {
		%>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getAddress()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getCourse()%></td>
			<td><%=student.getPhone()%></td>
			<td><%=student.getFees() %></td>
			<td><%=student.getPaidfees() %></td>
			<td><%=student.getRemainfees() %></td>
			
			<td><a href="delete?id=<%=student.getId()%>"> <i class=" a fa-solid fa-trash fa-2xl" style="color: #74C0FC;"></i>  </a></td>
			<td><a href="update?id=<%=student.getId()%>"><i class=" a fa-regular fa-pen-to-square fa-2xl" style="color: #74C0FC;"></i></a></td>
		</tr>
		<%
		}
		%>
		
		<% } %>
	</table>


</body>
</html>