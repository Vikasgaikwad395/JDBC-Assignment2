import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayTable {
	
public static void main(String[] args) throws Exception {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String user = "root";
		String password = "Vikas@7720";
		
		
String query = "SELECT *FROM product";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getInt("id")+"\t"+rs.getString("Name")+"\t"+rs.getInt("Price"));
		}

		stmt.close();
		con.close();
}
}

			
				


