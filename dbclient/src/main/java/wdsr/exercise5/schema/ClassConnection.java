package wdsr.exercise5.schema;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wdsr.exercise5.data_model.ClassTab;

public class ClassConnection {
	
	private static final Logger log = LoggerFactory.getLogger(ClassConnection.class);
	
	public static void createTable(Connection connection){
		try {
			connection.prepareStatement("CREATE TABLE IF NOT EXISTS Class (" +
			        "id INTEGER PRIMARY KEY generated always as identity (START WITH 1000), "
			        + "name VARCHAR(50)," + "faculty_key_id INTEGER FOREIGN KEY REFERENCES Faculty (id))")
					.executeUpdate();
			log.info("Created table Class");
		} catch (SQLException e) {
			log.error("Operation 'create table' was failed");
			log.error(e.getMessage());
		}
	}
	
	public static void insertElement(Connection connection, ClassTab classTab){
		try {
			connection.prepareStatement("INSERT INTO Class (name, faculty_key_id)" +
			        " VALUES('" + classTab.getName() + "','" + classTab.getFaculty_key_id() + "')")
					.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}
	
	public static void dropTable(Connection connection){
		try {
			connection.prepareStatement("DROP TABLE IF EXISTS Class").executeUpdate();
		} catch (SQLException e) {
			log.error("Deleting was failed - " + e.getMessage());
		}
	}
}
