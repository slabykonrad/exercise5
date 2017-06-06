package wdsr.exercise5.schema;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wdsr.exercise5.data_model.Enrollment;

public class EnrollmentConnection {
	
private static final Logger log = LoggerFactory.getLogger(EnrollmentConnection.class);
	
	public static void createTable(Connection connection){
		try {
			connection.prepareStatement("CREATE TABLE IF NOT EXISTS Enrollment ( student_key_id "
					+ "INTEGER FOREIGN KEY REFERENCES Student (id), "
					+ "class_key_id INTEGER FOREIGN KEY REFERENCES Class (id))").executeUpdate();
			log.info("Created table Enrollment");
		} catch (SQLException e) {
			log.error("Operation 'create table' was failed");
			log.error(e.getMessage());
		}
	}
	
	public static void insertElement(Connection connection, Enrollment enrollment){
		try {
			connection.prepareStatement("INSERT INTO Enrollment (student_key_id, class_key_id)" +
			        " VALUES('" + enrollment.getStudent_key_id() + "','" + enrollment.getClass_key_id() 
			        + "')").executeUpdate();
		} catch (SQLException e) {
			log.error("inserting failed " + e.getMessage());
		}
	}
	
	public static void dropTable(Connection connection){
		try {
			connection.prepareStatement("DROP TABLE IF EXISTS Enrollment").executeUpdate();
		} catch (SQLException e) {
			log.error("Deleting was failed - " + e.getMessage());
		}
	}
}
