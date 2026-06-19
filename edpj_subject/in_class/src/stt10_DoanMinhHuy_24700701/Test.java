package stt10_DoanMinhHuy_24700701;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	private static String url;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySinhVien";
		//url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySinhVien;encrypt=true;trustServerCertificate=true;integratedSecurity=true";
		//url = "jdbc:sqlserver://localhost\\\\SQLEXPRESS:1433;databaseName=QuanLySinhVien;encrypt=true;trustServerCertificate=true";
		url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySinhVien;encrypt=true;trustServerCertificate=true";
		try {
			Connection connection = DriverManager.getConnection(url, "sa", "sa123");
			System.out.println("Connect OK");
			
			String sql = "select * from LopHoc";
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				String maLop = resultSet.getString("maLop");
				
				String tenLop = resultSet.getString("tenLop");
				
				System.out.println(maLop + " - " + tenLop);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
