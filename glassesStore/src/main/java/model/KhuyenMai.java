package model;

public class KhuyenMai {
	private long id_KhuyenMai;
	private long mucKhuyenMai;
	private String ngayBatDau;
	private String ngayKetThuc;
	
	
	
	public KhuyenMai(long id_KhuyenMai, long mucKhuyenMai, String ngayBatDau, String ngayKetThuc) {
		super();
		this.id_KhuyenMai = id_KhuyenMai;
		this.mucKhuyenMai = mucKhuyenMai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
	
	
	
	
	public KhuyenMai(long mucKhuyenMai) {
		super();
		this.mucKhuyenMai = mucKhuyenMai;
	}




	public KhuyenMai() {
		super();
	}


	public long getId_KhuyenMai() {
		return id_KhuyenMai;
	}
	public void setId_KhuyenMai(long id_KhuyenMai) {
		this.id_KhuyenMai = id_KhuyenMai;
	}
	public long getMucKhuyenMai() {
		return mucKhuyenMai;
	}
	public void setMucKhuyenMai(long mucKhuyenMai) {
		this.mucKhuyenMai = mucKhuyenMai;
	}


	public String getNgayBatDau() {
		return ngayBatDau;
	}


	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}


	public String getNgayKetThuc() {
		return ngayKetThuc;
	}


	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	
	
	
}
