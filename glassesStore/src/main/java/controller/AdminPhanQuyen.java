package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;
import repository.UsersBO;

/**
 * Servlet implementation class AdminPhanQuyen
 */
@WebServlet("/AdminPhanQuyen")
public class AdminPhanQuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPhanQuyen() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		Users admin = (Users) request.getSession().getAttribute("admin");
		UsersBO us = new UsersBO();
		Users user = us.getUsersById(id);
		if (admin!= null) {
			if(user.getPhanQuyen().equals("0")) {
				us.editPhanQuyenAccount(id);
			}else {
				us.editDeletePhanQuyenAccount(id);
			}
			
			ArrayList<Users> listUser = us.getListUsers();
			request.setAttribute("listUser", listUser);
		}
		
		
		request.getRequestDispatcher("./admin/viewsAdmin/managerUser.jsp").forward(request, response);
	}

}
