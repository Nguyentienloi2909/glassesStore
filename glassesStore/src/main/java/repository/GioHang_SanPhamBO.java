
package repository;

import java.util.ArrayList;

import dao.GioHangDAO;
import model.GioHang_SanPham;
import model.SanPham;


public class GioHang_SanPhamBO {
	//
	GioHangDAO s = new GioHangDAO();


	// hàm get hiển thị ra toàn bộ chi tiết sản phẩm giao diện quản lý
	public ArrayList<SanPham> getSanPhamTrongGioHang(long id) {

		return s.getSanPhamTrongGioHang(id);
	}
	
	public ArrayList<GioHang_SanPham> getGioHangSanPham(GioHang_SanPham pd) {

		return s.getGioHangSanPham(pd);
	}
	

	// thêm mới 1 loại sản phẩm
	public boolean addGioHangSanPham(GioHang_SanPham pd) {
		return s.addGioHangSanPham(pd);
	}


	// sửa loại sản phẩm
	public boolean editSoLuong(GioHang_SanPham pd) {

		return s.editSoLuong(pd);
	}

	// xóa chi tiết sản phẩm theo mã id
	public boolean deleteGioHangSanPham(GioHang_SanPham pd) {

		return s.deleteGioHangSanPham(pd);
	}
	
	public boolean deleteSanPhamTrongGioHang(GioHang_SanPham pd) {
		return s.deleteSanPhamTrongGioHang(pd);
	}

}
