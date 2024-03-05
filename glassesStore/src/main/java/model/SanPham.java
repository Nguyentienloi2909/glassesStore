
package model;

public class SanPham {
	private long id;
	private String tenSanPham;
	private String moTa;
	private double giaGoc;
	private String anhChinh;
	private int soLuong;
	private int khuyenMai;
	private long id_loaiSanPham;
	private long id_nhaCungCap;
	
	
	
	public SanPham(long id, String tenSanPham, String moTa, double giaGoc, String anhChinh,  int soLuong,
			long id_loaiSanPham, long id_nhaCungCap, int khuyenMai) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.giaGoc = giaGoc;
		this.anhChinh = anhChinh;
		this.soLuong = soLuong;
		this.id_loaiSanPham = id_loaiSanPham;
		this.id_nhaCungCap = id_nhaCungCap;
		this.khuyenMai = khuyenMai;
	}
	
	
	
	public SanPham() {
		super();
	}

	


	public SanPham(String tenSanPham, String moTa, double giaGoc, String anhChinh, int soLuong, long id_loaiSanPham, 
			long id_nhaCungCap, int khuyenMai) {
		super();
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.giaGoc = giaGoc;
		this.anhChinh = anhChinh;
		this.soLuong = soLuong;
		this.id_loaiSanPham = id_loaiSanPham;
		this.id_nhaCungCap = id_nhaCungCap;
		this.khuyenMai = khuyenMai;
		
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_loaiSanPham() {
		return id_loaiSanPham;
	}
	public void setId_loaiSanPham(long id_loaiSanPham) {
		this.id_loaiSanPham = id_loaiSanPham;
	}
	public long getId_nhaCungCap() {
		return id_nhaCungCap;
	}
	public void setId_nhaCungCap(long id_nhaCungCap) {
		this.id_nhaCungCap = id_nhaCungCap;
	}
	public long getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(int khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getAnhChinh() {
		return anhChinh;
	}
	public void setAnhChinh(String anhChinh) {
		this.anhChinh = anhChinh;
	}
	public double getGiaGoc() {
		return giaGoc;
	}
	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	
}
