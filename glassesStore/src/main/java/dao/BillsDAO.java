package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Bills;

public class BillsDAO {
	
	
		
	public boolean addBill(Bills bill) {
		DBConnect cs = new DBConnect();
	    try {
	        cs.KetNoi();
	        String sql = "INSERT INTO web.hoadon(diachi, dienthoai, ghichu) VALUES (?,?,?) ";

	        try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            cmd.setString(1, bill.getDiachi());
	            cmd.setString(2, bill.getSdt());
	            cmd.setString(3, bill.getGhichu());

	            int rowsAffected = cmd.executeUpdate();

	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
	
	public static void main(String[] args) {
		BillsDAO billsDAO = new BillsDAO();
		Bills bill = new Bills("tây yên", "0971744530", "giao cấp tốc");
		System.out.println(billsDAO.addBill(bill));
	}
}
