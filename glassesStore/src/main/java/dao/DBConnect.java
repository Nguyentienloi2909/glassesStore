
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author MyPC
 *
 */
public class DBConnect {
	public Connection cn;
	public void KetNoi() throws Exception{

		try {
//			đăng ký mySQL driver với driverManager
			Class.forName("com.mysql.cj.jdbc.Driver");
//			các thông số
			String url = "jdbc:mysql://localhost:3306/web";
			String username = "root";
			String password ="loi123456";
			
//			tạo kết nối
			cn = DriverManager.getConnection(url, username, password);
			
			if (cn == null) {
				System.out.println("chua thanh cong");
			}else {
				System.out.println("ok");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		DBConnect  c = new DBConnect();
		c.KetNoi();
		System.out.println("ok");
	}

}
