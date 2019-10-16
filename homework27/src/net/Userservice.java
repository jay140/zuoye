package net;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Userservice {
	
	private userDao user=new userDao();
	public Userservice() {
		// TODO Auto-generated constructor stub
	}
	public void init() throws ClassNotFoundException, IOException, SQLException {
		user.init();
	}
	public String checkb(String n,String m) throws ClassNotFoundException, SQLException {
		ResultSet rs=user.chaxun("select * from buyer");
		String str="";
		while(rs.next())
			str+=rs.getString(1)+"he"+rs.getString(2)+"\n";
		return str;
		
	}
	public List<product> searchall() throws ClassNotFoundException, SQLException {
		ResultSet rs=user.chaxun("select * from product");
		List<product> products=new ArrayList<>();
		product pro1;
		while(rs.next()) {
			pro1=new product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			products.add(pro1);
		}
		
		return products;
	}
	
	public int shopp(String q,String w) throws ClassNotFoundException, SQLException {
		String r="未发货";
		int rs=user.updateData("insert into dingdan (gu,chan,zhuang)values('"+q+"','"+w+"','"+r+"')");
		return rs;
		
	}
	public List<product> searchsome(String f,String j,String p) throws ClassNotFoundException, SQLException {
		ResultSet rs=user.chaxun("select * from product");
		List<product> products=new ArrayList<>();
		product pro2;
		while(rs.next()) {
			if(rs.getString(2).contains(f)&&rs.getString(3).contains(j)&&rs.getString(4).contains(p)) {
				pro2=new product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				products.add(pro2);
			}
			
		}
		
		return products;
	}
	
	public List<gouwux> cha(String aa) throws ClassNotFoundException, SQLException {
		ResultSet rs=user.chaxun("select * from dingdan");
		List<gouwux> gou=new ArrayList<>();
		gouwux pro1;
		while(rs.next()) {
			if(rs.getString(1).equals(aa)) {
				pro1=new gouwux(rs.getString(1),rs.getString(2),rs.getString(3));
				gou.add(pro1);
			}
		
		}
		
		return gou;
	}
	
	public List<Dingdan> chad(String aa) throws ClassNotFoundException, SQLException {
		ResultSet rs=user.chaxun("select * from xiadan");
		List<Dingdan> go=new ArrayList<>();
		Dingdan pro1e;
		while(rs.next()) {
			if(rs.getString(2).equals(aa)) {
				pro1e=new Dingdan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				go.add(pro1e);
			}
		
		}
		
		return go;
	}
	
	public List<Dingdan> chadd() throws ClassNotFoundException, SQLException {
		ResultSet rs=user.chaxun("select * from xiadan");
		List<Dingdan> gou=new ArrayList<>();
		Dingdan pro1;
		while(rs.next()) {
			pro1=new Dingdan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			gou.add(pro1);
		
		}
		
		return gou;
	}
	public int xiadana(String ll,String pp) throws ClassNotFoundException, SQLException {
		String r="未发货";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");// HH:mm:ss

		Date date = new Date(System.currentTimeMillis());
		String str=simpleDateFormat.format(date);
		int rs=user.updateData("insert into xiadan (shi,yonghua,shangpin,zhuangtai)values('"+str+"','"+ll+"','"+pp+"','"+r+"')");
		return rs;
		
	}
	
	public int shan(String ll) throws ClassNotFoundException, SQLException {
		int rs=user.deleteDate("delete from dingdan where gu='"+ll+"'");
		return rs;
	}
	
	public int zenjia(String a,String s,String d,String f) throws ClassNotFoundException, SQLException {
		
		int rs=user.updateData("insert into product (pno,pname,psize,pprize)values('"+a+"','"+s+"','"+d+"','"+f+"')");
		return rs;
		
	}
	
	public int deletep(String ooo) throws ClassNotFoundException, SQLException {
		int rs=user.deleteDate("delete from product where pno='"+ooo+"'");
		return rs;
	}
	
	public int xx(String a,String s,String d,String f) throws ClassNotFoundException, SQLException {
		
		int rs=user.updateData("update product set pname='"+s+"',psize='"+d+"', pprize='"+f+"'"+" where pno='"+a+"'");
		return rs;
		
	}
	//查询所有员工的信息
	public String peopleall() throws ClassNotFoundException, SQLException {
		ResultSet rs=user.chaxun("select * from people");
		String str ="";
		while(rs.next())
		str+="姓名:"+rs.getString(1)+" 工作:"+rs.getString(2)+" 薪资水平:"+rs.getString(3)+"\n";
		return str;
	}
	//查询所有工作信息
	public String joball() throws ClassNotFoundException, SQLException {
		ResultSet rs=user.chaxun("select * from job");
		String str ="";
		while(rs.next())
		str+="职位:"+rs.getString(1)+"  序号:"+rs.getString(2)+"\n";
		return str;
	}
	//查询所有薪资水平
	public String slaryall() throws ClassNotFoundException, SQLException {
		ResultSet rs=user.chaxun("select * from slary");
		String str ="";
		while(rs.next()) {
		str+="薪资水平:"+rs.getString(2)+"  薪资数目:"+rs.getString(1)+"\n";
		};
		return str;
	}
	//添加新职位
	public int addjob(String jobname,String jobnum) throws ClassNotFoundException, SQLException {
		int rs=user.updateData("insert into job (jobname,jobnum)values('"+jobname+"','"+jobnum+"')");
		return rs;
	}
	//修改职位名称
	public String upddatejob() throws ClassNotFoundException, SQLException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");// HH:mm:ss

		Date date = new Date(System.currentTimeMillis());
		String str=simpleDateFormat.format(date);
		return str;
	}
	//删除职位信息
	public int deletejob(String jobname) throws ClassNotFoundException, SQLException {
		int rs=user.deleteDate("delete from job where jobname='"+jobname+"'");
		return rs;
	}
	//添加薪资水平
	public int addslary(int slarynum,String slary) throws ClassNotFoundException, SQLException {
		int rs=user.updateData("insert into slary (slarynum,slary)values('"+slarynum+"','"+slary+"')");
		return rs;
	}
	//修改薪资数目
	public int updateslary(int slarynum,String slary) throws ClassNotFoundException, SQLException {
		int rs=user.updateData("update slary set slarynum="+slarynum+" where slary='"+slary+"'");
		return rs;
	}
	//删除薪资水平
	public int deleteslary(String slary) throws ClassNotFoundException, SQLException {
		int rs=user.deleteDate("delete from slary where slary='"+slary+"'");
		return rs;
	}
	//添加员工信息
	public int addpeople(String name,String jobname,String slary) throws ClassNotFoundException, SQLException {
		int rs=user.updateData("insert into people(name,jobname,slary)values('"+name+"','"+jobname+"','"+slary+"')");
		return rs;
	}
	//删除员工信息
	public int deletepeople(String name) throws ClassNotFoundException, SQLException {
		int rs=user.updateData("delete from people where name='"+name+"'");
		return rs;
	}
	public int zjw(String hh ,String he) throws ClassNotFoundException, SQLException {
		int rs=user.updateData("update xiadan set zhuangtai='"+hh+"'"+" where shi='"+he+"'");
		return rs;
	}
	//修改员工薪资
	public int updatepeopleslary(String name,String slary) throws ClassNotFoundException, SQLException {
		int rs=user.updateData("update people set slary='"+slary+"'"+" where name='"+name+"'");
		return rs;
	}
	//修改员工职位
	public int updatepeoplejob(String name,String jobname) throws ClassNotFoundException, SQLException {
		int rs=user.updateData("update people set jobname='"+jobname+"' where name='"+name+"'");
		return rs;
	}
}
