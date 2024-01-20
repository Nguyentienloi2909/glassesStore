
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Products;

/**
 * @author MyPC
 *
 */

public class ProductsDAO {
	// hàm get hiển thị ra sản phẩm giao diện Trang chủ và Quản lý
	public ArrayList<Products> getListProducts() {
		DBConnect cs = new DBConnect();
		ArrayList<Products> lst = new ArrayList<Products>();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.sanpham";
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
				products.setSoLuong(rs.getInt("soLuong"));
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
	
	

	// get top 8 sản phẩm ra Trang chủ
	// hàm get hiển thị ra sản phẩm giao diện Trang chủ và Quản lý
	public ArrayList<Products> getListProductsTop8() {
		DBConnect cs = new DBConnect();
		ArrayList<Products> lst = new ArrayList<Products>();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.sanpham\n"
					+ "LIMIT 8;";
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
				products.setSoLuong(rs.getInt("soLuong"));
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

	// hàm get hiển thị ra sản phẩm theo loại sản phẩm giao diện Trang chủ
	public ArrayList<Products> getProductsByCategory(String maLoai) {
		DBConnect cs = new DBConnect();
		ArrayList<Products> lst = new ArrayList<Products>();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.SANPHAM WHERE id_loaisp=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, maLoai);
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
				products.setSoLuong(rs.getInt("soLuong"));
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

	// hàm get hiển thị ra sản phẩm khi nhập Tìm kiếm giao diện Trang chủ
	public ArrayList<Products> getProductsByName(String name) {
		DBConnect cs = new DBConnect();
		ArrayList<Products> lst = new ArrayList<Products>();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.SANPHAM WHERE TENSANPHAM LIKE '%"+name+"%' ";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			//cmd.setString(1, name);
			//System.out.println(name+"gt3");
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
				products.setSoLuong(rs.getInt("soLuong"));
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

	// hàm get hiển thị ra sản phẩm theo mã id- giao diện Trang chủ / giỏ hàng
	public Products getProductsByID(long idSanPham) {
		DBConnect cs = new DBConnect();
		Products lst = new Products();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.SANPHAM WHERE id=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, idSanPham);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				long id_loaiSanPham = rs.getLong("id_loaisp");
				String tenSanPham = rs.getString("tensanpham");
				String moTa = rs.getString("mota");
				String anhChinh = rs.getString("anhchinh");
				int giaGoc = rs.getInt("giagoc");
				int khuyenMai = rs.getInt("khuyenmai");
				int tinhTrang = rs.getInt("tinhtrang");
				int soLuong = rs.getInt("soLuong");
				// Thêm vào danh sách
				lst = new Products(id, id_loaiSanPham, tenSanPham, moTa, anhChinh, giaGoc, khuyenMai,
						tinhTrang, soLuong);
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// System.out.println(lst.getId()+"kkkk");
		return lst;
	}
	
	
	public Products findProduct(long idSanPham) {
		DBConnect cs = new DBConnect();
		Products lst = new Products();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.SANPHAM WHERE id=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, idSanPham);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				long id_loaiSanPham = rs.getLong("id_loaisp");
				String tenSanPham = rs.getString("tensanpham");
				String moTa = rs.getString("mota");
				String anhChinh = rs.getString("anhchinh");
				int giaGoc = rs.getInt("giagoc");
				int khuyenMai = rs.getInt("khuyenmai");
				int tinhTrang = rs.getInt("tinhtrang");
				int soLuong = rs.getInt("soLuong");
				// Thêm vào danh sách
				lst = new Products(id, id_loaiSanPham, tenSanPham, moTa, anhChinh, giaGoc, khuyenMai, 
						tinhTrang, soLuong);
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// System.out.println(lst.getId()+"kkkk");
		return lst;
	}
	

	



	/* Phần quản lý admin */
	// thêm sản phẩm

	
	public boolean addProduct(Products pr) {
		DBConnect cs = new DBConnect();
        try {
			cs.KetNoi();
            String sql = "INSERT INTO web.sanpham (tensanpham, mota, giagoc, khuyenmai, anhchinh, tinhtrang, soLuong, id_loaisp) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = cs.cn.prepareStatement(sql)) {
                preparedStatement.setString(1, pr.getTenSanPham());
                preparedStatement.setString(2, pr.getMoTa());
                preparedStatement.setDouble(3, pr.getGiaGoc());
                preparedStatement.setDouble(4, pr.getKhuyenMai());
                preparedStatement.setString(5, pr.getAnhChinh());
                preparedStatement.setInt(6, pr.getTinhTrang());
                preparedStatement.setLong(7, pr.getSoLuong());
                preparedStatement.setLong(8, pr.getId_loaiSanPham());

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	

	// sửa sản phẩm
	public boolean editProduct(Products pr) {
		DBConnect cs = new DBConnect();	
		try {
            cs.KetNoi();
            String sql = "UPDATE web.sanpham SET tensanpham = ?, mota = ?, giagoc = ?, khuyenmai = ?, anhchinh = ?, tinhtrang = ?, soLuong = ?, id_loaisp = ? WHERE id = ?";
            
            try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
                cmd.setString(1, pr.getTenSanPham());
                cmd.setString(2, pr.getMoTa());
                cmd.setDouble(3, pr.getGiaGoc());
                cmd.setDouble(4, pr.getKhuyenMai());
                cmd.setString(5, pr.getAnhChinh());
                cmd.setInt(6, pr.getTinhTrang());
                cmd.setLong(7, pr.getSoLuong());
                cmd.setLong(8, pr.getId_loaiSanPham());
                cmd.setLong(9, pr.getId());

                int rowsAffected = cmd.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public static void main(String[] args) throws Exception {
		ProductsDAO  listPr =  new ProductsDAO();
		Products pr = new Products(124 ,2, "dfdfloi","dfdfloi" , "dfdfloi", 90000, 2,  1, 32);
		boolean pr1 = listPr.editProduct(pr);

		System.out.println( pr1);
	
		
	}


	// get 1 sản phẩm theo id
	// xóa sản phẩm theo mã id
	public boolean deleteProduct(long id) {
		DBConnect cs = new DBConnect();
		try {
			cs.KetNoi();
			String sql = "DELETE FROM web.sanpham WHERE id = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			cmd.executeUpdate();
			cs.cn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/* Phân trang sản phẩm ở trang product.jsp */
	
	// ĐẾM tổng số sản phẩm
	public int getCount() throws Exception {
		DBConnect cs = new DBConnect();
		String sql = "SELECT count(id) FROM web.sanpham";
		int count = 0;
		try {
			cs.KetNoi();
			PreparedStatement stmt = cs.cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			cs.cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	


}


