
package repository;

import java.util.ArrayList;

import dao.ProductDetailDAO;
import model.Products;
import model.ProductsDetail;


public class ProductDetailBO {
	//
	ProductDetailDAO s = new ProductDetailDAO();


	// hàm get hiển thị ra toàn bộ chi tiết sản phẩm giao diện quản lý
	public ArrayList<ProductsDetail> getProductDetail(ProductsDetail pd) {

		return s.getProductDetail(pd);
	}
	
	public ArrayList<Products> getProductDetailByIdUser(long id_user) {

		return s.getProductDetailByIdUser(id_user);
	}

	// thêm mới 1 loại sản phẩm
	public boolean addDetailProducts(ProductsDetail pd) {
		return s.addDetailProducts(pd);
	}


	// sửa loại sản phẩm
	public boolean editSoLuongDetailProducts(ProductsDetail pd) {

		return s.editSoLuongDetailProducts(pd);
	}

	// xóa chi tiết sản phẩm theo mã id
	public boolean deleteDetailProduct(ProductsDetail pd) {

		return s.deleteDetailProduct(pd);
	}

}
