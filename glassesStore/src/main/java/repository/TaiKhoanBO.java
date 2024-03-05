
package repository;

import java.util.ArrayList;

import dao.TaiKhoanDAO;
import model.TaiKhoan;


public class TaiKhoanBO {
	// gọi lại hàm DAO
	TaiKhoanDAO s = new TaiKhoanDAO();


	public TaiKhoan checkLogin(String userNameOrEmail, String pass) {
		return s.checkLogin(userNameOrEmail, pass);
	}

	// Phương thức thêm một tài khoản mới
	public boolean addAccount(TaiKhoan user) throws Exception {
		return s.addAccount(user);
	}
	
	public boolean addAccountAdmin(TaiKhoan user) throws Exception {
		return s.addAccountAdmin(user);
	}

	// hàm kiểm tra tài khaorn & email đã tồn tại chưa
	public boolean checkAccountTenTaiKhoan(String tenTaiKhoan) {
		return s.checkAccountTenTaiKhoan(tenTaiKhoan);
	}
	
	public boolean checkAccountEmail(String email) {
		return s.checkAccountEmail(email);
	}

	/*------------ PHƯƠNG THỨC CHO ADMIN------------------*/

	// lấy ra toàn bô tài khoản giap diện quản lý
	public ArrayList<TaiKhoan> getListUsers() {
		return s.getListUsers();
	}

	// xóa tài khoản theo mã id
	public boolean deleteUser(long id) {
		return s.deleteUser(id);
	}

	// lấy ra toàn bô thông tin của tài khoản theo id
	public TaiKhoan getUsersById(long id) {
		return s.getUsersById(id);
	}


	// Phương thức cập nhật mật khẩu cho người dùng/ giao diện trang chủ/cá nhân
	public boolean editPasswordAccount(String matkhau, long id) throws Exception {
		return s.editPasswordAccount(matkhau, id);
	}
	
	// lấy ra toàn bô thông tin của tài khoản theo name
	public TaiKhoan getUsersByName(String name) {
		return s.getUsersByName(name);
	}
	
	public boolean editPhanQuyenAccount(int id) {
		return s.editPhanQuyenAccount(id);
	}
	
	public boolean editDeletePhanQuyenAccount(int id) {
		return s.editDeletePhanQuyenAccount(id);
	}
	
	public boolean UpdateDiaChiAnhdSDT(TaiKhoan user) {
		return s.UpdateDiaChiAnhdSDT(user);
	}
	
}
