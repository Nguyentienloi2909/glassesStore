package model;


public class DonDatHang {
	private long id;
	private long id_voucher;
	private long id_taiKhoan;
	private String ngayDat;
	private double tongTienThanhToan;
	public DonDatHang(long id, long id_voucher, long id_taiKhoan, String ngayDat, double tongTienThanhToan) {
		super();
		this.id = id;
		this.id_voucher = id_voucher;
		this.id_taiKhoan = id_taiKhoan;
		this.ngayDat = ngayDat;
		this.tongTienThanhToan = tongTienThanhToan;
	}
	public DonDatHang(long id_voucher, long id_taiKhoan, String ngayDat, double tongTienThanhToan) {
		super();
		this.id_voucher = id_voucher;
		this.id_taiKhoan = id_taiKhoan;
		this.ngayDat = ngayDat;
		this.tongTienThanhToan = tongTienThanhToan;
	}
	
	public DonDatHang(long id_voucher, long id_taiKhoan, double tongTienThanhToan) {
		super();
		this.id_voucher = id_voucher;
		this.id_taiKhoan = id_taiKhoan;
		this.tongTienThanhToan = tongTienThanhToan;
	}
	
	public DonDatHang( long id_taiKhoan, double tongTienThanhToan) {
		super();
		this.id_taiKhoan = id_taiKhoan;
		this.tongTienThanhToan = tongTienThanhToan;
	}
	
	public DonDatHang() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_voucher() {
		return id_voucher;
	}
	public void setId_voucher(long id_voucher) {
		this.id_voucher = id_voucher;
	}
	public long getId_taiKhoan() {
		return id_taiKhoan;
	}
	public void setId_taiKhoan(long id_taiKhoan) {
		this.id_taiKhoan = id_taiKhoan;
	}
	public String getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
	}
	public double getTongTienThanhToan() {
		return tongTienThanhToan;
	}
	public void setTongTienThanhToan(double tongTienThanhToan) {
		this.tongTienThanhToan = tongTienThanhToan;
	}
	
	
}
