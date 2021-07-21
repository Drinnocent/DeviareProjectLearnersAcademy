package school.com;

public class Teacher {
 private String idteacher;
 private String firstname;
 private String lastName;
 private String idNumber;
public Teacher() {
	super();
	// TODO Auto-generated constructor stub
}
public Teacher(String idteacher, String firstname, String lastName, String idNumber) {
	super();
	this.idteacher = idteacher;
	this.firstname = firstname;
	this.lastName = lastName;
	this.idNumber = idNumber;
}
public String getIdteacher() {
	return idteacher;
}
public void setIdteacher(String idteacher) {
	this.idteacher = idteacher;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getIdNumber() {
	return idNumber;
}
public void setIdNumber(String idNumber) {
	this.idNumber = idNumber;
}

}
