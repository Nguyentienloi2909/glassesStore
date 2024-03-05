package repository;

import dao.KhuyenMaiDAO;
import model.KhuyenMai;

public class KhuyenMaiBO {
	KhuyenMaiDAO s = new KhuyenMaiDAO();
	public boolean addKhuyenMai(KhuyenMai km) {
		return s.addKhuyenMai(km);
	}
	
	public int getIdKhuyenMaiByMucKhuyenMai(long muckhuyenmai) {
		return s.getIdKhuyenMaiByMucKhuyenMai(muckhuyenmai);
	}
	public int getMucKhuyenMaiByIdKhuyenMai(long id_khuyenmai) {
		return s.getMucKhuyenMaiByIdKhuyenMai(id_khuyenmai);
	}
	

}
