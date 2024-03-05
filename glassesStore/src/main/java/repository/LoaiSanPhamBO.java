/**
*Project name: ShopBanHang
*Version : 1.0
*Created date : 12 thg 3, 2019
*Description: Create by MyPC
*Copyright (c) 2019 by TeddyShoes. All rights reserved.
*/
package repository;

import java.util.ArrayList;

import dao.LoaiSanPhamDAO;
import model.LoaiSanPham;

/**
 * @author MyPC
 *
 */
public class LoaiSanPhamBO {
	// gọi lại hàm DAO
	LoaiSanPhamDAO s = new LoaiSanPhamDAO();

	// hàm get hiển thị ra LOẠI sản phẩm giao diện Trang chủ và Quản lý
	public ArrayList<LoaiSanPham> getListCategory() {
		return s.getListCategory();
	}

	// thêm mới 1 loại sản phẩm
	public boolean addCategory(LoaiSanPham ca) {
		return s.addCategory(ca);
	}

	// hàm get hiển thị ra loại sản phẩm theo mã id-
	public LoaiSanPham getCategoryByID(long id) {
		return s.getCategoryByID(id);
	}

	// sửa loại sản phẩm
	public boolean editCategory(LoaiSanPham ca) {
		return s.editCategory(ca);
	}

	// xóa loại sản phẩm theo mã id
	public int deleteCategory(long id) {
		return s.deleteProduct(id);
	}
	
	public int getIdLoaiSPByTenSP(String tenLoai) {
		return s.getIdLoaiSPByTenSP(tenLoai);
	}

}
