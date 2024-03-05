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

import model.GioHang_SanPham;
import model.SanPham;
import model.SanPham;
import model.TaiKhoan;
import repository.LoaiSanPhamBO;
import repository.GioHang_SanPhamBO;
import repository.SanPhamBO;

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
		LoaiSanPhamBO category = new LoaiSanPhamBO();
		SanPhamBO sp = new SanPhamBO();
		ArrayList<SanPham> listProduct =  sp.getListProducts();
		
		request.setAttribute("lstProducts",listProduct);
		request.setAttribute("lstProductstop8", sp.getListProductsTop8());
		request.setAttribute("lstCategory", category.getListCategory());
		addProductToCart(request);
		request.getRequestDispatcher("./views/Home.jsp").forward(request, response);
	}
	
	public ArrayList<SanPham> list1(){
		SanPhamBO sp = new SanPhamBO();
		ArrayList<SanPham> listProduct =  sp.getListProducts();
		return listProduct;
	}
	
	
	public void addProductToCart(HttpServletRequest request) { 
		SanPhamBO sp = new SanPhamBO();
		GioHang_SanPhamBO prd = new GioHang_SanPhamBO();
		TaiKhoan user = (TaiKhoan)request.getSession().getAttribute("user");
		int id_product;
		try {
			id_product = Integer.parseInt(request.getParameter("id_product"));
		}catch (Exception e) {
			// TODO: handle exception
			id_product = 0;
		}
		
		
		
		if(id_product>0  && user!= null) {

			GioHang_SanPham GioHang_SanPham = new GioHang_SanPham(id_product, user.getId(), 1, 0);
			ArrayList<GioHang_SanPham> listCart = prd.getGioHangSanPham(GioHang_SanPham);
			boolean isProductInCart = false;
			
			
			for(GioHang_SanPham pro:listCart) {
				if(pro.getId_SanPham()==id_product) {
					pro.setSoLuong(pro.getSoLuong()+1);
					prd.editSoLuong(pro);
					isProductInCart=true;
				}
			}
			if(!isProductInCart) {
				prd.addGioHangSanPham(GioHang_SanPham);
				
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
