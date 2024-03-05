package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.HoaDon;

public class HoaDonDAO {
	
	
		
	public boolean addBill(HoaDon bill) {
		DBConnect cs = new DBConnect();
	    try {
	        cs.KetNoi();
	        String sql = "INSERT INTO web.hoadon(ngayin, tongtien, id_dondathang, hinhthucthanhtoan) VALUES (?,?,?,?) ";

	        try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	        	bill.setNgayIn(convertDatetime());;
	            cmd.setString(1, bill.getNgayIn());
	            cmd.setDouble(2, bill.getTongTien());
	            cmd.setLong(3, bill.getId_donDatHang());
	            cmd.setString(4, bill.getHinhThucThanhToan());

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
		HoaDon bill = new HoaDon(23000, 1, "chuyenkhoan");
		billsDAO.addBill(bill);
	}
}
