package wdsr.exercise5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wdsr.exercise5.data_model.ClassTab;
import wdsr.exercise5.data_model.Enrollment;
import wdsr.exercise5.data_model.Faculty;
import wdsr.exercise5.data_model.Student;
import wdsr.exercise5.schema.ClassConnection;
import wdsr.exercise5.schema.EnrollmentConnection;
import wdsr.exercise5.schema.FacultyConnection;
import wdsr.exercise5.schema.StudentConnection;

public class Connector {
	
	private static final Logger log = LoggerFactory.getLogger(Connector.class);
	private static Connection connection;
	
	static void openConnection(String databaseName, String userName, String password) {
		try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
            log.info("Loaded JDBC Driver");
        } 
        catch (Exception e) {
            log.error("ERROR: failed to load JDBC driver - " + e.getMessage());
        }
		
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://127.0.0.1:9001/" + databaseName,
					userName, password);      
        }
        catch(SQLException e){
            log.error(e.getMessage());
        }
	}
	
	public static void closeConnection() {
        try {
            connection.close();
        }
        catch(SQLException e) {
            log.error(e.getMessage());
        }
    }
	
	public static void createStudentsTable(){
		StudentConnection.createTable(connection);
	}
	
	public static void createFacultiesTable(){
		FacultyConnection.createTable(connection);
	}
	
	public static void createClassesTable(){
		ClassConnection.createTable(connection);
	}
	
	public static void createEnrollmentTable(){
		EnrollmentConnection.createTable(connection);
	}
	
	public static void insertElementIntoStudentsTable(String name, String sex, int age, int level){
		StudentConnection.insertElement(connection,new Student(name,sex,age,level));
	}
	
	public static void insertElementIntoFacultiesTable(String name){
		FacultyConnection.insertElement(connection,new Faculty(name));
	}
	
	public static void insertElementIntoClassesTable(String name, int key){
		ClassConnection.insertElement(connection,new ClassTab(name,key));
	}
	
	public static void insertElementIntoEnrollmentTable(int studentKey, int classKey){
		EnrollmentConnection.insertElement(connection,new Enrollment(studentKey,classKey));
	}
	
	public static void dropTables(){
		EnrollmentConnection.dropTable(connection);
		ClassConnection.dropTable(connection);
		StudentConnection.dropTable(connection);
		FacultyConnection.dropTable(connection);
	}
	
	public static void getAllStudentsQuery1(){
		try {
			ResultSet res = connection.prepareStatement("SELECT id, name FROM Student").executeQuery();
			log.info("Query 1 - get all students:");
			while (res.next()) {
                log.info("id= " + res.getInt("id") + ", " + "name= " + res.getString("name"));
            }
		} catch (SQLException e) {
			log.error(e.getMessage());
		} 
	}
	
	public static void getAllStudentsWithoutSubjectQuery2(){
		try {
			ResultSet res = connection.prepareStatement("SELECT s.id, s.name, e.class_key_id "
					+ "FROM Student s FULL JOIN Enrollment e on e.student_key_id=s.id "
					+ "WHERE e.class_key_id IS NULL").executeQuery();
			log.info("Query 2 - get all students without subject:");
			while (res.next()) {
                log.info("id= " + res.getInt("id") + ", " + "name= " + res.getString("name"));
            }
		} catch (SQLException e) {
			log.error(e.getMessage());
		} 
	}
	
	public static void getAllFemaleStudentsQuery3(){
		try {
			ResultSet res = connection.prepareStatement("SELECT s.id, s.name, s.sex, e.class_key_id FROM Student s "
					+ "FULL JOIN Enrollment e on e.student_key_id=s.id "
					+ "WHERE s.sex like 'female' "
					+ "AND e.class_key_id = 1002").executeQuery();
			log.info("Query 3 - get all female students:");
			while (res.next()) {
                log.info("id= " + res.getInt("id") + ", " + "name= " + res.getString("name"));
            }
		} catch (SQLException e) {
			log.error(e.getMessage());
		} 
	}
}
