package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Users;
import model.Voucher;

public class VoucherDAO {
	public boolean checkVoucher(String tenvoucher) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.voucher where tenvoucher = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tenvoucher);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return true;
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public Voucher getVoucherByTenvoucher(String tenvoucher) {
		
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.voucher where tenvoucher = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tenvoucher);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				Voucher voucher = new Voucher();
				voucher.setIdvoucher(rs.getLong("idvoucher"));
				voucher.setKhuyenmai(rs.getLong("khuyenmai"));
				voucher.setTenvoucher(rs.getString("tenvoucher"));
				return voucher;
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		VoucherDAO voucher = new VoucherDAO();
		System.out.println(voucher.getVoucherByTenvoucher("voucher20").getTenvoucher());
	}
}
