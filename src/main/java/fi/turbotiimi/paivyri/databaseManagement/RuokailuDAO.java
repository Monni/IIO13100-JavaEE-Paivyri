package fi.turbotiimi.paivyri.databaseManagement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class RuokailuDAO {

	private Connection conn = null;
	private List<RuokailuDTO> ruokailut = new ArrayList<RuokailuDTO>();
	
	public RuokailuDAO(){
		 getConnection();
	 }
	 
	 public void getConnection() {
		 
		DbManager db = new DbManager();
		conn = (Connection) db.getConnection();
		if(conn == null){
			System.out.println("NOT CONNECTED");
		}else{
			System.out.println("CONNECTED");
		}
	}
	
	public List<RuokailuDTO> findByID(String name){
		System.out.println("QUERY BY NAME");
		ruokailut.clear();
		String sql = "Select * from ruokailu WHERE nimi=?";
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				RuokailuDTO ruokailu = new RuokailuDTO();
			    ruokailu.setID(rs.getInt("ID"));
			    ruokailu.setDate(rs.getDate("Pvm"));
			    ruokailu.setKlo(rs.getString("Klo"));
			    ruokailu.setNimi(rs.getString("Nimi"));
			    ruokailu.setRuoanNimi(rs.getString("Ruoannimi"));
			    ruokailu.setRuoanMaara(rs.getInt("Ruoanmaara"));
			    ruokailu.setKalorit(rs.getInt("Kalorit"));
			    ruokailu.setHiilihydraatit(rs.getInt("Hiilihydraatit"));
			    ruokailu.setProteiinit(rs.getInt("Proteiini"));
			    ruokailu.setRasvat(rs.getInt("Rasva"));
			    ruokailu.printRuokailu();
			    ruokailut.add(ruokailu);
			}
	  } 
	  catch (SQLException e) {
		e.printStackTrace();
	  }
		return ruokailut;
	}
	
	//For Debugging
	public List<RuokailuDTO> findAll() {
		System.out.println("QUERY ALL");
		ruokailut.clear();
		String sql = "Select * from ruokailu";
		try {		  	 
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				RuokailuDTO ruokailu = new RuokailuDTO();
			    ruokailu.setID(rs.getInt("ID"));
			    ruokailu.setDate(rs.getDate("Pvm"));
			    ruokailu.setKlo(rs.getString("Klo"));
			    ruokailu.setNimi(rs.getString("Nimi"));
			    ruokailu.setRuoanNimi(rs.getString("Ruoannimi"));
			    ruokailu.setRuoanMaara(rs.getInt("Ruoanmaara"));
			    ruokailu.setKalorit(rs.getInt("Kalorit"));
			    ruokailu.setHiilihydraatit(rs.getInt("Hiilihydraatit"));
			    ruokailu.setProteiinit(rs.getInt("Proteiini"));
			    ruokailu.setRasvat(rs.getInt("Rasva"));
			    ruokailu.printRuokailu();
			    ruokailut.add(ruokailu);
			}
	  } 
	  catch (SQLException e) {
		e.printStackTrace();
	  }
		return ruokailut;
	}
	
	public void delete(int ID){
		System.out.println("DELETE BY ID");
		String sql = "Delete from ruokailu WHERE ID=?";
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setInt(1, ID);
			stmt.executeUpdate();
			System.out.println("ROW DELETED WHERE ID IS " + ID);
	  } 
	  catch (SQLException e) {
		e.printStackTrace();
	  }
	}
	
	public void deleteAll(String name){
		System.out.println("DELETE ALL");
		String sql = "Delete from ruokailu WHERE Nimi=?";
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.executeUpdate();
			System.out.println("All ROWS DELETED WHERE NAME IS " + name);
	  } 
	  catch (SQLException e) {
		e.printStackTrace();
	  }
	}
	
	public void save(RuokailuDTO ruokailu){
		
		//Mokki datat
		/*java.sql.Date currentDate = new java.sql.Date(1980-05-21);
		System.out.println(currentDate);
		ruokailu.setDate(currentDate);
		ruokailu.setKlo("10:30");
		ruokailu.setNimi("TepiTestaaja");
		ruokailu.setRuoanNimi("Kalaa");
		ruokailu.setRuoanMaara(750);
		ruokailu.setKalorit(172);
		ruokailu.setHiilihydraatit(23);
		ruokailu.setProteiinit(12);
		ruokailu.setRasvat(10);*/
		
		//prints whole DTO
		System.out.println(ruokailu.getDate() + ", " + ruokailu.getKlo() + ", " + ruokailu.getNimi() + ", " + ruokailu.getRuoanNimi() + ", " + ruokailu.getRuoanMaara() + ", " + ruokailu.getKalorit() + ", " + ruokailu.getHiilihydraatit() + ", " + ruokailu.getProteiinit() + ", " + ruokailu.getRasvat() );
		
		//Prepared statement
		String sql = "Insert into ruokailu (Pvm, Klo, Nimi, Ruoannimi, Ruoanmaara, Kalorit, Hiilihydraatit, Proteiini, Rasva)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			//Preparing statement to avoid injections
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setDate(1, ruokailu.getDate());
			stmt.setString(2, ruokailu.getKlo());
			stmt.setString(3, ruokailu.getNimi());
			stmt.setString(4, ruokailu.getRuoanNimi());
			stmt.setDouble(5, ruokailu.getRuoanMaara());
			stmt.setDouble(6, ruokailu.getKalorit());
			stmt.setDouble(7, ruokailu.getHiilihydraatit());
			stmt.setDouble(8, ruokailu.getProteiinit());
			stmt.setDouble(9, ruokailu.getRasvat());
			
			//inserts into MySQL
			stmt.executeUpdate();
			System.out.println("Inserted Row");

			stmt.close();
		} catch (Exception e) {
			System.out.println("Failed to insert");
		}
	}
}
