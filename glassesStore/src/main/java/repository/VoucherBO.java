package repository;

import dao.VoucherDAO;
import model.Voucher;

public class VoucherBO {
	VoucherDAO s = new VoucherDAO();
	public boolean checkVoucher(String tenvoucher) {
		return s.checkVoucher(tenvoucher);
	}
	
	public Voucher getVoucherByTenvoucher(String tenvoucher) {
		return s.getVoucherByTenvoucher(tenvoucher);
	}
}
