package net;

public class gouwux {
	private String gu;
	private String chan;
	private String zhuang;
	public gouwux(String gu, String chan, String zhuang) {
		super();
		this.gu = gu;
		this.chan = chan;
		this.zhuang = zhuang;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getChan() {
		return chan;
	}
	public void setChan(String chan) {
		this.chan = chan;
	}
	public String getZhuang() {
		return zhuang;
	}
	public void setZhuang(String zhuang) {
		this.zhuang = zhuang;
	}
	@Override
	public String toString() {
		return  gu + "," + chan + "," + zhuang;
	}
	
}
