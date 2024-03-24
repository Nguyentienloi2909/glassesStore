package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.HoaDon;

public class HoaDonDAO {
	
	
		
	public long addBill(HoaDon bill) {
	    DBConnect cs = new DBConnect();
	    try {
	        cs.KetNoi();
	        String sql = "INSERT INTO web.hoadon(ngayin, tongtien, id_dondathang, hinhthucthanhtoan) VALUES (?,?,?,?) ";

	        try (PreparedStatement cmd = cs.cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	            bill.setNgayIn(convertDatetime());
	            cmd.setString(1, bill.getNgayIn());
	            cmd.setDouble(2, bill.getTongTien());
	            cmd.setLong(3, bill.getId_donDatHang());
	            cmd.setString(4, bill.getHinhThucThanhToan());

	            int rowsAffected = cmd.executeUpdate();
	            if (rowsAffected > 0) {
	                // Retrieve the generated keys
	                try (ResultSet generatedKeys = cmd.getGeneratedKeys()) {
	                    if (generatedKeys.next()) {
	                        // Return the generated id_donDatHang
	                        return generatedKeys.getLong(1);
	                    } else {
	                        throw new SQLException("Failed to retrieve generated id_donDatHang.");
	                    }
	                }
	            } else {
	                throw new SQLException("Insertion failed, no rows affected.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return -1;
	}

	
	public String convertDatetime() {
		 LocalDateTime currentTime = LocalDateTime.now();

      // Định dạng để xuất ra chuỗi
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      // Chuyển đổi LocalDateTime thành chuỗi
      String formattedDateTime = currentTime.format(formatter);

      // In ra màn hình
      return formattedDateTime;
	}

	
	
	public static void main(String[] args) {
		HoaDonDAO billsDAO = new HoaDonDAO();
		HoaDon bill = new HoaDon(23000, 6, "chuyenkhoan");
		System.out.println(billsDAO.addBill(bill));
	}
}
