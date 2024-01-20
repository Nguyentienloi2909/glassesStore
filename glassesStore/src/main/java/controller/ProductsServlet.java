package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Products;
import model.ProductsDetail;
import model.Users;
import repository.CategoryBO;
import repository.ProductDetailBO;
import repository.ProductsBO;

/**
 * Servlet implementation class HomeProductsServlet
 */
@WebServlet(name = "ProductsServlet", urlPatterns = {"/sanpham"}) 
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ProductsBO p = new ProductsBO();
		CategoryBO c = new CategoryBO();
		
		String idLoaiSp = request.getParameter("id_category"); // mĂ£ loáº¡i sáº£npháº©m
		String search = request.getParameter("search"); // tĂ¬m kiáº¿m theo tĂªn ngÆ°á»�i dĂ¹ng nháº­p 
		String key = request.getParameter("key");
		 
		ArrayList<Products> lstP=null;
		lstP = p.getListProducts();
		
		  if (idLoaiSp != null) { 
			  lstP = p.getProductsByCategory(idLoaiSp); 
		  } if(search != null) 
		  { 
			  lstP = p.getProductsByName(key); 
		  }
		 
		request.setAttribute("lstProducts", lstP);
		request.setAttribute("lstCategory", c.getListCategory());
		addProductToCart(request);
		request.getRequestDispatcher("./views/SanPham.jsp").forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void addProductToCart(HttpServletRequest request) { 
		ProductsBO sp = new ProductsBO();
		ProductDetailBO prd = new ProductDetailBO();
		Users user = (Users)request.getSession().getAttribute("user");
		int id_product;
		try {
			id_product = Integer.parseInt(request.getParameter("id_product"));
		}catch (Exception e) {
			// TODO: handle exception
			id_product = 0;
		}
		
		
		
		if(id_product>0  && user!= null) {
			ProductsDetail productsDetail = new ProductsDetail(id_product, user.getId(), 1);
			ArrayList<ProductsDetail> listCart = prd.getProductDetail(productsDetail);
			boolean isProductInCart = false;
			
			
			for(ProductsDetail pro:listCart) {
				if(pro.getId_sanPham()==id_product) {
					pro.setSoLuong(pro.getSoLuong()+1);
					prd.editSoLuongDetailProducts(pro);
					isProductInCart=true;
				}
			}
			if(!isProductInCart) {
				prd.addDetailProducts(productsDetail);
				
			}

		}
	}

}
