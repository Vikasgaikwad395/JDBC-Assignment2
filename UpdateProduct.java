import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateProduct {
			public static void main(String[] args) throws Exception {
				
				String driver = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/sampledb";
				String user = "root";
				String password = "Vikas@7720";
				
				Scanner in = new Scanner(System.in);
				System.out.println("Enter the product Id:- ");
				int Id = in.nextInt();
				
				System.out.println("Enter the product Name:- ");
				String Name = in.next();
				
				System.out.println("Enter the price of the product:- ");
				int Price = in.nextInt();
				
				String sql = "UPDATE product SET Name=?,Price=? WHERE Id=?";
				
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, user, password);
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, Name);
				ps.setInt(2, Price);
				ps.setInt(3, Id);
				
				int result = ps.executeUpdate();
				if(result > 0) {
					System.out.println("Record is updated");
				}else {
					System.out.println("Something went wrong.........");
				}
				ps.close();
				con.close();
				
			}
}
