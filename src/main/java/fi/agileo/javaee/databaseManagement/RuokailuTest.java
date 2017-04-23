package fi.agileo.javaee.databaseManagement;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class RuokailuTest {
public static void main(String[] args) throws Exception {
		
	
		RuokailuDAO ruokailuDao = new RuokailuDAO();
		ruokailuDao.InsertToDB();
		ruokailuDao.PrintDB();
	}
}