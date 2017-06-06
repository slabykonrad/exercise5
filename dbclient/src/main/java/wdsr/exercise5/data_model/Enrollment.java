package wdsr.exercise5.data_model;

public class Enrollment {
	private int student_key_id;
	private int class_key_id;
	
	public Enrollment() {
		super();
	}

	public Enrollment(int student_key_id, int class_key_id) {
		super();
		this.student_key_id = student_key_id;
		this.class_key_id = class_key_id;
	}

	public int getStudent_key_id() {
		return student_key_id;
	}

	public void setStudent_key_id(int student_key_id) {
		this.student_key_id = student_key_id;
	}

	public int getClass_key_id() {
		return class_key_id;
	}

	public void setClass_key_id(int class_key_id) {
		this.class_key_id = class_key_id;
	}
	
	
}
