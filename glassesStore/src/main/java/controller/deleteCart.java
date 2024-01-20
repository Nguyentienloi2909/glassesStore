package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Products;
import model.ProductsDetail;
import model.Users;
import repository.ProductDetailBO;
import repository.ProductsBO;

/**
 * Servlet implementation class updateCart
 */
@WebServlet("/deleteCart")
public class deleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCart() {
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
		
		Users user = (Users) request.getSession().getAttribute("user");
		int id = Integer.parseInt(request.getParameter("id"));
		if (user != null) {
			ProductDetailBO prdBO = new ProductDetailBO();
			ProductsDetail prDetail = new ProductsDetail( id,user.getId(), 1);
			prdBO.deleteDetailProduct(prDetail);
			ArrayList<Products> listPr = prdBO.getProductDetailByIdUser(user.getId());
			request.setAttribute("listCart", listPr);
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
