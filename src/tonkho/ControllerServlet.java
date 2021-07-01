package tonkho;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tonkho.TonKho;
import tonkho.TonKhoConnect;

import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(urlPatterns= {"/list","/insert","/update","/"})
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TonKhoConnect bd;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		String  url = "jdbc:mysql://localhost:3306/qlkho";
		String userName="root";
		String pass="";
		bd=new TonKhoConnect(url,userName,pass);
	}
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getServletPath();
		System.out.println(action);
	try {
		switch (action) {
		case "/insert":	
			insertTk(request,response);
			break;
		case "/new":
			newForm(request, response);
			break;
		case "/update":
			uppdateBook(request,response);
			break;
		case "/edit":
			editForm(request,response);
			break;
		case "/delete":
			deleteTK(request,response);
			break;
		default:
			System.out.println("default");
			listShow(request, response);
			break;
		}
	
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	System.out.println("het");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("TonKhoForm.jsp");
		dispatcher.forward(request, response);
	}
	private void editForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException, SQLException{
		int id_book=Integer.parseInt(request.getParameter("id"));
		// lấy dl bằng id
		TonKho tk=bd.getTK(id_book);
		//truy�?n dl sang form
		request.setAttribute("tk",tk);
		// chuyển trang
		RequestDispatcher dispatcher=request.getRequestDispatcher("TonKhoForm.jsp");
		//thực hiện
		dispatcher.forward(request, response);		
	}
	private void uppdateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException{
		int id=Integer.parseInt(request.getParameter("id"));
		int idch=Integer.parseInt(request.getParameter("idCH"));
		int idmh=Integer.parseInt(request.getParameter("idMH"));
		int sl=Integer.parseInt(request.getParameter("sl"));
		TonKho book=new TonKho(id,idch,idmh,sl);
		bd.updateTK(book);
		response.sendRedirect("list");
		
	}
	private void insertTk(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int idch=Integer.parseInt(request.getParameter("idCH"));
		int idmh=Integer.parseInt(request.getParameter("idMH"));
		int sl=Integer.parseInt(request.getParameter("sl"));
		TonKho tk=new TonKho(idch,idmh,sl);
		bd.insertTonKho(tk);
		tk.print();
		//response.sendRedirect("list");
	}
	private void deleteTK(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int id=Integer.parseInt(request.getParameter("id"));		
		TonKho tk =new TonKho(id);
		bd.deleteTK(tk);
		response.sendRedirect("list");
	}
	private void listShow(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
		List<TonKho> listTK = bd.getAllTK();
		request.setAttribute("listTK",listTK);
		//chuyển trang
	RequestDispatcher	dispatcher= request.getRequestDispatcher("ListTonKho.jsp");
	dispatcher.forward(request, response);
		for(TonKho tk : listTK) {
			tk.print();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
