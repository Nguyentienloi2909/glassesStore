
package repository;

import java.util.ArrayList;

import dao.SanPhamDAO;
import model.SanPham;


public class SanPhamBO {
	// gọi làm hàm DAO
	SanPhamDAO s = new SanPhamDAO();

	// hàm get list sản phẩm ra
	public ArrayList<SanPham> getListProducts() {
		return s.getListProducts();
	}

	// hàm get hiển thị ra sản phẩm giao diện Trang chủ và Quản lý
	public ArrayList<SanPham> getListProductsTop8() {
		return s.getListProductsTop8();
	}

	// hàm get hiển thị ra sản phẩm theo loại sản phẩm giao diện Trang chủ
	public ArrayList<SanPham> getProductsByCategory(String maLoai) {
		return s.getProductsByCategory(maLoai);
	}
	

	// hàm get hiển thị ra sản phẩm khi nhập Tìm kiếm giao diện Trang chủ
	public ArrayList<SanPham> getProductsByName(String tenSanPham) {
		return s.getProductsByName(tenSanPham);
	}

	// hàm get hiển thị ra sản phẩm theo mã id- giao diện Trang chủ / giỏ hàng
	public SanPham getProductsByID(long idSanPham) {
		return s.getProductsByID(idSanPham);
	}

	// admin
	// hàm thêm sản phẩm
	public boolean addProducts(SanPham pr){
		return s.addProduct(pr);
	}

	// sửa sản phẩm
	public boolean editProduct(SanPham pr) {
		return s.editProduct(pr);
	}

	// xóa sản phẩm theo mã id
	public boolean deleteProduct(long id) {
		return s.deleteProduct(id);
	}


	// ĐẾM tổng số sản phẩm
	public int getCount() throws Exception {
			return s.getCount();
		}

}
