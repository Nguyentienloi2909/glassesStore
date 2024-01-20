package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bills;
import model.Users;
import repository.BillsBO;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
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
		int tong = Integer.parseInt(request.getParameter("tong"));
		Users user = (Users) request.getSession().getAttribute("user");
		if (tong > 0 && user != null) {
			request.setAttribute("tong", tong);
			request.getRequestDispatcher("./views/CheckOut.jsp").forward(request, response);
		}
		request.getRequestDispatcher("./views/GioHang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String ghichu = request.getParameter("ghichu");
		String sodienthoai = request.getParameter("sdt");
		String diachi = request.getParameter("diachi");
		Users user = (Users) request.getSession().getAttribute("user");
		if(user != null) {
			BillsBO billBO = new BillsBO();
			Bills bill = new Bills(ghichu, diachi, sodienthoai);
			billBO.addBill(bill);
		}
		
		request.getRequestDispatcher("./home").forward(request, response);
	}

}
