package model;

public class NhaCungCap {
	private long id;
	private String tenNhaCungCap;
	private String diaChi;
	private String sdt;
	public NhaCungCap(long id, String tenNhaCungCap, String diaChi, String sdt) {
		super();
		this.id = id;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}
	public NhaCungCap(String tenNhaCungCap, String diaChi, String sdt) {
		super();
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}
	public NhaCungCap() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	

}
