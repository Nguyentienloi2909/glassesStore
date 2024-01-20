package model;

public class Voucher {	
	private long idvoucher;
	private long khuyenmai;
	private String tenvoucher;
	
	public Voucher(long idvoucher, long khuyenmai, String tenvoucher) {
		super();
		this.idvoucher = idvoucher;
		this.khuyenmai = khuyenmai;
		this.tenvoucher = tenvoucher;
	}
	
	public Voucher(long khuyenmai, String tenvoucher) {
		super();
		this.khuyenmai = khuyenmai;
		this.tenvoucher = tenvoucher;
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
	
	
	
	
}
