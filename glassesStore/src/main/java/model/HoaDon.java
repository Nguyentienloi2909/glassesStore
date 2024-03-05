
package model;

public class HoaDon {
	/**
	 * 
	 */
	private long id;
	private String ngayIn;
	private double tongTien;
	private long id_donDatHang;
	private String hinhThucThanhToan;
	
	public HoaDon(long id, String ngayIn, double tongTien, long id_donDatHang, String hinhThucThanhToan) {
		super();
		this.id = id;
		this.ngayIn = ngayIn;
		this.tongTien = tongTien;
		this.id_donDatHang = id_donDatHang;
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	
	public HoaDon(String ngayIn, double tongTien, long id_donDatHang, String hinhThucThanhToan) {
		super();
		this.ngayIn = ngayIn;
		this.tongTien = tongTien;
		this.id_donDatHang = id_donDatHang;
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public HoaDon( double tongTien, long id_donDatHang, String hinhThucThanhToan) {
		super();
		this.tongTien = tongTien;
		this.id_donDatHang = id_donDatHang;
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public HoaDon() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNgayIn() {
		return ngayIn;
	}
	public void setNgayIn(String ngayIn) {
		this.ngayIn = ngayIn;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public long getId_donDatHang() {
		return id_donDatHang;
	}
	public void setId_donDatHang(long id_donDatHang) {
		this.id_donDatHang = id_donDatHang;
	}
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	

	

}
