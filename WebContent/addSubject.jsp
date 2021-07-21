<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
</style>
<body>
<div class="navbar">
  <a class="active" href="#">Home</a> 
  <a href="addSubject.jsp">Add Subject</a> 
  <a href="addTeacher.jsp">Add Teacher</a> 
   <a href="addStudent.jsp">Add Student</a> 
    <a href="assign.jsp">Assign</a> 
  <a href="logout">Logout</a>
</div>

<div>
  <form action="addSubject" method='post'>
    <label for="fname">Subject Code</label>
    <input type="text" id="fname" name="subjectCode" placeholder="Enter subject Code">

    <label for="lname">Subject Name</label>
    <input type="text" id="lname" name="subjectName" placeholder="Enter subject name">
  
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>

