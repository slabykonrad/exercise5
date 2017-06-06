package wdsr.exercise5.data_model;

public class Student {
	private int id;
	private String name;
	private String sex;
	private int age;
	private int level;
	
	public Student() {
		super();
	}
	
	public Student(String name, String sex, int age, int level) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.level = level;
	}

	public Student(int id, String name, String sex, int age, int level) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.level = level;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
