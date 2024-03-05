package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.KhuyenMai;
import model.Voucher;

public class KhuyenMaiDAO {

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
		KhuyenMaiDAO dao =new KhuyenMaiDAO();
		System.out.println(dao.getIdKhuyenMaiByMucKhuyenMai(3));
		// TODO Auto-generated method stub

	}
	
	public boolean addKhuyenMai(KhuyenMai km) {
		DBConnect cs = new DBConnect();
        try {
			cs.KetNoi();
	        String sql = "INSERT INTO web.khuyenmai(muckhuyenmai) "
	        		+ "VALUES (?)";
	        
	        try (PreparedStatement preparedStatement = cs.cn.prepareStatement(sql)) {
	        	km.setNgayBatDau(convertDatetime());
	            preparedStatement.setLong(1, km.getMucKhuyenMai());
	            int rowsAffected = preparedStatement.executeUpdate();
	
	            return rowsAffected > 0;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        return false;
		
	} 
	
	public int getIdKhuyenMaiByMucKhuyenMai(long id) {
		DBConnect cs = new DBConnect();
	    try {
	        try {
				cs.KetNoi();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        String sql = "SELECT id_khuyenmai FROM web.khuyenmai WHERE muckhuyenmai=?";
	        try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            cmd.setLong(1, id);
	            try (ResultSet resultSet = cmd.executeQuery()) {
	                return resultSet.next() ? resultSet.getInt("id_khuyenmai") : -1;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1;
	}


	public int getMucKhuyenMaiByIdKhuyenMai(long id) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = " SELECT muckhuyenmai  FROM web.khuyenmai where id_khuyenmai =?";
	            try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            	cmd.setLong(1, id);
	                try (ResultSet resultSet = cmd.executeQuery()) {
	                    if (resultSet.next()) {
	                        return resultSet.getInt("muckhuyenmai");
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return -1;
	}

}
