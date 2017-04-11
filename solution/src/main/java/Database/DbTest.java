package Database;

import java.sql.Connection;

public class DbTest {
public static void main(String[] args) throws Exception {
		
		DbManager db = new DbManager();
		Connection conn = db.getConnection();
		if(conn == null){
			System.out.println("NOT CONNECTED");
		}else{
			System.out.println("CONNECTED");
		}
	}
}
