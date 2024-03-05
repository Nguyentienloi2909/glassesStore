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
import repository.SanPhamBO;

/**
 * Servlet implementation class AdminEditProduct
 */
@WebServlet("/AdminEditProduct")
public class AdminEditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		SanPhamBO prdBO = new SanPhamBO();
		SanPham pr = prdBO.getProductsByID(id);
		request.setAttribute("id", pr.getId());
		request.getRequestDispatcher("./admin/incAdmin/editProductAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String tenSp = request.getParameter("tensanpham");
		String mota = request.getParameter("mota");
		double giaGoc = Double.parseDouble(request.getParameter("giagoc"));
		int khuyenmai = Integer.parseInt(request.getParameter("khuyenmai"));
		String tenanh = request.getParameter("anhchinh");
		int soLuong = Integer.parseInt(request.getParameter("soluong"));
		int loaiSp =  Integer.parseInt(request.getParameter("id_loaisp"));
		int id_nhaCungCap =  Integer.parseInt(request.getParameter("id_nhaCungCap"));
		
		SanPhamBO prdBO = new SanPhamBO();
		SanPham pr = new SanPham(id, tenSp, mota, giaGoc, tenanh,soLuong, loaiSp,  id_nhaCungCap, khuyenmai );
		TaiKhoan admin = (TaiKhoan) request.getSession().getAttribute("admin");
		if (admin != null) {
			prdBO.editProduct(pr) ;
			ArrayList<SanPham> listProduct = prdBO.getListProducts();
			request.setAttribute("listProducts", listProduct);
		}
		request.getRequestDispatcher("./admin/viewsAdmin/managerProducts.jsp").forward(request, response);
	}

}
