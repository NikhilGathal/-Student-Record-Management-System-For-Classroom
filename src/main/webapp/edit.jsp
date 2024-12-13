<%@page import="ClassroomManagementSystem.dto.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>

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
  position:relative;
  left : 10px;
}

.checkbox-group {
    display: flex;
    flex-wrap: wrap; /* Ensures they wrap to the next line if the screen width is too small */
    gap: 15px; /* Space between items */
}

.checkbox-group label {
    margin-left: 5px;
}

input[type="text"],
input[type="email"],
input[type="password"] {
  width: 90%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
  margin-bottom: 10px;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
}

    </style>



</head>





<body>


	<%
		String message = (String) request.getAttribute("message");
		%>
		
		

		<h1 align="center"> <%=message %>  </h1>
		

		
		<%Student student = (Student) request.getAttribute("student");  %>
		
		
		
	
		
		
		
		
		 <div class="container">

    <form action="edit" method="post"> 
    <label>Id:</label>
    <input type="text" name ="id" value="<%=student.getId()%>" 	readonly="readonly">
     <br>
    <label for="name">Name:</label>
      <input type="text" id="name" value="<%=student.getName()%>" name="name" placeholder="Enter  name">
      <br>
      <label for="email">Email:</label>
      <input type="email" id="email" value="<%=student.getEmail()%>" name="email" placeholder="Enter  email">
      <br>
      <label for="course">Course:</label>
    	<input type=text id="course" name="course" value="<%=student.getCourse()%>">
    	
        
        
   <div class="checkbox-group">
    <div>
        <input type="checkbox" id="course1" name="course1" value="Java"
            <%= student.getCourse().contains("Java") ? "checked disabled" : "" %> />
        <label for="course1">Java</label>
    </div>
    <div>
        <input type="checkbox" id="course2" name="course2" value="Python"
            <%= student.getCourse().contains("Python") ? "checked disabled" : "" %> />
        <label for="course2">Python</label>
    </div>
    <div>
        <input type="checkbox" id="course3" name="course3" value="MERN"
            <%= student.getCourse().contains("MERN") ? "checked disabled" : "" %> />
        <label for="course3">MERN</label>
    </div>
    <div>
        <input type="checkbox" id="course4" name="course4" value="Devops"
            <%= student.getCourse().contains("Devops") ? "checked disabled" : "" %> />
        <label for="course4">Devops</label>
    </div>
</div>

  <br>
     
      
      
      
      
       <label for="fees">Total Fees:</label>
      <input type="text" id="fees" value="<%=student.getFees()%>" name="fees" placeholder="Enter fees" readonly="readonly">
      <br>
      <label for="address">Address:</label>
      <input type="text" id="address" value="<%=student.getAddress()%>" name="address" placeholder="Enter  address">
      <br>
      <label for="phone">Phone:</label>
      <input type="text" id="phone" value="<%=student.getPhone()%>" name="phone" placeholder="Enter  phoneno">
      <br>
      
      <label for="paid">Paidfees:</label>
      <input type="text" id="paid" value="<%=student.getPaidfees()%>" name="paidfees" placeholder="Enter  Paidfees">
      <br>
      
      <label for="remain">Remainfees:</label>
      <input type="text" id="remain" value="<%=student.getRemainfees()%>" name="remainfees" placeholder="Enter  remainfees" readonly="readonly">
      <br><br>
      
      
      
      
      
      
      
      
      <button type="submit">Save</button>
    </form>
  </div>

</body>
</html>