package wdsr.exercise5.schema;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wdsr.exercise5.data_model.Student;

public class StudentConnection {
	
	private static final Logger log = LoggerFactory.getLogger(StudentConnection.class);
	
	public static void createTable(Connection connection){
		try {
			connection.prepareStatement("CREATE TABLE Student (" +
			        "id INTEGER PRIMARY KEY generated always as identity (START WITH 1), name VARCHAR(20)," + 
					"sex VARCHAR(10), age INTEGER, level INTEGER)").executeUpdate();
			log.info("Created table Student");
		} catch (SQLException e) {
			log.error("operation 'create table' was failed");
			log.error(e.getMessage());
		}
	}
	
	public static void insertElement(Connection connection, Student student){
		try {
			connection.prepareStatement("INSERT INTO Student (name, sex, age, level)" +
			        " VALUES(" + "'" + student.getName() + "'," + "'" + student.getSex() + "'," +
			        student.getAge() + "," + student.getLevel() + ")").executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}
	
	public static void dropTable(Connection connection){
		try {
			connection.prepareStatement("DROP TABLE IF EXISTS Student").executeUpdate();
		} catch (SQLException e) {
			log.error("Deleting was failed - " + e.getMessage());
		}
	}
}
