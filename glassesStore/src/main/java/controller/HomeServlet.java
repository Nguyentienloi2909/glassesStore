package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import model.Products;
import model.ProductsDetail;
import model.Users;
import repository.CategoryBO;
import repository.ProductDetailBO;
import repository.ProductsBO;

/**
 * Servlet implementation class Home
 */
 @WebServlet(name = "HomeServlet", urlPatterns = {"/home"}) 
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		CategoryBO category = new CategoryBO();
		ProductsBO sp = new ProductsBO();
		ArrayList<Products> listProduct =  sp.getListProducts();
		
		request.setAttribute("lstProducts",listProduct);
		request.setAttribute("lstProductstop8", sp.getListProductsTop8());
		request.setAttribute("lstCategory", category.getListCategory());
		addProductToCart(request);
		request.getRequestDispatcher("./views/Home.jsp").forward(request, response);
	}
	
	public ArrayList<Products> list1(){
		ProductsBO sp = new ProductsBO();
		ArrayList<Products> listProduct =  sp.getListProducts();
		return listProduct;
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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
