package school.com;

public class Student {
	private String idstudent;
	private String classId;
	private String firstName;
	private String lastName;
	private String idNumber;
	public Student() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public Student(String idstudent, String classId, String firstName, String lastName, String idNumber) {
		super();
		this.idstudent = idstudent;
		this.classId = classId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
	}
	public String getIdstudent() {
		return idstudent;
	}
	public void setIdstudent(String idstudent) {
		this.idstudent = idstudent;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
