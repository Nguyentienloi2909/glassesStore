
package model;

public class ChiTietHoaDon {
	private long id_hoaDon;
	private long id_sanPham;
	private long soLuong;
	
	public ChiTietHoaDon(long id_hoaDon, long id_sanPham, long soLuong) {
		super();
		this.id_hoaDon = id_hoaDon;
		this.id_sanPham = id_sanPham;
		this.soLuong = soLuong;
	}


	public ChiTietHoaDon() {
		super();
	}
	public long getId_hoaDon() {
		return id_hoaDon;
	}
	public void setId_hoaDon(long id_hoaDon) {
		this.id_hoaDon = id_hoaDon;
	}
	public long getId_sanPham() {
		return id_sanPham;
	}
	public void setId_sanPham(long id_sanPham) {
		this.id_sanPham = id_sanPham;
	}


	public long getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}
	
	
	
	
}
