	package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ChiTietHoaDon;
import model.DonDatHang;
import model.GioHang_SanPham;
import model.HoaDon;
import model.SanPham;
import model.TaiKhoan;
import repository.ChiTietHoaDonBO;
import repository.DonDatHangBO;
import repository.GioHang_SanPhamBO;
import repository.HoaDonBO;
import repository.SanPhamBO;
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
		}else if (matcherDiaChi.matches()) {
			errorDiaChi = "Địa chỉ không hợp lệ (bao gồm số nhà đường và địa chỉ)";
		}
        
        // kiểm tra lỗi của số điện thoại
        String errorPhone = "";
        String phoneRegex = "^0\\d{9,10}$";
        Pattern patternPhone = Pattern.compile(phoneRegex);
        Matcher matcherPhone = patternPhone.matcher(sodienthoai);
        if(sodienthoai.equals("")) {
        	errorPhone = "vui lòng nhập số điện thoại";
		}else if(!matcherPhone.matches()) {
			errorPhone = "Không đúng định dạng số điện thoại";
		}
        
        TaiKhoan user = (TaiKhoan) request.getSession().getAttribute("user");
		GioHang_SanPhamBO ghSpBO = new GioHang_SanPhamBO();
		SanPhamBO spBO = new SanPhamBO();
		ArrayList<SanPham> listSp = spBO.getListProducts();
		ArrayList<SanPham> listCart = ghSpBO.getSanPhamTrongGioHang(user.getId());
		
		// kiểm tra số lương sản phẩm có trong giỏ hàng và số lượng tồn kho
		String soLuongKhongDu = "";
		for (SanPham sp : listSp) {
			for (SanPham spCart : listCart) {
				if( sp.getId() == spCart.getId() && spCart.getSoLuong() > sp.getSoLuong()) {
					soLuongKhongDu = "số lượng sản phẩm " + spCart.getTenSanPham()+ " không đủ";
					
				}
			}
		}
		
        
        String url;
		
		
		if (soLuongKhongDu.length() > 0 && user != null) { 
			url = "./views/GioHang.jsp";
			request.setAttribute("eSoLuong", soLuongKhongDu);
			request.setAttribute("listCart", listCart);
			request.setAttribute("listPr", listSp);
		}else if ((errorHoTen.length() > 0 || errorDiaChi.length()>0 || errorPhone.length() > 0
        		|| errorGhiChu.length()>0 || errorPTTT.length() >0) && user !=null) {
        	request.setAttribute("errorHoTen", errorHoTen);
        	request.setAttribute("errorGhiChu", errorGhiChu);
        	request.setAttribute("errorDiaChi", errorDiaChi);
        	request.setAttribute("errorPhone", errorPhone);
        	request.setAttribute("errorPTTT", errorPTTT);
        	request.setAttribute("diaChi", diachi);
			request.setAttribute("soDienThoai", sodienthoai);
			request.setAttribute("tenTaiKhoan", user.getTenTaiKhoan());
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
			long idBill =  billBO.addBill(bill);
			
			
			// thêm chi tiết hóa đơn
			ChiTietHoaDonBO cthdBO = new ChiTietHoaDonBO();
			for(SanPham sp : listCart) {
				ChiTietHoaDon cthd = new ChiTietHoaDon(idBill,sp.getId(), sp.getSoLuong());
				cthdBO.addChiTietHoaDon(cthd);
			}
			
			
			// xóa giỏ hàng đã thanh toán
			GioHang_SanPham gioHang_SanPham = new GioHang_SanPham(user.getId());
			ghSpBO.deleteGioHangSanPham(gioHang_SanPham);
			url = "./home";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
