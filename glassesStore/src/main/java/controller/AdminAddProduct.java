package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Products;
import model.Users;
import repository.ProductsBO;

/**
 * Servlet implementation class AdminAddProduct
 */
@WebServlet("/AdminAddProduct")
public class AdminAddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddProduct() {
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

		String tenSp = request.getParameter("tensanpham");
		String mota = request.getParameter("mota");
		double giaGoc = Double.parseDouble(request.getParameter("giagoc"));
		int khuyenmai = Integer.parseInt(request.getParameter("khuyenmai"));
		String tenanh = request.getParameter("anhchinh");
		int soLuong = Integer.parseInt(request.getParameter("soluong"));
		int loaiSp =  Integer.parseInt(request.getParameter("id_loaisp"));
		
		ProductsBO prdBO = new ProductsBO();
		Products pr = new Products(loaiSp, tenSp, mota, tenanh, giaGoc, khuyenmai,  1, soLuong);
		Users admin = (Users) request.getSession().getAttribute("admin");
		if (admin != null) { 
			prdBO.addProducts(pr); 
		}
		ArrayList<Products> listProduct = prdBO.getListProducts();
		request.setAttribute("listProducts", listProduct);
		request.getRequestDispatcher("./admin/viewsAdmin/managerProducts.jsp").forward(request, response);
		
	}

}
