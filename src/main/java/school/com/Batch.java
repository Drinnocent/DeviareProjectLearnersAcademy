package school.com;

public class Batch {
	private int idbatch;
	private String classId;
	private String  idsubject;
	private String idteacher;
	public Batch() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public Batch(int idbatch, String classId, String idsubject, String idteacher) {
		super();
		this.idbatch = idbatch;
		this.classId = classId;
		this.idsubject = idsubject;
		this.idteacher = idteacher;
	}
	public int getIdbatch() {
		return idbatch;
	}
	public void setIdbatch(int idbatch) {
		this.idbatch = idbatch;
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
	public String getIdteacher() {
		return idteacher;
	}
	public void setIdteacher(String idteacher) {
		this.idteacher = idteacher;
	}
	
	

}
