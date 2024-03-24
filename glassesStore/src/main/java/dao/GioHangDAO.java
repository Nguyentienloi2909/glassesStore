package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.GioHang_SanPham;
import model.SanPham;
import model.TaiKhoan;
import model.SanPham;

public class GioHangDAO {

	public ArrayList<SanPham> getSanPhamTrongGioHang(long id) {
		DBConnect cs = new DBConnect();
		ArrayList<SanPham> lst = new ArrayList<SanPham>();
		try {
			cs.KetNoi();
			
			String sql = " SELECT sanpham.id, sanpham.tensanpham, sanpham.mota, sanpham.giagoc, sanpham.anhchinh, giohang_sanpham.soluong, "
					+ "sanpham.id_loaisp, khuyenmai.muckhuyenmai, sanpham.id_nhacungcap"
					+ " FROM web.sanpham join web.khuyenmai on khuyenmai.id_khuyenmai = sanpham.id_khuyenmai "
					+ "join web.giohang_sanpham on sanpham.id = giohang_sanpham.id_sanpham "
					+ "join web.giohang on giohang.id_giohang = giohang_sanpham.id_giohang"
					+ "  where giohang.id_taikhoan = "+ id;
			
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				SanPham products = new SanPham();
				products.setId(rs.getLong("id"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setMoTa(rs.getString("mota"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setSoLuong(rs.getInt("soLuong"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(rs.getInt("muckhuyenmai"));
				products.setId_nhaCungCap(rs.getLong("id_nhacungcap"));
				// Thêm vào danh sách
				lst.add(products);
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
	

	// hàm get hiển thị ra toàn bộ sản phẩm
	public ArrayList<GioHang_SanPham> getGioHangSanPham(GioHang_SanPham pd) {
		DBConnect cs = new DBConnect();
		ArrayList<GioHang_SanPham> lst = new ArrayList<GioHang_SanPham>();
		try {
			cs.KetNoi();
			
			String sql = " SELECT  giohang_sanpham.id_gioHang, giohang_sanpham.id_sanpham, giohang_sanpham.soluong, giohang.id_taiKhoan, giohang.tongtien"
					+ " FROM web.giohang_sanpham join web.giohang on giohang.id_giohang = giohang_sanpham.id_giohang"
					+ "  where giohang.id_taikhoan = "+pd.getId_taikhoan();
			
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				GioHang_SanPham detail = new GioHang_SanPham();
				detail.setId_GioHang(rs.getLong("id_giohang"));
				detail.setId_SanPham(rs.getLong("id_sanpham"));
				detail.setId_taikhoan(rs.getLong("id_taikhoan"));
				detail.setSoLuong(rs.getLong("soluong"));
				detail.setTongtien(rs.getDouble("tongtien"));
				// Thêm vào danh sách
				lst.add(detail);
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

	
	

	// thêm mới 1 loại sản phẩm

	
	public boolean addGioHangSanPham(GioHang_SanPham pd) {
		DBConnect cs = new DBConnect();
	    try {
	        cs.KetNoi();  
	        pd.setId_GioHang(getIdGioHangByIdTaiKhoan(pd.getId_taikhoan()));
	        String sql = "INSERT INTO web.giohang_sanpham(id_sanpham, id_giohang, soluong) "
	        		+ "VALUES(?, ? , ?)";
	        try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            cmd.setLong(1, pd.getId_SanPham());
	            cmd.setLong(2, pd.getId_GioHang());
	            cmd.setLong(3, pd.getSoLuong());
	            // Use executeUpdate for INSERT operations
	            int rowsAffected = cmd.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                return true;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	
	public int getIdGioHangByIdTaiKhoan(long id) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = " SELECT id_gioHang FROM web.giohang where id_taikhoan=?";
			
		
	            try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            	cmd.setLong(1, id);
	                try (ResultSet resultSet = cmd.executeQuery()) {
	                    if (resultSet.next()) {
	                        return resultSet.getInt("id_gioHang");
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return -1;
	}
	
	public static void main(String[] args) {
		GioHangDAO ghd = new GioHangDAO();
//		int a = ghd.getIdGioHangByIdTaiKhoan(46);
//		System.out.println(a);
		GioHang_SanPham gh = new GioHang_SanPham(48);
		ghd.deleteGioHangSanPham(gh);
	}
	

	public boolean editSoLuong(GioHang_SanPham pd) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = "UPDATE web.giohang_sanpham \n"
					+ "SET soluong = ? "
					+ "WHERE id_sanpham = ? \n"
					+ "AND id_giohang IN (SELECT id_giohang FROM web.giohang WHERE id_taikhoan = ?)";
			try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            cmd.setLong(1, pd.getSoLuong());
	            cmd.setLong(2, pd.getId_SanPham());
	            cmd.setLong(3, pd.getId_taikhoan());
				int rowsAffected = cmd.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                return true;
	            }
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// xóa chi tiết sản phẩm theo mã id
	public boolean deleteGioHangSanPham(GioHang_SanPham pd) {
		DBConnect cs = new DBConnect();
	    try {
	        cs.KetNoi();
	        long id_giohang = getIdGioHangByIdTaiKhoan(pd.getId_taikhoan());

	        cs.cn.setAutoCommit(false);

	        try (PreparedStatement deleteCmd = cs.cn.prepareStatement("DELETE FROM web.giohang_sanpham WHERE id_giohang = ?");
	             PreparedStatement updateCmd = cs.cn.prepareStatement("UPDATE web.giohang SET tongtien = 0 WHERE id_taikhoan = ?")) {

	            deleteCmd.setLong(1, id_giohang);
	            int rowsDeleted = deleteCmd.executeUpdate();

	            if (rowsDeleted > 0) {
	                updateCmd.setLong(1, pd.getId_taikhoan());
	                int rowsUpdated = updateCmd.executeUpdate();

	                if (rowsUpdated > 0) {
	                    cs.cn.commit();
	                    return true;
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
	public boolean deleteSanPhamTrongGioHang(GioHang_SanPham pd) {
		DBConnect cs = new DBConnect();
        try {
            cs.KetNoi();
            long id_giohang = getIdGioHangByIdTaiKhoan(pd.getId_taikhoan());
            String sql = "DELETE FROM web.giohang_sanpham WHERE id_giohang = ? and id_sanpham=?";
        
            
            try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            cmd.setLong(1, id_giohang);
	            cmd.setLong(2, pd.getId_SanPham());
				int rowsAffected = cmd.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                return true;
	            }
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
