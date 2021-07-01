package tonkho;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class TonKhoConnect {
	private String url;
	private String user;
	private String pass;
	Connection con = null;

	public TonKhoConnect(String _url, String _user, String _pass) {
		url = _url;
		user = _user;
		pass = _pass;
	}

	public void  openConnection() throws SQLException {
		if (con == null || con.isClosed()) {
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, pass);
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	}

	public void closeConnec() throws SQLException {
		if (con != null || !con.isClosed()) {
			con.close();
		}
	}

	public boolean insertTonKho(TonKho tk) throws SQLException {
		openConnection();
		String sql = "insert into tonkho (idCuaHang, idMatHang, soLuong) value (?, ?, ?)";
		PreparedStatement prstatement = con.prepareStatement(sql);
		prstatement.setInt(1, tk.getIdCH());
		prstatement.setInt(2, tk.getIdMatHang());
		prstatement.setInt(3, tk.getSoLuong());
		boolean insertrow = prstatement.executeUpdate() > 0;
		prstatement.close();
		con.close();
		return insertrow;
	}

	public List<TonKho> getAllTK() throws SQLException {
		String sql = "select * from tonkho";
		
		List list = new ArrayList<>();
		openConnection();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			int idCH = rs.getInt("idCuaHang");
			int idMH = rs.getInt("idMatHang");
			int sl = rs.getInt("soLuong");
			TonKho tk = new TonKho(id, idCH, idMH, sl);
			list.add(tk);
		}
		rs.close();
		statement.close();
		con.close();
		return list;
	}

	public boolean updateTK( TonKho tk) throws SQLException {
		String sql = "update tonkho set idCuaHang=?, idMatHang=?, soLuong=? where id=?";
		openConnection();
		PreparedStatement pr = con.prepareStatement(sql);
		pr.setInt(1, tk.getIdCH());
		pr.setInt(2, tk.getIdMatHang());
		pr.setInt(3, tk.getSoLuong());
		pr.setInt(4, tk.getId());
		boolean updateok = pr.executeUpdate() > 0;
		pr.close();
		con.close();
		return updateok;
	}

	public boolean deleteTK( TonKho tk) throws SQLException {
		String sql = "delete from tonkho where id=?";
		openConnection();
		PreparedStatement pr = con.prepareStatement(sql);
		pr.setInt(1, tk.getId());
		boolean deleteok = pr.execute();
		pr.close();
		con.close();
		return deleteok;

	}
	public  TonKho getTK(int id) throws SQLException {
		openConnection();
		TonKho tk=null;
		String sql="select * from tonkho where id=?";
		PreparedStatement pr =con.prepareStatement(sql);
		pr.setInt(1,id);
		ResultSet rs=pr.executeQuery();
		while(rs.next()) {
			int idCH=rs.getInt("idCuaHang");
			int idMH=rs.getInt("idMatHang");
			int sl=rs.getInt("soLuong");
			tk =new TonKho(id,idCH,idMH,sl);
		}
		System.out.println(tk.getId());
		return tk;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
