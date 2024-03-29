package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SanPham;
import model.TaiKhoan;
import model.Voucher;
import repository.GioHang_SanPhamBO;
import repository.VoucherBO;

/**
 * Servlet implementation class CheckVoucher
 */
@WebServlet("/CheckVoucher")
public class CheckVoucher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckVoucher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String voucher  = request.getParameter("voucher");
		TaiKhoan user = (TaiKhoan) request.getSession().getAttribute("user");
		VoucherBO voucherBO = new VoucherBO();
		GioHang_SanPhamBO prd = new GioHang_SanPhamBO();
		
	
		if (user != null) {	
			Voucher vcher = voucherBO.getVoucherByTenvoucher(voucher);
			if (vcher != null) {
				request.setAttribute("vcher", vcher);
				
			}else {
				request.setAttribute("messVcher", "mã voucher không đúng");
			}
			
			ArrayList<SanPham> listPr = prd.getSanPhamTrongGioHang(user.getId());
			request.setAttribute("listCart", listPr);	
		}
		request.getRequestDispatcher("./views/GioHang.jsp").forward(request, response);	
	}

}
