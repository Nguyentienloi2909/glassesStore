package model;

import java.sql.Date;

public class Voucher {	
	private long idvoucher;
	private long khuyenmai;
	private String tenvoucher;
	private String ngayBatDau;
	private String ngayKetThuc;
	
	
	
	
	public Voucher(long idvoucher, long khuyenmai, String tenvoucher, String ngayBatDau, String ngayKetThuc) {
		super();
		this.idvoucher = idvoucher;
		this.khuyenmai = khuyenmai;
		this.tenvoucher = tenvoucher;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	
	public Voucher(long khuyenmai, String tenvoucher, String ngayBatDau, String ngayKetThuc) {
		super();
		this.khuyenmai = khuyenmai;
		this.tenvoucher = tenvoucher;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}


	public Voucher() {
	}

	public long getIdvoucher() {
		return idvoucher;
	}

	public void setIdvoucher(long idvoucher) {
		this.idvoucher = idvoucher;
	}

	public long getKhuyenmai() {
		return khuyenmai;
	}

	public void setKhuyenmai(long khuyenmai) {
		this.khuyenmai = khuyenmai;
	}

	public String getTenvoucher() {
		return tenvoucher;
	}

	public void setTenvoucher(String tenvoucher) {
		this.tenvoucher = tenvoucher;
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
