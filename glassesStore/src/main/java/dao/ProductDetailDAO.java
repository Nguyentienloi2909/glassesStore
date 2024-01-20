
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Products;
import model.ProductsDetail;

public class ProductDetailDAO {

	
	

	// hàm get hiển thị ra toàn bộ chi tiết sản phẩm giao diện quản lý
	public ArrayList<ProductsDetail> getProductDetail(ProductsDetail pd) {
		DBConnect cs = new DBConnect();
		ArrayList<ProductsDetail> lst = new ArrayList<ProductsDetail>();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.chitietsanpham where id_user = "+pd.getId_user();
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				ProductsDetail detail = new ProductsDetail();
				detail.setId(rs.getLong("id"));
				detail.setId_sanPham(rs.getLong("id_sanpham"));
				detail.setId_user(rs.getLong("id_user"));
				detail.setSoLuong(rs.getLong("soLuong"));
				// Thêm vào danh sách
				lst.add(detail);
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}
	
	public ArrayList<Products> getProductDetailByIdUser(long pd) {
		DBConnect cs = new DBConnect();
		ArrayList<Products> lst = new ArrayList<Products>();
		try {
			cs.KetNoi();
			String sql = " SELECT sp.*, ct.soLuong "
					+ "FROM web.sanpham as sp join web.chitietsanpham as ct on sp.id = ct.id_sanpham "
					+ "where ct.id_user ="+pd;
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				Products products = new Products();
				products.setId(rs.getLong("id"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(rs.getInt("khuyenmai"));
				products.setMoTa(rs.getString("mota"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setTinhTrang(rs.getInt("tinhtrang"));
				products.setSoLuong(rs.getInt("ct.soLuong"));
				// Thêm vào danh sách
				lst.add(products);
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}
	
	public static void main(String[] args) throws Exception {
		 ProductDetailDAO listPr = new ProductDetailDAO(); 
		 ArrayList<Products> list1 = listPr.getProductDetailByIdUser(24); 
			/* ProductsDetail prd = new ProductsDetail(60, 24, 2); */
		
		ProductsDetail pd = new ProductsDetail(60,24 ,4);
		boolean dd = listPr.deleteDetailProduct(pd); 
		System.out.println(dd);
			 
		 for(Products pr:list1) { System.out.println(pr.getSoLuong()); } 
		 	
	}
	
	

	// thêm mới 1 loại sản phẩm

	
	public boolean addDetailProducts(ProductsDetail pd) {
		DBConnect cs = new DBConnect();
	    try {
	        cs.KetNoi();
	        String sql = "INSERT INTO web.chitietsanpham(id_sanpham, id_user, soLuong) VALUES(?, ?, ?)";
	        try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
	            cmd.setLong(1, pd.getId_sanPham());
	            cmd.setLong(2, pd.getId_user());
	            cmd.setLong(3, pd.getSoLuong());
	            
	            // Use executeUpdate for INSERT operations
	            int rowsAffected = cmd.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                return true;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Handle exception appropriately, e.g., log it
	    }
	    return false;
	}

	



	// sửa loại sản phẩm
	public boolean editSoLuongDetailProducts(ProductsDetail pd) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = "UPDATE web.chitietsanpham SET soLuong = ? WHERE id_sanpham = ? and id_user = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, pd.getSoLuong());
			cmd.setLong(2, pd.getId_sanPham());
			cmd.setLong(3, pd.getId_user());
			cmd.executeUpdate();
			cs.cn.close();
			cmd.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// xóa chi tiết sản phẩm theo mã id
	public boolean deleteDetailProduct(ProductsDetail pd) {
		DBConnect cs = new DBConnect();
        try {
            cs.KetNoi();
            String sql = "DELETE FROM web.chitietsanpham WHERE id_sanpham = ? AND id_user = ?";
            
            try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
                cmd.setLong(1, pd.getId_sanPham());
                cmd.setLong(2, pd.getId_user());

                int rowsAffected = cmd.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
