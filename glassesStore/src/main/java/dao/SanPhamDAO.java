
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.SanPham;
import repository.KhuyenMaiBO;

/**
 * @author MyPC
 *
 */

public class SanPhamDAO {
	KhuyenMaiBO kmBO = new KhuyenMaiBO();
	
	// hàm get hiển thị ra sản phẩm giao diện Trang chủ và Quản lý
	public ArrayList<SanPham> getListProducts() {
		DBConnect cs = new DBConnect();
		ArrayList<SanPham> lst = new ArrayList<SanPham>();
		try {
			cs.KetNoi();
			String sql = " SELECT sanpham.id, sanpham.tensanpham, sanpham.mota,"
					+ "sanpham.giagoc, sanpham.anhchinh, sanpham.soLuong, sanpham.id_loaisp,"
					+ "khuyenmai.muckhuyenmai, sanpham.id_nhacungcap FROM web.sanpham join khuyenmai on sanpham.id_khuyenmai = khuyenmai.id_khuyenmai";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				SanPham products = new SanPham();
				products.setId(rs.getLong("id"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setMoTa(rs.getString("mota"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setSoLuong(rs.getInt("soLuong"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(rs.getInt("muckhuyenmai"));
				products.setId_nhaCungCap(rs.getLong("id_nhacungcap"));
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
	public ArrayList<SanPham> getListProductsTop8() {
		DBConnect cs = new DBConnect();
		ArrayList<SanPham> lst = new ArrayList<SanPham>();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.sanpham\n"
					+ "LIMIT 8;";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				SanPham products = new SanPham();
				products.setId(rs.getLong("id"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setMoTa(rs.getString("mota"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setSoLuong(rs.getInt("soLuong"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(kmBO.getMucKhuyenMaiByIdKhuyenMai(rs.getInt("id_khuyenmai")));
				products.setId_nhaCungCap(rs.getLong("id_nhacungcap"));
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
	public ArrayList<SanPham> getProductsByCategory(String maLoai) {
		DBConnect cs = new DBConnect();
		ArrayList<SanPham> lst = new ArrayList<SanPham>();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.SANPHAM WHERE id_loaisp=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, maLoai);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				SanPham products = new SanPham();
				products.setId(rs.getLong("id"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setMoTa(rs.getString("mota"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setSoLuong(rs.getInt("soLuong"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(kmBO.getMucKhuyenMaiByIdKhuyenMai(rs.getInt("id_khuyenmai")));
				products.setId_nhaCungCap(rs.getLong("id_nhacungcap"));
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

	public ArrayList<SanPham> getProductsByName(String name) {
		DBConnect cs = new DBConnect();
		ArrayList<SanPham> lst = new ArrayList<SanPham>();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.SANPHAM WHERE TENSANPHAM LIKE '%"+name+"%' ";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			//cmd.setString(1, name);
			//System.out.println(name+"gt3");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				SanPham products = new SanPham();
				products.setId(rs.getLong("id"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setMoTa(rs.getString("mota"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setSoLuong(rs.getInt("soLuong"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(kmBO.getMucKhuyenMaiByIdKhuyenMai(rs.getInt("id_khuyenmai")));
				products.setId_nhaCungCap(rs.getLong("id_nhacungcap"));
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
	public SanPham getProductsByID(long idSanPham) {
		DBConnect cs = new DBConnect();
		SanPham lst = new SanPham();
		try {
			cs.KetNoi();
			String sql = " SELECT * FROM web.SANPHAM WHERE id=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, idSanPham);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String tenSanPham = rs.getString("tensanpham");
				String moTa = rs.getString("mota");
				double giaGoc = rs.getDouble("giagoc");
				String anhChinh = rs.getString("anhchinh");
				int soLuong = rs.getInt("soLuong");
				long id_loaiSanPham = rs.getLong("id_loaisp");		
				long id_nhaCungCap = rs.getLong("id_nhacungcap");
				int khuyenMai = kmBO.getMucKhuyenMaiByIdKhuyenMai(rs.getInt("id_khuyenmai"));
				// Thêm vào danh sách				
				lst = new SanPham(id, tenSanPham, moTa, giaGoc, anhChinh, soLuong, id_loaiSanPham, id_nhaCungCap, khuyenMai);
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

	
	public boolean addProduct(SanPham pr) {
		DBConnect cs = new DBConnect();
		
        try {
			try {
				cs.KetNoi();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            String sql = "INSERT INTO web.sanpham (tensanpham, mota, giagoc, anhchinh, soluong, id_loaisp, id_nhacungcap, id_khuyenmai) "
            		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = cs.cn.prepareStatement(sql)) {
                preparedStatement.setString(1, pr.getTenSanPham());
                preparedStatement.setString(2, pr.getMoTa());
                preparedStatement.setDouble(3, pr.getGiaGoc());
                preparedStatement.setString(4, pr.getAnhChinh());
                preparedStatement.setLong(5, pr.getSoLuong());
                preparedStatement.setLong(6, pr.getId_loaiSanPham());
                preparedStatement.setLong(7, pr.getId_nhaCungCap());
                preparedStatement.setLong(8, pr.getKhuyenMai());

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return false;
    }
	
	

	// sửa sản phẩm
	public boolean editProduct(SanPham pr) {
		DBConnect cs = new DBConnect();	
		try {
            cs.KetNoi();
            String sql = "UPDATE web.sanpham SET tensanpham = ?, mota = ?, giagoc = ?, anhchinh = ?, soLuong = ?,"
            		+ " id_loaisp = ?, id_nhacungcap = ?, id_khuyenmai = ? WHERE id = ?";
            
            try (PreparedStatement cmd = cs.cn.prepareStatement(sql)) {
                cmd.setString(1, pr.getTenSanPham());
                cmd.setString(2, pr.getMoTa());
                cmd.setDouble(3, pr.getGiaGoc());
                cmd.setString(4, pr.getAnhChinh());
                cmd.setLong(5, pr.getSoLuong());
                cmd.setLong(6, pr.getId_loaiSanPham());
                cmd.setLong(7, pr.getId_nhaCungCap());
                cmd.setLong(8,kmBO.getIdKhuyenMaiByMucKhuyenMai(pr.getKhuyenMai()));
                cmd.setLong(9, pr.getId());

                int rowsAffected = cmd.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
//	public static void main(String[] args) throws Exception {
//		SanPhamDAO  listPr =  new SanPhamDAO();
//		SanPham pr = new SanPham("kinh ap trong", "ap trong cua loi", 345000, "aptrong.png", 45, 1, 2, 3);
//		
//		listPr.addProduct(pr);
//		
//	}


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


