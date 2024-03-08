package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DonDatHang;
import model.GioHang_SanPham;
import model.HoaDon;
import model.TaiKhoan;
import repository.DonDatHangBO;
import repository.GioHang_SanPhamBO;
import repository.HoaDonBO;
import repository.TaiKhoanBO;

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
		
		double tong = Double.parseDouble(request.getParameter("tong").trim());
		int id_voucher = Integer.parseInt(request.getParameter("id_voucher").trim());
		
		TaiKhoan user = (TaiKhoan) request.getSession().getAttribute("user");
		String url ="";
		if (tong > 0 && user != null) {
			request.setAttribute("tenTaiKhoan", user.getTenTaiKhoan());
			request.setAttribute("diaChi", user.getDiaChi());
			request.setAttribute("soDienThoai", user.getSoDienThoai());
			request.setAttribute("tong", tong);
			request.setAttribute("id_voucher", id_voucher);
			url = "./views/CheckOut.jsp";
		}else {
			url = "./views/GioHang.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
	     
		//getParamater
		String hoTen = request.getParameter("hoTen");
		String phuongTTT = request.getParameter("phuongThucThanhToan");
		String ghichu = request.getParameter("ghichu");
		String sodienthoai = request.getParameter("soDienThoai");
		String diachi = request.getParameter("diaChi");
		double tongTien =Double.parseDouble(request.getParameter("tong").trim());
		int id_voucher = Integer.parseInt(request.getParameter("id_voucher").trim());
		
		
		// kiểm tra phương thức thanh toán
		String errorPTTT = "";
		if (phuongTTT.equals("--")) {
			errorPTTT = "Vui lòng chọn phương thức thanh toán";
		}
		
		// kiểm tra lỗi ghi chú
		String errorGhiChu = "";
		if (ghichu.length() > 520) {
			errorGhiChu = "nội dung không được quá 520 ký tự";
		}
		
		// kiểm tra lỗi của họ tên
		String errorHoTen ="";
		String regexHoTen = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?0-9]+.*";
        Pattern patternHoTen = Pattern.compile(regexHoTen);
		Matcher matcherHoTen = patternHoTen.matcher(hoTen);
		if(hoTen.equals("")) {
			errorHoTen = "vui lòng nhập họ tên người mua";
		}else if(hoTen.length() >50) {
			errorHoTen = "Họ tên không được quá 50 ký tự";
		}else if (matcherHoTen.find()) {
			errorHoTen = "Tên của bạn chứa các ký tự đặc biệt hoặc số";
		}
		
		// kiểm tra lỗi địa chỉ 
		String errorDiaChi = "";
		String regexDiaChi = "^[0-9]+\\s+[a-zA-Z0-9\\s]+,\\s*[a-zA-Z,\\s]+";
        Pattern patternDiaChi = Pattern.compile(regexDiaChi);
        Matcher matcherDiaChi = patternDiaChi.matcher(diachi);
        if(diachi.equals("")) {
        	errorDiaChi = "Địa chỉ không được để trống";
		}
        else if (matcherDiaChi.matches()) {
			errorDiaChi = "Địa chỉ không hợp lệ (bao gồm số nhà đường và địa chỉ)";
		}
        
        // kiểm tra lỗi của số điện thoại
        String errorPhone = "";
        String phoneRegex = "^0\\d{9,10}$";
        Pattern patternPhone = Pattern.compile(phoneRegex);
        Matcher matcherPhone = patternPhone.matcher(sodienthoai);
        if(sodienthoai.equals("")) {
        	errorPhone = "vui lòng nhập số điện thoại";
		}
        else if(!matcherPhone.matches()) {
			errorPhone = "Không đúng định dạng số điện thoại";
		}
        
        
        String url;
		TaiKhoan user = (TaiKhoan) request.getSession().getAttribute("user");
        if ((errorHoTen.length() > 0 || errorDiaChi.length()>0 || errorPhone.length() > 0
        		|| errorGhiChu.length()>0 || errorPTTT.length() >0) && user !=null) {
        	request.setAttribute("errorHoTen", errorHoTen);
        	request.setAttribute("errorGhiChu", errorGhiChu);
        	request.setAttribute("errorDiaChi", errorDiaChi);
        	request.setAttribute("errorPhone", errorPhone);
        	request.setAttribute("errorPTTT", errorPTTT);
        	request.setAttribute("diaChi", diachi);
			request.setAttribute("soDienThoai", sodienthoai);
			request.setAttribute("hoTen", hoTen);
			request.setAttribute("tong", tongTien);
			request.setAttribute("id_voucher", id_voucher);
        	url = "./views/CheckOut.jsp";
        }else {
        	// update diaChi, soDienThoai cho tài khoản
        	TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
        	user.setDiaChi(diachi);
        	user.setSoDienThoai(sodienthoai);
        	taiKhoanBO.UpdateDiaChiAnhdSDT(user);
        	
        	// thêm đơn đặt hàng
        	DonDatHangBO donDatHangBO = new DonDatHangBO();
        	DonDatHang donDatHang = new DonDatHang();
        	donDatHang.setId_taiKhoan(user.getId());
        	donDatHang.setTongTienThanhToan(tongTien);
        	long id_donDatHang = 0;
        	if (id_voucher != 0) {
        		donDatHang.setId_voucher(id_voucher);
        		id_donDatHang = donDatHangBO.addDonHang(donDatHang);
        	}
        	
        	id_donDatHang = donDatHangBO.addDonHangKhongVouCher(donDatHang);
        	
        	
        	// thêm hóa đơn
			HoaDonBO billBO = new HoaDonBO();
			HoaDon bill = new HoaDon(tongTien,id_donDatHang, phuongTTT);
			billBO.addBill(bill);
			
			// xóa giỏ hàng đã thanh toán
			GioHang_SanPhamBO ghSpBO = new GioHang_SanPhamBO();
			GioHang_SanPham gioHang_SanPham = new GioHang_SanPham(user.getId());
			ghSpBO.deleteGioHangSanPham(gioHang_SanPham);
			url = "./home";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
