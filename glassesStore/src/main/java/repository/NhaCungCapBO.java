package repository;

import java.util.ArrayList;

import dao.NhaCungCapDAO;
import model.NhaCungCap;


public class NhaCungCapBO {
	NhaCungCapDAO s = new NhaCungCapDAO();
	public ArrayList<NhaCungCap> getListCategory(){
		return s.getListCategory();
	}
	
	public int getIdNhaCungCapByTenNCC(String tenNCC) {
		return s.getIdNhaCungCapByTenNCC(tenNCC);
	}

}
