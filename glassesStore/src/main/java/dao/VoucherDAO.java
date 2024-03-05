package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.TaiKhoan;
import model.Voucher;

public class VoucherDAO {
	public boolean checkVoucher(String tenvoucher) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.voucher where tenvoucher = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tenvoucher);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return true;
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public Voucher getVoucherByTenvoucher(String tenvoucher) {
		
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.voucher where tenvoucher = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tenvoucher);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				Voucher voucher = new Voucher();
				voucher.setIdvoucher(rs.getLong("idvoucher"));
				voucher.setKhuyenmai(rs.getLong("khuyenmai"));
				voucher.setTenvoucher(rs.getString("tenvoucher"));
				return voucher;
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addVoucher(Voucher pr) {
		DBConnect cs = new DBConnect();
        try {
			cs.KetNoi();
	        String sql = "INSERT INTO web.voucher (khuyenmai, tenvoucher, ngaybatdau, ngayketthuc) "
	        		+ "VALUES (?, ?, ?, ?)";
	        
	        try (PreparedStatement preparedStatement = cs.cn.prepareStatement(sql)) {
	        	pr.setNgayBatDau(convertDatetime());
	            preparedStatement.setLong(1, pr.getKhuyenmai());
	            preparedStatement.setString(2, pr.getTenvoucher());
	            preparedStatement.setString(3, pr.getNgayBatDau());
	            preparedStatement.setString(4, pr.getNgayKetThuc());

	
	            int rowsAffected = preparedStatement.executeUpdate();
	
	            return rowsAffected > 0;
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
		VoucherDAO voucher = new VoucherDAO();
		System.out.println(voucher.getVoucherByTenvoucher("voucher20").getTenvoucher());
	}
}
