package repository;

import dao.ChiTietHoaDonDAO;
import model.ChiTietHoaDon;

public class ChiTietHoaDonBO {
	ChiTietHoaDonDAO s = new ChiTietHoaDonDAO();
	public boolean addChiTietHoaDon(ChiTietHoaDon cthd) {
		return s.addChiTietHoaDon(cthd);
	}

}
