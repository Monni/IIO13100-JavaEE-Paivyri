package fi.turbotiimi.paivyri.databaseManagement;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class RuokailuTest {
public static void main(String[] args) throws Exception {
		
	
		RuokailuDAO ruokailuDao = new RuokailuDAO();
		RuokailuDTO ruokailu = new RuokailuDTO();
		//ruokailuDao.save(ruokailu);
		ruokailuDao.findAll();
		ruokailuDao.findByID("TepiTestaaja");
		//ruokailuDao.delete(5);
		//ruokailuDao.deleteAll("TepiTestaaja");
	}
}