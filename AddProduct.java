import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddProduct {

	public static void main(String[] args) throws Exception{
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String user = "root";
		String password = "Vikas@7720";
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a Product Id:- ");
		int Id = in.nextInt();
		
		System.out.println("Enter the Product Name:- ");
		String Name = in.next();
		
		System.out.println("Eneter the Product Price :- ");
		int Price = in.nextInt();
		
		String sql = "INSERT INTO product (Id,Name,Price) VALUES (?,?,?)";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, Id);
		ps.setString(2, Name);
		ps.setInt(3, Price);
		
		int result = ps.executeUpdate();
		if(result > 0) {
			System.out.println("Record will be added Successfully....");
		}else {
			System.out.println("Something went Wrong............");
		}
		ps.close();
		con.close();
		
		
	}

}
