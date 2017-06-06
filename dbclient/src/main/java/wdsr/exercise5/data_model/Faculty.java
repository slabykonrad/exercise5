package wdsr.exercise5.data_model;

public class Faculty {
	private int id;
	private String name;
	
	public Faculty() {
		super();
	}
	
	public Faculty(String name) {
		super();
		this.name = name;
	}
	
	public Faculty(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
