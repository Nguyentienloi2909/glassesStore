package dao;

import java.sql.PreparedStatement;
import java.sql.Statement;

import model.ChiTietHoaDon;

public class ChiTietHoaDonDAO {
	
	public boolean addChiTietHoaDon(ChiTietHoaDon cthd) {
	    DBConnect cs = new DBConnect();
	    try {
	        cs.KetNoi();
	        String sql = "INSERT INTO web.chitiethoadon(id_hoadon, id_sanpham, soluong) values(?, ?, ?)";

	        try (PreparedStatement preparedStatement = cs.cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        	preparedStatement.setLong(1, cthd.getId_hoaDon());
	        	preparedStatement.setLong(2, cthd.getId_sanPham());
	        	preparedStatement.setLong(3, cthd.getSoLuong());

	            int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (Exception  e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public static void main(String[] args) {
		ChiTietHoaDonDAO dap = new ChiTietHoaDonDAO();
		ChiTietHoaDon chithd = new ChiTietHoaDon(28, 46,2);
		dap.addChiTietHoaDon(chithd);

	}

}
