package net;

public class buyers {
	private String Sno;
	private String Pwd;
	public buyers(String Sno, String Pwd) {
		super();
		this.Sno = Sno;
		this.Pwd = Pwd;
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	
}
