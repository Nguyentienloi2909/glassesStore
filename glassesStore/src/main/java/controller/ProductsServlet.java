package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GioHang_SanPham;
import model.SanPham;
import model.SanPham;
import model.TaiKhoan;
import repository.LoaiSanPhamBO;
import repository.GioHang_SanPhamBO;
import repository.SanPhamBO;

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
		SanPhamBO p = new SanPhamBO();
		LoaiSanPhamBO c = new LoaiSanPhamBO();
		
		String idLoaiSp = request.getParameter("id_category"); // mĂ£ loáº¡i sáº£npháº©m
		String search = request.getParameter("search"); // tĂ¬m kiáº¿m theo tĂªn ngÆ°á»�i dĂ¹ng nháº­p 
		String key = request.getParameter("key");
		 
		ArrayList<SanPham> lstP=null;
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
				if(pro.getId_SanPham()== id_product) {
					pro.setSoLuong(pro.getSoLuong()+1);
					prd.editSoLuong(GioHang_SanPham);
					isProductInCart=true;
				}
			}
			if(!isProductInCart) {
				prd.addGioHangSanPham(GioHang_SanPham);
				
			}

		}
	}

}
