package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import model.KhuyenMai;
import model.LoaiSanPham;
import model.NhaCungCap;
import model.SanPham;
import model.TaiKhoan;
import repository.KhuyenMaiBO;
import repository.LoaiSanPhamBO;
import repository.NhaCungCapBO;
import repository.SanPhamBO;

/**
 * Servlet implementation class AdminAddProduct
 */
@MultipartConfig
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
		LoaiSanPhamBO lspBO = new LoaiSanPhamBO();
		NhaCungCapBO nccBO = new NhaCungCapBO();
		ArrayList<LoaiSanPham> listLSP = lspBO.getListCategory();
		ArrayList<NhaCungCap> listNCC = nccBO.getListCategory();
		request.setAttribute("listLSP", listLSP);
		request.setAttribute("listNCC", listNCC);
		request.getRequestDispatcher("./admin/incAdmin/addProductAdmin.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		SanPhamBO prdBO = new SanPhamBO();
		LoaiSanPhamBO lspBO = new LoaiSanPhamBO();
		NhaCungCapBO nccBO = new NhaCungCapBO();
		KhuyenMaiBO kmBO = new KhuyenMaiBO();
		
		String tenSp = request.getParameter("tensanpham");
		String mota = request.getParameter("mota");
		String giaGoc = request.getParameter("giagoc");
		String khuyenmai = request.getParameter("khuyenmai");
		String soLuong = request.getParameter("soluong");
		String loaiSp = request.getParameter("id_loaisp");
		String id_nhaCungCap = request.getParameter("id_nhaCungCap");
		
		
		TaiKhoan admin = (TaiKhoan) request.getSession().getAttribute("admin");
		
		// kiểm tra khuyến mãi
		String ekhuyenMai = "";
		if (!khuyenmai.matches("^[0-9]\\d*$")) {
			ekhuyenMai = "khuyến mãi của sản phẩm không hợp lệ";
		}else if(Integer.parseInt(khuyenmai) < 0 ||Integer.parseInt(khuyenmai) > 100 ) {
			ekhuyenMai = "khuyến mãi sản phẩm không được quá 0-100%";
		}
		
		
		// kiểm tra loại sản phẩm
		String eloaiSp= "";
		if (loaiSp.equals("--")) {
			eloaiSp = "Chưa chọn loại sản phẩm";
		}
		
		// kiểm tra nhà cung cấp
		String eNhaCC= "";
		if (id_nhaCungCap.equals("--")) {
			eNhaCC = "Chưa chọn nhà cung cấp";
		}
		
		
		// kiểm tra mô tả
		String eMoTa = "";
		if (mota.equals("")) {
			eMoTa = "Mô tả không được bỏ trống";
		}
		
		// kiểm tra  tên sản phẩm
		String eTensp = "";
		String regex = "[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tenSp);
		if (tenSp.equals("")) {
			eTensp = "Tên sản phẩm không được bỏ trống";
		}
		else if (tenSp.length() > 60) {
			eTensp = "Tên sản phẩm không được quá 60 ký tự";
		}else if(matcher.find()) {
			eTensp = "Tên sản phẩm không được có các ký tự đặc biệt";
		}
		
		
		
		// kiểm tra  giá
		String eGia = "";
		if (giaGoc.equals("")) {
			eGia =  "Giá được bỏ trống";
		}
		else if (!giaGoc.matches("-?\\d+(\\.\\d+)?")) {
			eGia = "Giá là một ký tự số";
		}else if(!giaGoc.matches("\\d+(\\.\\d+)?")) {
			eGia = "Giá là một số dương";
		}
		
		
		// kiểm tra số lượng
		String eSoLuong = "";
		if ( soLuong.equals("")) {
			eSoLuong = "Số lượng không được bỏ trống";
		}else if(!soLuong.matches("-?\\d+(\\.\\d+)?")){
			eSoLuong = "Số lượng không hợp lệ";
			
		}else if (!soLuong.matches("\\d+")) {
			eSoLuong = "Số lượng là một số nguyên dương";
		}
		
		
		// kiểm tra file ảnh
		String eTenAnh = "";
		
		Part filePart = request.getPart("file");
	    String fileName = filePart.getSubmittedFileName();
	    
	    if (fileName.length() > 0) {
	    	if (filePart.getSize() <= 5 * 1024 * 1024) {
		    	for (Part part : request.getParts()) {
		    		if(part == filePart) {
		    			filePart.write("C:/Users/DELL/git/repository/glassesStore/src/main/webapp/assets/image/" + fileName);
		    		}
		    	}
	    	}else {
	    		eTenAnh = "Vui lòng upload file ảnh có dung lượng nhỏ hơn 5MB.";
	    	}
	    	
		  
	    }else {
	    	eTenAnh = "vui lòng upload file image";
	    }
		
		String url = "";

		if (eTensp.length() > 0 || eGia.length() > 0 || eSoLuong.length() > 0 || eMoTa.length() >0 || 
				eloaiSp.length() > 0 || eNhaCC.length() > 0 || ekhuyenMai.length() > 0 || eTenAnh.length() > 0){	
			request.setAttribute("eTensp", eTensp);
			request.setAttribute("eGia", eGia);
			request.setAttribute("eSoLuong", eSoLuong);
			request.setAttribute("eTenAnh", eTenAnh);
			request.setAttribute("eMoTa", eMoTa);
			request.setAttribute("eloaiSp", eloaiSp);
			request.setAttribute("eNhaCC", eNhaCC);
			request.setAttribute("ekhuyenMai", ekhuyenMai);
			ArrayList<LoaiSanPham> listLSP = lspBO.getListCategory();
			ArrayList<NhaCungCap> listNCC = nccBO.getListCategory();
			request.setAttribute("listLSP", listLSP);
			request.setAttribute("listNCC", listNCC);
			url = "./admin/incAdmin/addProductAdmin.jsp";
		}
		
		else { 
			int loaiSp1 = lspBO.getIdLoaiSPByTenSP(loaiSp);
			int id_nhaCungCap1 = nccBO.getIdNhaCungCapByTenNCC(id_nhaCungCap);
			int khuyenMai = kmBO.getIdKhuyenMaiByMucKhuyenMai(Integer.parseInt(khuyenmai));
			if(khuyenMai == -1) {
				KhuyenMai km = new KhuyenMai(Integer.parseInt(khuyenmai));
				kmBO.addKhuyenMai(km);
				khuyenMai = kmBO.getIdKhuyenMaiByMucKhuyenMai(Integer.parseInt(khuyenmai));
			}
			SanPham pr = new SanPham(tenSp, mota, Double.parseDouble(giaGoc) ,fileName,Integer.parseInt(soLuong), loaiSp1 ,id_nhaCungCap1, khuyenMai);
			prdBO.addProducts(pr); 
			url = "./admin/viewsAdmin/managerProducts.jsp";
		}
		ArrayList<SanPham> listProduct = prdBO.getListProducts();
		request.setAttribute("listProducts", listProduct);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
