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
import repository.GioHang_SanPhamBO;
import repository.SanPhamBO;

/**
 * Servlet implementation class updateCart
 */
@WebServlet("/deleteOrUpdateCart")
public class deleteOrUpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteOrUpdateCart() {
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
		
		TaiKhoan user = (TaiKhoan) request.getSession().getAttribute("user");
		int id = Integer.parseInt(request.getParameter("id_product"));
		String SRequest = request.getParameter("request");
		
		
		
		if (user != null) {
			SanPhamBO spBO = new SanPhamBO();
			GioHang_SanPhamBO prdBO = new GioHang_SanPhamBO();
			GioHang_SanPham prDetail = new GioHang_SanPham( id, user.getId(), 0, 0);
			if (SRequest.equals("update")) {
				int soLuong = Integer.parseInt(request.getParameter("quantity"));
				prDetail.setSoLuong(soLuong);
				prdBO.editSoLuong(prDetail);
			}else if(SRequest.equals("delete")) {
				prdBO.deleteSanPhamTrongGioHang(prDetail);
			}	
			ArrayList<SanPham> listCart = prdBO.getSanPhamTrongGioHang(user.getId());
			ArrayList<SanPham> listPr = spBO.getListProducts();
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
