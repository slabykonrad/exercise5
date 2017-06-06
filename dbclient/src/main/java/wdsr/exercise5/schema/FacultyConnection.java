package wdsr.exercise5.schema;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wdsr.exercise5.data_model.Faculty;

public class FacultyConnection {
	
	private static final Logger log = LoggerFactory.getLogger(FacultyConnection.class);
	
	public static void createTable(Connection connection){
		try {
			connection.prepareStatement("CREATE TABLE IF NOT EXISTS Faculty (" +
			        "id INTEGER PRIMARY KEY generated always as identity (START WITH 100), "
			        + "name VARCHAR(50))").executeUpdate();
			log.info("Created table Faculty");
		} catch (SQLException e) {
			log.error("Operation 'create table' was failed");
			log.error(e.getMessage());
		}
	}
	
	public static void insertElement(Connection connection, Faculty faculty){
		try {
			connection.prepareStatement("INSERT INTO Faculty (name)" +
			        " VALUES('" + faculty.getName() + "')").executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}
	
	public static void dropTable(Connection connection){
		try {
			connection.prepareStatement("DROP TABLE IF EXISTS Faculty").executeUpdate();
		} catch (SQLException e) {
			log.error("Deleting was failed - " + e.getMessage());
		}
	}
}
