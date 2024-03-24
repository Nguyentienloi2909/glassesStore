package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SanPham;
import model.SanPham;
import model.TaiKhoan;
import repository.GioHang_SanPhamBO;
import repository.SanPhamBO;


/**
 * Servlet implementation class CartServlet
 */
@WebServlet(name = "CartServlet", urlPatterns = { "/cart" })
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		GioHang_SanPhamBO prd = new GioHang_SanPhamBO();
		SanPhamBO spBO= new SanPhamBO();
		String eSoLuong = request.getParameter("soLuongKhongDu");
		TaiKhoan user = (TaiKhoan)request.getSession().getAttribute("user");
		if(user !=null) {
			ArrayList<SanPham> listPr = spBO.getListProducts();
			ArrayList<SanPham> listCart = prd.getSanPhamTrongGioHang(user.getId());
			request.setAttribute("eSoLuong", eSoLuong);
			request.setAttribute("listCart", listCart);
			request.setAttribute("listPr", listPr);
		}
		
		request.getRequestDispatcher("./views/GioHang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
}
