package school.com;

public class ClassCourse {
	private int idclasssubject;
	private String classId;
	private String idsubject;
	
	
	public ClassCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassCourse(int idclasssubject, String classId, String idsubject) {
		this.idclasssubject = idclasssubject;
		this.classId = classId;
		this.idsubject = idsubject;
	}

	public int getIdclasssubject() {
		return idclasssubject;
	}

	public void setIdclasssubject(int idclasssubject) {
		this.idclasssubject = idclasssubject;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getIdsubject() {
		return idsubject;
	}

	public void setIdsubject(String idsubject) {
		this.idsubject = idsubject;
	}
	
	
	
	

}
