import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteById {
	
	public static void main(String[] args) throws Exception {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String user = "root";
		String password = "Vikas@7720";
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Id:- ");
		int Id = in.nextInt();
		
		String sql = "DELETE FROM product WHERE Id=?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, Id);
		
		int result = ps.executeUpdate();
		if(result > 0) {
			System.out.println("Record is deleted Successfully.");
		}else {
			System.out.println("Record is not found.");
		}
		
		ps.close();
		con.close();
		
	}

}
