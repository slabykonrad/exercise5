package wdsr.exercise5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		log.info("Start connection");
		
		Connector.openConnection("test-db","SA","");
		Connector.dropTables();
		
		Connector.createFacultiesTable();
		Connector.createClassesTable();
		Connector.createStudentsTable();
		Connector.createEnrollmentTable();
		
		Connector.insertElementIntoStudentsTable("John Smith","male",23,2);
		Connector.insertElementIntoStudentsTable("Rebecca Milson","female",27,3);
		Connector.insertElementIntoStudentsTable("George Heartbreaker","male",19,1);
		Connector.insertElementIntoStudentsTable("Deepika Chopra","female",25,3);
		Connector.insertElementIntoFacultiesTable("Engineering");
		Connector.insertElementIntoFacultiesTable("Philosophy");
		Connector.insertElementIntoFacultiesTable("Law and administration");
		Connector.insertElementIntoFacultiesTable("Languages");
		Connector.insertElementIntoClassesTable("Introduction to labour law",102);
		Connector.insertElementIntoClassesTable("Graph algorithms",100);
		Connector.insertElementIntoClassesTable("Existentialism in 20th century",101);
		Connector.insertElementIntoClassesTable("English grammar",103);
		Connector.insertElementIntoClassesTable("From Plato to Kant",101);
		Connector.insertElementIntoEnrollmentTable(1, 1000);
		Connector.insertElementIntoEnrollmentTable(1, 1002);
		Connector.insertElementIntoEnrollmentTable(1, 1003);
		Connector.insertElementIntoEnrollmentTable(1, 1004);
		Connector.insertElementIntoEnrollmentTable(2, 1002);
		Connector.insertElementIntoEnrollmentTable(2, 1003);
		Connector.insertElementIntoEnrollmentTable(4, 1000);
		Connector.insertElementIntoEnrollmentTable(4, 1002);
		Connector.insertElementIntoEnrollmentTable(4, 1003);
		
		Connector.getAllStudentsQuery1();
		Connector.getAllStudentsWithoutSubjectQuery2();
		Connector.getAllFemaleStudentsQuery3();
		
		Connector.closeConnection();
		
		log.info("End connection");
	}

}
