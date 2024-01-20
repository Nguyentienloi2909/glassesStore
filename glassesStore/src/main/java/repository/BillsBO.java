package repository;

import dao.BillsDAO;
import model.Bills;

public class BillsBO {
	BillsDAO s = new BillsDAO();
	
	public boolean addBill(Bills bill) {
		return s.addBill(bill);
	}
}
