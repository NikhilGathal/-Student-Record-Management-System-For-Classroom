<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
body {
	font-family: sans-serif;
	margin: 0;
	padding: 20px;
}

.container {
	width: 400px;
	margin: 0 auto;
	border: 1px solid #ccc;
	padding: 20px;
	border-radius: 5px;
}

h1 {
	text-align: center;
}

label {
	display: block;
	margin-bottom: 5px;
}

input[type="text"], input[type="email"], input[type="password"] {
	width: 90%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	margin-bottom: 10px;
}

#button {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

#button:hover {
	opacity: 0.8;
}
</style>

</head>
<body>


	<%
	String message = (String) request.getAttribute("message");
	%>
	<%
	if (message != null) {
	%>
	<h1><%=message%></h1>
	<%
	} else {
	%>
	<h1 align="center"><%="Please fill the details"%></h1>
	<%
	}
	%>


	<div class="container">

		<form action="signup" method="post">
			<label for="name">Name:</label> <input type="text" id="name"
				name="name" placeholder="Enter name"> <br> <label
				for="email">Email:</label> <input type="email" id="email"
				name="email" placeholder="Enter email"> <br> <label
				for="address">Address:</label> <input type="text" id="address"
				name="address" placeholder="Enter address"> <br>

			
				<input type="checkbox" id="course1" name="course1" value="Java">
				<label for="course1"> Java</label>
				<input type="checkbox"id="course2" name="course2" value="Python"> 
				<label for="course2"> Python</label>
				<input type="checkbox" id="course3"name="course3" value="MERN"> 
				<label for="course3">MERN</label>
				<input type="checkbox" id="course4" name="course4" value="Devops"> 
				<label for="course4"> Devops</label>
			
			<br> <label for="phone">Phone:</label> <input type="number"
				id="phone" name="phone" placeholder="Enter phoneno"> <br>
			<br> <label for="fees">Fees:</label> <input type="number"
				id="fees" name="fees" placeholder="Enter fees paid"> <br>
			<br> <input id="button" type="submit" value="Submit">
		</form>
	</div>

</body>
</html>