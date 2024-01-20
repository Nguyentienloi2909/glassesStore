package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductsDAO;
import model.Products;
import model.Users;
import repository.ProductsBO;

/**
 * Servlet implementation class Search
 */
@WebServlet(name = "Search", urlPatterns = {"/search"}) 
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		Users admin = (Users) request.getSession().getAttribute("admin");
		
		if (admin != null ) {
			String search = request.getParameter("search");
			ProductsBO prDAO = new ProductsBO();
			ArrayList<Products> listProduct = prDAO.getProductsByName(search);
			for(Products pr : listProduct) {
				System.out.println(pr.getId());
			}
			
			request.setAttribute("listProducts", listProduct);
			request.getRequestDispatcher("./admin/viewsAdmin/managerProducts.jsp").forward(request, response);
		}else {
			String search = request.getParameter("search");
			ProductsBO prDAO = new ProductsBO();
			ArrayList<Products> listProduct = prDAO.getProductsByName(search);
			request.setAttribute("lstProducts", listProduct);
		}

		request.getRequestDispatcher("./views/SanPham.jsp").forward(request, response);	
	
		
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
