
package model;

public class Bills {
	/**
	 * 
	 */
	private long id;
	private String ghichu;
	private String diachi;
	private String sdt;



	public Bills(long id, String ghichu, String diachi, String sdt) {
		super();
		this.id = id;
		this.ghichu = ghichu;
		this.diachi = diachi;
		this.sdt = sdt;
	}
	
	public Bills(String ghichu, String diachi, String sdt) {
		super();
		this.ghichu = ghichu;
		this.diachi = diachi;
		this.sdt = sdt;
	}

	public Bills() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	

	

	

}
