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
 * Servlet implementation class checkEmail
 */
@WebServlet("/checkEmail")
public class checkEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkEmail() {
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
		String tenTaiKhoan = request.getParameter("tenTaiKhoan");
		String hinhAnh = request.getParameter("hinhAnh");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String chuoiTest = request.getParameter("chuoiTest");
		String otp = request.getParameter("maOTP");
		
		TaiKhoan user = new TaiKhoan(tenTaiKhoan ,email, password, "0", hinhAnh, "", "" );
		HttpSession session = request.getSession();
		TaiKhoanBO s = new TaiKhoanBO();
		
		String url = "";
		if(!otp.equals(chuoiTest)) {
			
			request.setAttribute("tenTaiKhoan", tenTaiKhoan);
			request.setAttribute("hinhAnh", hinhAnh);
			request.setAttribute("email", email);
			request.setAttribute("alert", "Mã OTP sai vui lòng đăng ký lại");
			url = "./views/DangKy.jsp";
			
		}else {
			try {
				s.addAccount(user);
				TaiKhoan user3 = s.getUsersByName(user.getTenTaiKhoan());
				session.setAttribute("user", user3);
				url = "./home";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.getRequestDispatcher(url).include(request, response);

	}

}




