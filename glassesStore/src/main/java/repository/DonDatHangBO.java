package repository;

import dao.DonDatHangDAO;
import model.DonDatHang;

public class DonDatHangBO {
	DonDatHangDAO s = new DonDatHangDAO();
	
	public long addDonHang(DonDatHang ddh) {
		return s.addDonHang(ddh);
	}
	
	public long addDonHangKhongVouCher(DonDatHang ddh) {
		return s.addDonHangKhongVouCher(ddh);
	}

}
