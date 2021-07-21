package school.com;

public class GradeClass {

	private String classId;
	private String name;
	public GradeClass() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public GradeClass(String classId, String name) {
		super();
		this.classId = classId;
		this.name = name;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
