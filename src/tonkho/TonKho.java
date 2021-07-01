package tonkho;

public class TonKho {
	private int id;
	private int idCuaHang;
	private int idMatHang;
	private int soLuong;
	private String tenCH;
	private String tenMH;
	
	public TonKho(int id){		
		super();
		this.id = id;
	}

	public TonKho(int idCH, int idMH, int sl, String nameCH, String nameMH) {
		super();
		this.idCuaHang = idCH;
		this.idMatHang = idMH;
		this.soLuong = sl;
		this.tenCH = nameCH;
		this.tenMH = nameMH;
	}
	
	public TonKho(int id, int idCH, int idMH, int sl) {
		super();
		this.id = id;
		this.idCuaHang = idCH;
		this.idMatHang = idMH;
		this.soLuong = sl;
	}
	
	public TonKho(int idCH, int idMH, int sl) {
		super();
		this.idCuaHang = idCH;
		this.idMatHang = idMH;
		this.soLuong = sl;
	}
	
	public int getId() {
		return idCuaHang;
	}

	public void setId(int id) {
		this.idCuaHang = id;
	}

	public int getIdCH() {
		return idCuaHang;
	}

	public void setIdCH(int idCH) {
		this.idCuaHang = idCH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public String getTenCH() {
		return tenCH;
	}

	public void setMoTa(String name) {
		this.tenCH = name;
	}

	public int getSoLuong() {
		return soLuong;
	}
	
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public int getIdMatHang() {
		return idMatHang;
	}
	
	public void setIdMatHang(int idMatHang) {
		this.idMatHang = idMatHang;
	}
	
	public void print() {
		System.out.println("ID: "+ id);
		System.out.println("idCH: "+ idCuaHang);
		System.out.println("idMH: "+ idMatHang);
		System.out.println("sl: "+ soLuong);
		
	}
}
