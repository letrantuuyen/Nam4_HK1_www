package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.DanhMuc;
import model.TinTuc;
import util.DanhMucUtil;
import util.TinTucUtil;

/**
 * Servlet implementation class TinTucServlet
 */
@WebServlet("/TinTucServlet")
public class TinTucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name ="jdbc/DeOn2")
	private DataSource dataSource;
	private DanhMucUtil danhMucUtil;
	private TinTucUtil tintucUntil;
	public void init() throws ServletException {
		super.init();
		try {
			danhMucUtil = new DanhMucUtil(dataSource);
			tintucUntil = new TinTucUtil(dataSource);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
/*
	public void getAllDanhMuc(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		List<DanhMuc> dms = danhMucUtil.getListDanhMuc();
		request.setAttribute("dmList",dms);
		RequestDispatcher dispatcher = request.getRequestDispatcher("danhmuc.jsp");
		dispatcher.forward(request, response);
	}
	*/
	
	/*
	public void getAllTinTuc(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<TinTuc> tts = tintucUntil.getListTinTuc();
		request.setAttribute("ttList",tts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("danhmuc.jsp");
		dispatcher.forward(request, response);
	}

	*/
	
	  public void mainIndex(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException { 
	  RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
	  dispatcher.forward(request, response); 
	  }
	  
	  public void getTTByDM(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		  List<TinTuc> tts = tintucUntil.getTinTucByDM();
			request.setAttribute("ttList",tts);
			RequestDispatcher dispatcher = request.getRequestDispatcher("danhmuc.jsp");
			dispatcher.forward(request, response);
	  }
	  
	  public void addTinTuc(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		    // Lấy giá trị từ request
		    String maTinParam = request.getParameter("maTin");
		    String maDMParam = request.getParameter("maDM");
		    String tieuDe = request.getParameter("tieuDe");
		    String noiDungTT = request.getParameter("noiDungTT");
		    String lienKet = request.getParameter("lienKet");

		    try {
		        if (maTinParam != null && maDMParam != null) {
		            int maTin = Integer.parseInt(maTinParam);
		            int maDM = Integer.parseInt(maDMParam);

		            // Kiểm tra xem biến danhmuc có được khai báo và sử dụng đúng cách không
		            DanhMuc danhmuc = new DanhMuc(maDM);

		            // Tiếp tục xử lý logic của bạn với maTin và danhmuc
		            TinTuc tintuc = new TinTuc(maTin, tieuDe, noiDungTT, lienKet, danhmuc);
		            tintucUntil.addTT(tintuc);

		            // Thực hiện hành động sau khi thêm tin tức thành công, ví dụ chuyển hướng hoặc thông báo cho người dùng.
		        } else {
		            // Xử lý trường hợp maTinParam hoặc maDMParam là null hoặc không hợp lệ
		            // Ví dụ: thông báo lỗi cho người dùng hoặc ghi log.
		        //	throw new IllegalArgumentException("Unexpected value: "+ maTinParam + maDMParam);
		        }
		    } catch (NumberFormatException e) {
		        // Xử lý ngoại lệ khi chuỗi không thể chuyển đổi thành số nguyên
		        e.printStackTrace(); // Ghi log để ghi lại lỗi
		        // Ví dụ: thông báo lỗi cho người dùng hoặc ghi log.
		    }
		    List<DanhMuc> danhMucList = danhMucUtil.getListDanhMuc();
     	   request.setAttribute("danhMucList", danhMucList);
     	   RequestDispatcher addTTDispatcher = request.getRequestDispatcher("addTT.jsp");
			 addTTDispatcher.forward(request, response);
			
		    //  getAllTinTuc(request, response);
		}


	  /*
	  public void addDM(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		  String maDM = request.getParameter("maDM");
		  String tenDanhMuc = request.getParameter("tenDM");
		  String nguoiQuanLi = request.getParameter("nguoiQuanLi");
		  String ghiChu = request.getParameter("ghiChu");
		  DanhMuc danhmuc = new DanhMuc(maDM, tenDanhMuc, nguoiQuanLi, ghiChu);
		  danhMucUtil.addDM(danhmuc);
		  getAllDanhMuc(request, response);
	  }
	  */
	  
	   public TinTucServlet() {
		// TODO Auto-generated constructor stub
	}
	   public void deleteTT(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		   String maTT = request.getParameter("maTT");
		   int maTin = Integer.parseInt(maTT);
		   tintucUntil.deleteTT(maTin);
		   
	//	   getAllTinTuc(request, response);
		   
		   
	   }
	  
	 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//getAllDanhMuc(request, response);
		try {
			String command = request.getParameter("command");
			if(command == null) {
			//	command = "GETLISTDM";
				command = "MainIndex";
			
			}
			switch (command) {
			//case "GETLISTDM": 
			//	getAllDanhMuc(request, response);
			//	break;
			case "MainIndex":
				mainIndex(request, response);
				break;
			case "GetTTByDM":
				getTTByDM(request, response);
				break;
			case "AddTT":
			
			//	 addDM(request, response);
				 addTinTuc(request, response);
				break;
			case "DeleteTT":
				deleteTT(request, response);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + command);
			}
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
