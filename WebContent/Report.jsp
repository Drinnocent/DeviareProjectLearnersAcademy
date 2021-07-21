<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#customers {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 80%;
	margin-left: auto;
	margin-right: auto;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
	padding-top: 12px;
	padding-bottom: 12px;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}

h1 {
	background-color: black;
	color: white;
	font-family: Arial, Helvetica, sans-serif;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}
* {box-sizing: border-box}
body {font-family: Arial, Helvetica, sans-serif;}

.navbar {
  width: 100%;
  background-color: #555;
  overflow: auto;
}

.navbar a {
  float: left;
  padding: 12px;
  color: white;
  text-decoration: none;
  font-size: 17px;
  width: 15%; /* Four links of equal widths */
  text-align: center;
}

.navbar a:hover {
  background-color: #000;
}

.navbar a.active {
  background-color: #04AA6D;
}

@media screen and (max-width: 500px) {
  .navbar a {
    float: none;
    display: block;
    width: 100%;
    text-align: left;
  }
}
</style>
</head>
<body>

<div class="navbar">
  <a class="active" href="#">Home</a> 
  <a href="addSubject.jsp">Add Subject</a> 
  <a href="addTeacher.jsp">Add Teacher</a> 
   <a href="addStudent.jsp">Add Student</a> 
    <a href="assign.jsp">Assign</a> 
  <a href=logout>Logout</a>
</div>
<h5>Welcome :<%=session.getAttribute("email")%></h5>

	<h1>SCHOOL REPORT</h1>

	<div>
		<table id="customers">
			<tr>
				<th>Student Number</th>
				<th>Student Name</th>
				<th>Last Name</th>
				<th>ID Number</th>
				<th>Student Grade</th>
			</tr>
			<c:forEach items="${studentlist}" var="cl">
				<tr>
					<td>${cl.idstudent}</td>
					<td>${cl.firstName}</td>
					<td>${cl.lastName}</td>
					<td>${cl.idNumber}</td>
					<td>${cl.classId}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<table id="customers">
			<tr>
				<th>Initials</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Id Number</th>
			</tr>
			<c:forEach items="${teacherlist}" var="cl">
				<tr>
					<td>${cl.idteacher}</td>
					<td>${cl.firstname}</td>
					<td>${cl.lastName}</td>
					<td>${cl.idNumber}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<table id="customers">
			<tr>
				<th>Grade no.</th>
				<th>Grade Name</th>
			</tr>
			<c:forEach items="${classlist}" var="cl">
				<tr>
					<td>${cl.classId}</td>
					<td>${cl.name}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<table id="customers">
			<tr>
				<th>Teacher</th>
				<th>Grade</th>
				<th>Subject</th>
		
				
			</tr>
			<c:forEach items="${batchlist}" var="cl">
				<tr>
					<td>${cl.idteacher}</td>
					<td>${cl.classId}</td>
					<td>${cl.idsubject}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<table id="customers">
			<tr>
				<th>Subject Code</th>
				<th>Subject Name</th>
			</tr>
			<c:forEach items="${subjectlist}" var="cl">
				<tr>
					<td>${cl.idsubject}</td>
					<td>${cl.name}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>