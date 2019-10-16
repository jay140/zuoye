package net;

public class people {
	private String name;
	private String jobname;
	private int slarynum;
	public people(String name, String jobname, int slarynum) {
		super();
		this.name = name;
		this.jobname = jobname;
		this.slarynum = slarynum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public int getSlarynum() {
		return slarynum;
	}
	public void setSlarynum(int slarynum) {
		this.slarynum = slarynum;
	}
}
