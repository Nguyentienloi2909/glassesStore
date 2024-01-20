
package model;

/**
 * @author MyPC
 *
 */
public class ProductsDetail {
	/**
	 * 
	 */
	private long id;
	private long id_sanPham;
	private long id_user;
	private long soLuong;
	public ProductsDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param id_sanPham
	 * @param anhChiTiet
	 */
	public ProductsDetail(long id, long id_sanPham, long id_user, long soLuong) {
		super();
		this.id = id;
		this.id_sanPham = id_sanPham;
		this.id_user = id_user;
		this.soLuong = soLuong;
	}
	
	public ProductsDetail(long id_sanPham, long id_user, long soLuong) {
		this.id_sanPham = id_sanPham;
		this.id_user = id_user;
		this.soLuong = soLuong;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the id_sanPham
	 */
	public long getId_sanPham() {
		return id_sanPham;
	}

	/**
	 * @param id_sanPham
	 *            the id_sanPham to set
	 */
	public void setId_sanPham(long id_sanPham) {
		this.id_sanPham = id_sanPham;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}
	
	

	/**
	 * @return the anhChiTiet
	 */



}
