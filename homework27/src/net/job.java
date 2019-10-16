package net;

public class job {
	private String jobname;
	private int jobnum;
	public job(String jobname, int jobnum) {
		super();
		this.jobname = jobname;
		this.jobnum = jobnum;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public int getJobnum() {
		return jobnum;
	}
	public void setJobnum(int jobnum) {
		this.jobnum = jobnum;
	}
}
