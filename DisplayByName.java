import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DisplayByName {

	public static void main(String[] args) throws Exception {
		
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String user = "root";
		String password = "Vikas@7720";
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter product Name:- ");
		String Name = in.next();
		
		String query = "SELECT *FROM product WHERE Name = ?";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		PreparedStatement  ps = con.prepareStatement(query);
		ps.setString(1, Name);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("Id")+"\t"+ rs.getString("Name")+"\t"+rs.getString("Price"));
			
		}
			ps.close();
			con.close();
			
				

	}

}


	