package model;

public class GioHang_SanPham {
	private long id_GioHang;
	private long id_SanPham;
	private long id_taikhoan;
	private long soLuong;
	private double tongtien;
	
	public GioHang_SanPham(long id_GioHang, long id_SanPham, long id_taikhoan, long soLuong, double tongtien) {
		super();
		this.id_GioHang = id_GioHang;
		this.id_SanPham = id_SanPham;
		this.id_taikhoan = id_taikhoan;
		this.soLuong = soLuong;
		this.tongtien = tongtien;
	}
	
	public GioHang_SanPham(long id_SanPham, long id_taikhoan, long soLuong, double tongtien) {
		super();
		this.id_SanPham = id_SanPham;
		this.id_taikhoan = id_taikhoan;
		this.soLuong = soLuong;
		this.tongtien = tongtien;
	}
	
	
	public GioHang_SanPham(long id_taikhoan) {
		super();
		this.id_taikhoan = id_taikhoan;
	}

	public GioHang_SanPham() {
		super();
	}
	public long getId_GioHang() {
		return id_GioHang;
	}
	public void setId_GioHang(long id_GioHang) {
		this.id_GioHang = id_GioHang;
	}
	public long getId_SanPham() {
		return id_SanPham;
	}
	public void setId_SanPham(long id_SanPham) {
		this.id_SanPham = id_SanPham;
	}
	public long getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}
	public long getId_taikhoan() {
		return id_taikhoan;
	}
	public void setId_taikhoan(long id_taikhoan) {
		this.id_taikhoan = id_taikhoan;
	}
	public double getTongtien() {
		return tongtien;
	}
	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	
	
	
	
}
