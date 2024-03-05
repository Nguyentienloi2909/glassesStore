package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.DonDatHang;
import repository.VoucherBO;

public class DonDatHangDAO {
	VoucherBO vcBO = new VoucherBO();
	
	
	public long addDonHang(DonDatHang order) {
	    DBConnect cs = new DBConnect();
	    try {
	        cs.KetNoi();
	        String sql = "INSERT INTO web.dondathang(id_voucher, id_taikhoan, ngaydat, tongtienthanhtoan) VALUES (?,?,?,?) ";
	        order.setNgayDat(convertDatetime());

	        try (PreparedStatement cmd = cs.cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	            cmd.setLong(1, order.getId_voucher());
	            cmd.setLong(2, order.getId_taiKhoan());
	            cmd.setString(3, order.getNgayDat());
	            cmd.setDouble(4, order.getTongTienThanhToan());

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
	    return -1; // Return a default value indicating failure
	}

	public long addDonHangKhongVouCher(DonDatHang order) {
	    DBConnect cs = new DBConnect();
	    try {
	        cs.KetNoi();
	        String sql = "INSERT INTO web.dondathang(id_taikhoan, ngaydat, tongtienthanhtoan) VALUES (?,?,?) ";
	        order.setNgayDat(convertDatetime());

	        try (PreparedStatement cmd = cs.cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	            cmd.setLong(1, order.getId_taiKhoan());
	            cmd.setString(2, order.getNgayDat());
	            cmd.setDouble(3, order.getTongTienThanhToan());

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
	    return -1; // Return a default value indicating failure
	}

	
	public static void main(String[] args) {
		DonDatHangDAO s = new DonDatHangDAO();
		DonDatHang ddh = new DonDatHang(1, 48, 21000);
		System.out.println(s.addDonHang(ddh));
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

}
