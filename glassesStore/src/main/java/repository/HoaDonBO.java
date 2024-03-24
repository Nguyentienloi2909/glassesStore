package repository;

import dao.HoaDonDAO;
import model.HoaDon;

public class HoaDonBO {
	HoaDonDAO s = new HoaDonDAO();
	
	public long addBill(HoaDon bill) {
		return s.addBill(bill);
	}
}
