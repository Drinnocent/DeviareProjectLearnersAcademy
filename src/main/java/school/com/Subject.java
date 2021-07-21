package school.com;

public class Subject {

	private String idsubject;
	private String name;
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(String idsubject, String name) {
		super();
		this.idsubject = idsubject;
		this.name = name;
	}
	public String getIdsubject() {
		return idsubject;
	}
	public void setIdsubject(String idsubject) {
		this.idsubject = idsubject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
