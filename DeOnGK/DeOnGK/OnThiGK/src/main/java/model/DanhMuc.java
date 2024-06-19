package model;

public class DanhMuc {
	private int maDM;
	private String tenDM;
	private String nguoiQuanLi;
	private String ghiChu;
	
	public DanhMuc() {
		// TODO Auto-generated constructor stub
	}
	
	

	public DanhMuc(int maDM) {
		super();
		this.maDM = maDM;
	}



	public DanhMuc(int maDM, String tenDM, String nguoiQuanLi, String ghiChu) {
		super();
		this.maDM = maDM;
		this.tenDM = tenDM;
		this.nguoiQuanLi = nguoiQuanLi;
		this.ghiChu = ghiChu;
	}

	public DanhMuc(String tenDM, String nguoiQuanLi, String ghiChu) {
		super();
		this.tenDM = tenDM;
		this.nguoiQuanLi = nguoiQuanLi;
		this.ghiChu = ghiChu;
	}

	public int getMaDM() {
		return maDM;
	}

	public void setMaDM(int maDM) {
		this.maDM = maDM;
	}

	public String getTenDM() {
		return tenDM;
	}

	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}

	public String getNguoiQuanLi() {
		return nguoiQuanLi;
	}

	public void setNguoiQuanLi(String nguoiQuanLi) {
		this.nguoiQuanLi = nguoiQuanLi;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}



	@Override
	public String toString() {
		return  " " + maDM ;
	}

	


}
