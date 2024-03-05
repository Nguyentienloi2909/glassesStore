package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.NhaCungCap;

public class NhaCungCapDAO {
	
	public ArrayList<NhaCungCap> getListCategory() {
		DBConnect cs = new DBConnect();
		ArrayList<NhaCungCap> lst = new ArrayList<NhaCungCap>();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.nhacungcap";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				NhaCungCap nhaCungCap = new NhaCungCap();
				nhaCungCap.setId(rs.getLong("id_nhacungcap"));
				nhaCungCap.setTenNhaCungCap(rs.getString("tennhacungcap"));
				nhaCungCap.setDiaChi(rs.getString("diachi"));
				nhaCungCap.setSdt(rs.getString("sodienthoai"));
				// Thêm vào danh sách
				lst.add(nhaCungCap);
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}
	
	public int getIdNhaCungCapByTenNCC(String tenNhaCungCap) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = " SELECT id_nhacungcap FROM web.nhacungcap where tennhacungcap=?";
	            try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            	cmd.setString(1, tenNhaCungCap);
	                try (ResultSet resultSet = cmd.executeQuery()) {
	                    if (resultSet.next()) {
	                        return resultSet.getInt("id_nhacungcap");
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return -1;
	}
	
	public static void main(String[] args) {
		NhaCungCapDAO ncc = new NhaCungCapDAO();
		System.out.println(ncc.getIdNhaCungCapByTenNCC("Đặng Quang Tuần"));
	}
}
