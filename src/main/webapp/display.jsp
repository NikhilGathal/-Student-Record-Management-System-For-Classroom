<%@page import="ClassroomManagementSystem.dto.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<style>
/* General styles */
a {
	text-decoration: none;
	color: red;
}

button {
	color: white;
	border-radius: 10px;
	padding: 15px 35px;
	font-size: 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	background-color: rgb(0, 128, 11);
	border: none;
}

body {
	background-color: grey;
	color: white;
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
}

.container {
	max-width: 1200px;
	margin-inline: auto;
	padding: 10px;
}

/* Header styles */
h1 {
	text-align: center;
}

/* Button positioning */
#s {
	margin: 10px;
}

#l {
	margin: 10px;
	float: right;
}

/* Table styles */
table {
	border-collapse: collapse;
	width: 100%;
	margin: 20px 0;
	background-color: #2c3e50;
}

th, td {
	padding: 15px;
	text-align: center;
}

th {
	background-color: #34495e;
}

tr:nth-child(even) {
	background-color: #1abc9c;
}

tr:nth-child(odd) {
	background-color: #16a085;
}

/* Icon styles */
.icon {
	font-size: 20px;
}

/* Responsive styles */
@media (max-width: 768px) {
	button {
		font-size: 12px;
		padding: 10px 20px;
	}

	th, td {
		padding: 10px;
		font-size: 14px;
	}

	.icon {
		font-size: 16px;
	}

	table {
		font-size: 12px;
	}
}
</style>
</head>
<body>

	<div class="container">
		<h1>Student List</h1>

		<button id="l" onclick="redirectToFirstPage()">Logout</button>
		<button id="s" onclick="redirectToSecondPage()">Add New Student</button>

		<br><br>

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
			// Get the student list from the request
			List<Student> students = (List<Student>) request.getAttribute("list");
			if (students != null && !students.isEmpty()) {
		%>
			<table border="10px" cellspacing="15px" cellpadding="15px">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Address</th>
					<th>Email</th>
					<th>Course</th>
					<th>Phone</th>
					<th>Total Fees</th>
					<th>Paid Fees</th>
					<th>Remaining Fees</th>
					<th>Delete</th>
					<th>Update</th>
				</tr>

				<%
				// Loop through students and display them in the table
				for (Student student : students) {
				%>
					<tr>
						<td><%=student.getId()%></td>
						<td><%=student.getName()%></td>
						<td><%=student.getAddress()%></td>
						<td><%=student.getEmail()%></td>
						<td><%=student.getCourse()%></td>
						<td><%=student.getPhone()%></td>
						<td><%=student.getFees()%></td>
						<td><%=student.getPaidfees()%></td>
						<td><%=student.getRemainfees()%></td>
						<td><a href="delete?id=<%=student.getId()%>"><i class="a fa-solid fa-trash fa-2xl icon"></i></a></td>
						<td><a href="update?id=<%=student.getId()%>"><i class="a fa-regular fa-pen-to-square fa-2xl icon"></i></a></td>
					</tr>
				<%
				}
				%>
			</table>
		<% 
			} else { 
		%>
			<h1 style="text-align:center;">No students found.</h1>
		<% 
			}
		%>
	</div>

</body>
</html>