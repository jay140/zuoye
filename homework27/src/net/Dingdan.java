package net;

public class Dingdan {
	private String mei;
	private String yonghua;
	private String shangpin;
	private String zhuangtai;
	public Dingdan(String mei,String yonghua, String shangpin, String zhuangtai) {
		super();
		this.mei=mei;
		this.yonghua = yonghua;
		this.shangpin = shangpin;
		this.zhuangtai = zhuangtai;
	}
	public String getYonghua() {
		return yonghua;
	}
	public void setYonghua(String yonghua) {
		this.yonghua = yonghua;
	}
	public String getShangpin() {
		return shangpin;
	}
	public void setShangpin(String shangpin) {
		this.shangpin = shangpin;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	
	public String getMei() {
		return mei;
	}
	public void setMei(String mei) {
		this.mei = mei;
	}
	@Override
	public String toString() {
		return mei+","+yonghua + "," + shangpin + "," + zhuangtai;
	}
	
	

}
