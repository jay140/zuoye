package net;

public class product {
	private String pno;
	private String pname;
	private String psize;
	private String pprize;
	
	public product(String pno,String pname,String psize,String pprize) {
		this.pno = pno;
		this.pname = pname;
		this.psize = psize;
		this.pprize = pprize;
		
}


	public String getPno() {
		return pno;
	}


	public void setPno(String pno) {
		this.pno = pno;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPsize() {
		return psize;
	}


	public void setPsize(String psize) {
		this.psize = psize;
	}


	public String getPprize() {
		return pprize;
	}


	public void setPprize(String pprize) {
		this.pprize = pprize;
	}


	@Override
	public String toString() {
		return  pno + "," + pname + "," + psize + "," + pprize;
	}
	
	


}
