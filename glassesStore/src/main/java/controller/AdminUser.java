package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SanPhamDAO;
import dao.TaiKhoanDAO;
import model.SanPham;
import model.TaiKhoan;
import repository.TaiKhoanBO;

/**
 * Servlet implementation class AdminUser
 */
@WebServlet("/adminUser")
public class AdminUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUser() {
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
		TaiKhoanBO prd = new TaiKhoanBO();
		TaiKhoan user = (TaiKhoan)request.getSession().getAttribute("admin");
		if (user != null) {
			ArrayList<TaiKhoan> listUser = prd.getListUsers();
			request.setAttribute("listUser", listUser);
			
		}
		request.getRequestDispatcher("./admin/viewsAdmin/managerUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
