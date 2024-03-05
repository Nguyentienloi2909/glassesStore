package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Email;
import model.TaiKhoan;
import repository.TaiKhoanBO;

/**
 * Servlet implementation class UsersRegisterServlet
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
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
		TaiKhoanBO s = new TaiKhoanBO();
		
		String tenTaiKhoan = request.getParameter("tenTaiKhoan");
		String email = request.getParameter("user-email");
		String password = request.getParameter("password");
		String passwordRepeat = request.getParameter("passwordRepeat");
		
		
		
		String messUserName ="";
		String messEmail ="";
		String messPasswordRepeat ="";
		TaiKhoan user = new TaiKhoan(tenTaiKhoan,email, password, "0", "", "", "" );
		HttpSession session = request.getSession();
		if(s.checkAccountTenTaiKhoan(tenTaiKhoan)) {
			messUserName += "tên đăng nhập đã tồn tại";
			
		}
		if(s.checkAccountEmail(email)) {
			messEmail += "email đã tồn tại";
			
		}
		if(!password.equals(passwordRepeat)) {
			messPasswordRepeat += "Mật khẩu nhập lại không đúng";	
		}
		
		
		
		if (messUserName.length() > 0 || messPasswordRepeat.length()>0 || messEmail.length() > 0) {
			request.setAttribute("tenTaiKhoan", tenTaiKhoan);
			request.setAttribute("email", email);
			request.setAttribute("messUserName", messUserName);
			request.setAttribute("messEmail", messEmail);
			request.setAttribute("messPasswordRepeat", messPasswordRepeat);
			request.getRequestDispatcher("./views/DangKy.jsp").forward(request, response);
		}else {
			String maOTP = Email.generateRandomString(6);
			Email.sendEmail(email, "MÃ OTP CỦA BẠN", maOTP);
			request.setAttribute("chuoiTest", maOTP);
			request.setAttribute("tenTaiKhoan", tenTaiKhoan);
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			
			request.getRequestDispatcher("./views/formCheckOTP.jsp").forward(request, response);
		}		
	}
}
