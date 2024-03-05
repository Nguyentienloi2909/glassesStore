
package model;

public class TaiKhoan {
	private long id;
	
	private String tenTaiKhoan;
	private String email;
	private String matKhau;
	private String phanQuyen;
	private String hinhAnh;
	private String diaChi;
	private String soDienThoai;
	public TaiKhoan(long id, String tenTaiKhoan, String email, String matKhau, String phanQuyen, String hinhAnh,
			String diaChi, String soDienThoai) {
		super();
		this.id = id;
		this.tenTaiKhoan = tenTaiKhoan;
		this.email = email;
		this.matKhau = matKhau;
		this.phanQuyen = phanQuyen;
		this.hinhAnh = hinhAnh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}
	public TaiKhoan(String tenTaiKhoan, String email, String matKhau, String phanQuyen, String hinhAnh, String diaChi,
			String soDienThoai) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.email = email;
		this.matKhau = matKhau;
		this.phanQuyen = phanQuyen;
		this.hinhAnh = hinhAnh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}
	public TaiKhoan() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getPhanQuyen() {
		return phanQuyen;
	}
	public void setPhanQuyen(String phanQuyen) {
		this.phanQuyen = phanQuyen;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	

}
