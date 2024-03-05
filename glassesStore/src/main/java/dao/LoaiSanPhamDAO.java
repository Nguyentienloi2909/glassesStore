
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.LoaiSanPham;

/**
 * @author MyPC
 *
 */
public class LoaiSanPhamDAO {
	// hàm get hiển thị ra LOẠI sản phẩm giao diện Trang chủ và Quản lý
	public ArrayList<LoaiSanPham> getListCategory() {
		DBConnect cs = new DBConnect();
		ArrayList<LoaiSanPham> lst = new ArrayList<LoaiSanPham>();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.loaisanpham";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				LoaiSanPham category = new LoaiSanPham();
				category.setId(rs.getLong("id"));
				category.setTenLoaiSanPham(rs.getString("tenloai"));
				// Thêm vào danh sách
				lst.add(category);
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

	/* Xong phần hiển thị trang chủ */

	/* Phần quản lý admin */

	// thêm mới 1 loại sản phẩm
	public boolean addCategory(LoaiSanPham ca) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = "INSERT INTO web.loaisanpham(tenloai) VALUES(?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ca.getTenLoaiSanPham());
			cmd.executeQuery();
			cs.cn.close();
			cmd.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// hàm get hiển thị ra loại sản phẩm theo mã id-
	public LoaiSanPham getCategoryByID(long id) {
		DBConnect cs = new DBConnect();
		LoaiSanPham lst = new LoaiSanPham();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM LOAISANPHAM WHERE id=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {				
				long id_loaiSanPham = rs.getLong("id");
				String tenLoaiSanPham = rs.getString("tenloai");			
				lst = new LoaiSanPham(id_loaiSanPham, tenLoaiSanPham);
			}
			rs.close();
			cs.cn.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		// System.out.println(lst.getId()+"kkkk");
		return lst;
	}	

	// sửa loại sản phẩm
	public boolean editCategory(LoaiSanPham ca) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = "UPDATE loaisanpham SET tenloai = ? where id=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ca.getTenLoaiSanPham());
			cmd.setLong(2, ca.getId());
			cmd.executeQuery();
			cs.cn.close();
			cmd.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// xóa sản phẩm theo mã id
	public int deleteProduct(long id) {
		DBConnect cs = new DBConnect();
		int kq=0;
		try {
			cs.KetNoi();
			String sql = "DELETE FROM loaisanpham WHERE id = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			kq =cmd.executeUpdate();
			cs.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public int getIdLoaiSPByTenSP(String tenLoai) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = " SELECT id FROM web.loaisanpham where tenloai=?";
	            try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            	cmd.setString(1, tenLoai);
	                try (ResultSet resultSet = cmd.executeQuery()) {
	                    if (resultSet.next()) {
	                        return resultSet.getInt("id");
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return -1;
	}
	
	public static void main(String[] args) {
		LoaiSanPhamDAO lsp = new LoaiSanPhamDAO();
		int a = lsp.getIdLoaiSPByTenSP("amo");
		System.out.println(a);
	}

}
