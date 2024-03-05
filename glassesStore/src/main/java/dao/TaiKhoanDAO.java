
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.SanPham;
import model.TaiKhoan;

/**
 * @author MyPC
 *
 */
public class TaiKhoanDAO {
	// hàm kiểm tra tài khaorn & email đã tồn tại chưa
	public boolean checkAccountTenTaiKhoan(String tenTaiKhoan) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM taikhoan WHERE tentaikhoan=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tenTaiKhoan);
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
	
	public boolean checkAccountEmail(String email) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM taikhoan WHERE email=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, email);
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

	// hàm KIỂM TRA khi người dùng/ admin ĐĂNG NHẬP
	public TaiKhoan checkLogin(String userNameOrEmail, String pass) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM taikhoan WHERE (tentaikhoan=? and matkhau=?) or (email=? and matkhau=?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, userNameOrEmail);
			cmd.setString(2, pass);
			cmd.setString(3, userNameOrEmail);
			cmd.setString(4, pass);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				
				TaiKhoan user = new TaiKhoan();
				user.setId(rs.getLong("id"));
				user.setTenTaiKhoan(rs.getString("tentaikhoan"));
				user.setEmail(rs.getString("email"));
				user.setMatKhau(rs.getString("matkhau"));
				user.setPhanQuyen(rs.getString("phanquyen"));
				user.setHinhAnh(rs.getString("hinhanh"));
				user.setDiaChi(rs.getString("diachi"));
				user.setSoDienThoai(rs.getString("sodienthoai"));
				// Thêm vào danh sách
				return user;
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

	// Phương thức thêm một tài khoản mới
	public boolean addAccount(TaiKhoan user) {
		DBConnect cs = new DBConnect();
	    try {
	        cs.KetNoi();
	        String insertAccountSQL = "INSERT INTO web.taikhoan(tentaikhoan,email,matkhau,phanquyen,hinhanh,diachi, sodienthoai) "
	                + "VALUES (?,?,?,0,?,?,?)";
	        String insertShoppingCartSQL = "INSERT INTO web.giohang(id_taikhoan, tongtien) VALUES(LAST_INSERT_ID(), 0)";

	        try (PreparedStatement accountCmd = cs.cn.prepareStatement(insertAccountSQL);
	             PreparedStatement cartCmd = cs.cn.prepareStatement(insertShoppingCartSQL)) {
	            accountCmd.setString(1, user.getTenTaiKhoan());
	            accountCmd.setString(2, user.getEmail());
	            accountCmd.setString(3, user.getMatKhau());
	            accountCmd.setString(4, user.getHinhAnh());
	            accountCmd.setString(5, user.getDiaChi());
	            accountCmd.setString(6, user.getSoDienThoai());

	            // Thực hiện câu lệnh INSERT cho tài khoản
	            int rowsAffected = accountCmd.executeUpdate();

	            if (rowsAffected > 0) {
	                // Thực hiện câu lệnh INSERT cho giỏ hàng
	                cartCmd.executeUpdate();
	                cs.cn.close();
	                return true;
	            }
	        } catch (SQLException e) {
	            // Xử lý ngoại lệ, có thể log hoặc báo cáo
	            e.printStackTrace();
	        }
	    } catch (Exception e) {
	        // Xử lý ngoại lệ khi mở kết nối, có thể log hoặc báo cáo
	        e.printStackTrace();
	    }
	    return false;
	}

	
	public boolean addAccountAdmin(TaiKhoan user) throws Exception {
		DBConnect cs = new DBConnect();
		cs.KetNoi();
		String sql = "INSERT INTO web.taikhoan(tentaikhoan,email,matkhau,phanquyen,hinhanh,diachi, sodienthoai) "
				+ "VALUES (?,?,?,1,?,?,?) ";
		try {
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, user.getTenTaiKhoan());
			cmd.setString(2, user.getEmail());
			cmd.setString(3, user.getMatKhau());
			// cmd.setString(4, user.getPhanQuyen());
			cmd.setString(4, user.getHinhAnh());
			cmd.setString(5, user.getDiaChi());
			cmd.setString(6, user.getSoDienThoai());
			cmd.executeUpdate();
			cs.cn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	


	// Phương thức cập nhật mật khẩu cho người dùng/ giao diện trang chủ/cá nhân
	public boolean editPasswordAccount(String matkhau, long id) throws Exception {
		DBConnect cs = new DBConnect();
		String sql = "update web.taikhoan set matkhau= ? where id=?;";
		try {
			cs.KetNoi();
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, matkhau);
			cmd.setLong(2, id);
			cmd.executeUpdate();
			cs.cn.close();
			cmd.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean editPhanQuyenAccount(int id) {
	    DBConnect cs = new DBConnect();
	    
	    try {
	        cs.KetNoi();
	        String sql = "UPDATE web.taikhoan SET phanquyen = 1 WHERE id = ?";
	        
	        try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            cmd.setLong(1, id);
	            int rowAffected = cmd.executeUpdate();
	            return rowAffected > 0;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public boolean editDeletePhanQuyenAccount(int id) {
	    DBConnect cs = new DBConnect();
	    
	    try {
	        cs.KetNoi();
	        String sql = "UPDATE web.taikhoan SET phanquyen = 0 WHERE id = ?";
	        
	        try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            cmd.setLong(1, id);
	            int rowAffected = cmd.executeUpdate();
	            return rowAffected > 0;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public boolean UpdateDiaChiAnhdSDT(TaiKhoan user) {
	    DBConnect cs = new DBConnect();
	    
	    try {
	        cs.KetNoi();
	        String sql = "UPDATE web.taikhoan SET diachi = ?, sodienthoai = ? WHERE id = ?";
	        
	        try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            cmd.setString(1, user.getDiaChi());
	            cmd.setString(2, user.getSoDienThoai());
	            cmd.setLong(3, user.getId());
	            int rowAffected = cmd.executeUpdate();
	            return rowAffected > 0;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	

	// lấy ra toàn bô tài khoản giap diện quản lý
	public ArrayList<TaiKhoan> getListUsers() {
		DBConnect cs = new DBConnect();
		ArrayList<TaiKhoan> lst = new ArrayList<TaiKhoan>();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.taikhoan";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				TaiKhoan user = new TaiKhoan();
				user.setId(rs.getLong("id"));
				user.setTenTaiKhoan(rs.getString("tentaikhoan"));
				user.setEmail(rs.getString("email"));
				user.setMatKhau(rs.getString("matkhau"));
				user.setPhanQuyen(rs.getString("phanquyen"));
				user.setHinhAnh(rs.getString("hinhanh"));
				user.setDiaChi(rs.getString("diachi"));
				user.setSoDienThoai(rs.getString("sodienthoai"));
				lst.add(user);
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

	// xóa tài khoản theo mã id
	public boolean deleteUser(long id) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = "DELETE FROM taikhoan WHERE id = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			cmd.executeUpdate();
			cs.cn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// lấy ra toàn bô thông tin của tài khoản theo id
	public TaiKhoan getUsersById(long id) {
		DBConnect cs = new DBConnect();
		TaiKhoan user = new TaiKhoan();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM taikhoan where id=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				user.setId(rs.getLong("id"));
				user.setTenTaiKhoan(rs.getString("tentaikhoan"));
				user.setEmail(rs.getString("email"));
				user.setMatKhau(rs.getString("matkhau"));
				user.setPhanQuyen(rs.getString("phanquyen"));
				user.setHinhAnh(rs.getString("hinhanh"));
				user.setDiaChi(rs.getString("diachi"));
				user.setSoDienThoai(rs.getString("sodienthoai"));
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// lấy ra toàn bô thông tin của tài khoản theo name
	public TaiKhoan getUsersByName(String name) {
		DBConnect cs = new DBConnect();
		TaiKhoan user = new TaiKhoan();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM taikhoan where tentaikhoan=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, name);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				user.setId(rs.getLong("id"));
				user.setTenTaiKhoan(rs.getString("tentaikhoan"));
				user.setEmail(rs.getString("email"));
				user.setMatKhau(rs.getString("matkhau"));
				user.setPhanQuyen(rs.getString("phanquyen"));
				user.setHinhAnh(rs.getString("hinhanh"));
				user.setDiaChi(rs.getString("diachi"));
				user.setSoDienThoai(rs.getString("sodienthoai"));
			}
			// đống kết nối
			rs.close();
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		TaiKhoanDAO  listPr =  new TaiKhoanDAO();
		TaiKhoan pr = new TaiKhoan("loi pro", "loi@gmail.com", "loi123456", "nul", "png", "hatinh", "012345");
		
		listPr.addAccount(pr);
		
	}

}
