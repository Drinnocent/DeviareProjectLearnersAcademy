<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="content.css" rel="stylesheet" type="text/css">
</head>
<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

table, th, td {
	padding: 5px;
	margin-left: auto;
	margin-right: auto;
}
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
<body>
	<div class="navbar">
		<a class="active" href="#">Home</a> <a href="addSubject.jsp">Add
			Subject</a> <a href="addTeacher.jsp">Add Teacher</a> <a
			href="addStudent.jsp">Add Student</a> <a href="assign.jsp">Assign</a>
		<a href="#">Logout</a>
	</div>
	<h1>
		Welcome :<%=session.getAttribute("email")%></h1>
	<div>

		<table width="80%">

			<tr>
				<td>
					<h2>Assign Subjects To Class</h2>
					<form action='AssignServlet' method="post">
						<label for="country">Choose Subject</label> <select name="subject">
							<c:forEach items="${subjectlist}" var="sub" varStatus="loop">
								<option value="${sub.idsubject}">${sub.idsubject}</option>
							</c:forEach>
						</select> <label for="country">Choose Class</label> <select name="class">
							<c:forEach items="${classlist}" var="cl" varStatus="loop">
								<option value="${cl.classId}">${cl.classId}</option>
							</c:forEach>
						</select><input type="submit" value="Submit" name="classandsubject">
					</form>
				</td>
			</tr>
			<tr>

				<td>
					<h2>Assign Teacher To Class and Assign Teacher To Subjects</h2>
					<form action='AssignTeacherServlet' method="post">
						<label for="country">Select Teacher</label> <select name="teacher">
							<c:forEach items="${teacherlist}" var="tec" varStatus="loop">
								<option value="${tec.idteacher}">${tec.idteacher}</option>
							</c:forEach>
						</select> 
						
						<label for="country">Assign Teacher To Class</label> <select
							name="class2">
							<c:forEach items="${classlist}" var="cl" varStatus="loop">
								<option value="${cl.classId}">${cl.classId}</option>
							</c:forEach>
						</select>
						
						<label for="country">Show Available Subject</label> <select
							name="subject2">
							<c:forEach items="${subjectlist}" var="sub" varStatus="loop">
								<option value="${sub.idsubject}">${sub.idsubject}</option>
							</c:forEach>
						</select> <input type="submit" value="Submit" name="button2">
					</form>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>
