package wdsr.exercise5.data_model;

public class ClassTab {
	private int id;
	private String name;
	private int faculty_key_id;
	
	public ClassTab() {
		super();
	}
	
	public ClassTab(String name, int faculty_key_id) {
		super();
		this.name = name;
		this.faculty_key_id = faculty_key_id;
	}
	
	public ClassTab(int id, String name, int faculty_key_id) {
		super();
		this.id = id;
		this.name = name;
		this.faculty_key_id = faculty_key_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFaculty_key_id() {
		return faculty_key_id;
	}

	public void setFaculty_key_id(int faculty_key_id) {
		this.faculty_key_id = faculty_key_id;
	}
}
