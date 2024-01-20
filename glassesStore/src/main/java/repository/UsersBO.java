
package repository;

import java.util.ArrayList;

import dao.UsersDAO;
import model.Users;


public class UsersBO {
	// gọi lại hàm DAO
	UsersDAO s = new UsersDAO();


	public Users checkLogin(String userNameOrEmail, String pass) {
		return s.checkLogin(userNameOrEmail, pass);
	}

	// Phương thức thêm một tài khoản mới
	public boolean addAccount(Users user) throws Exception {
		return s.addAccount(user);
	}
	
	public boolean addAccountAdmin(Users user) throws Exception {
		return s.addAccountAdmin(user);
	}

	// hàm kiểm tra tài khaorn & email đã tồn tại chưa
	public boolean checkAccountUserName(String userName) {
		return s.checkAccountUserName(userName);
	}
	
	public boolean checkAccountEmail(String email) {
		return s.checkAccountEmail(email);
	}

	

	// Phương thức cập nhật thông tin tài khaonr cho người dùng/ giao diện
	// trangchủ/cá nhân
	public boolean editAccount(Users user) {
		return s.editAccount(user);
	}

	/*------------ PHƯƠNG THỨC CHO ADMIN------------------*/

	// lấy ra toàn bô tài khoản giap diện quản lý
	public ArrayList<Users> getListUsers() {
		return s.getListUsers();
	}

	// xóa tài khoản theo mã id
	public boolean deleteUser(long id) {
		return s.deleteUser(id);
	}

	// lấy ra toàn bô thông tin của tài khoản theo id
	public Users getUsersById(long id) {
		return s.getUsersById(id);
	}

	// Phương thức cập nhật tên hiển thị cho người dùng/ giao diện trang chủ/cá nhân
	public boolean editDisplayNameAccount(String displayName, long id) throws Exception {
		return s.editDisplayNameAccount(displayName, id);
	}

	// Phương thức cập nhật mật khẩu cho người dùng/ giao diện trang chủ/cá nhân
	public boolean editPasswordAccount(String matkhau, long id) throws Exception {
		return s.editPasswordAccount(matkhau, id);
	}
	
	// lấy ra toàn bô thông tin của tài khoản theo name
	public Users getUsersByName(String name) {
		return s.getUsersByName(name);
	}
	
	public boolean editPhanQuyenAccount(int id) {
		return s.editPhanQuyenAccount(id);
	}
	
	public boolean editDeletePhanQuyenAccount(int id) {
		return s.editDeletePhanQuyenAccount(id);
	}
	
}
