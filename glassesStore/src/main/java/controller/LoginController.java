package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;
import repository.UsersBO;

/**
 * Servlet implementation class UsersLoginServlet
 */
@WebServlet("/login") 
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String user_name = request.getParameter("user-name");
		String user_pass = request.getParameter("user-password");
		UsersBO u = new UsersBO();
		HttpSession session = request.getSession();
		Users us = u.checkLogin(user_name, user_pass);
		if (us != null) {
			session.setAttribute("user", us);
			// phân quyền để chuyển trang
			if (us.getPhanQuyen().equals("0")) {
				response.sendRedirect("./home");
			}
			if (us.getPhanQuyen().equals("1")) {
				session.setAttribute("admin", us);
				response.sendRedirect("adminproduct");
			}
		} else {
			String error = "Tài khoản hoặc mật khẩu không đúng,vui lòng kiểm tra lại.";
			request.setAttribute("mess", error);
			request.getRequestDispatcher("./views/DangNhap.jsp").forward(request, response);
		}
		
	}

}
