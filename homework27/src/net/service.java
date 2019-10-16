package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class service
 */
@WebServlet("/service")
public class service extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public service() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Userservice user=new Userservice();
		try {
			user.init();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter writer = response.getWriter();
			int a = Integer.parseInt(request.getParameter("choose"));
			
			switch (a) {
			case 1: {
				String name=request.getParameter("name");
				String psw=request.getParameter("psw");
				writer.write(user.checkb(name, psw));
				break;
			}
			case 2: {
				List<product> list = user.searchall();
				for(int i=0;i<list.size();i++) {
					writer.write(list.get(i).toString()+"\n");
				}
				break;
			}
			case 3: {
				String pnames=request.getParameter("pnames");
				String pchicun=request.getParameter("pchicun");
				String pjiage=request.getParameter("pjiage");
				List<product> list = user.searchsome(pnames,pchicun,pjiage);
				for(int i=0;i<list.size();i++) {
					writer.write(list.get(i).toString()+"\n");
				}
				break;
			}
			case 4: {
				String ee=request.getParameter("ee");
				String rr=request.getParameter("rr");
				int i=user.shopp(ee, rr);
				if(i==1) {
					writer.write("成功");
					
				}else {
					writer.write("失败");
				}
				break;
			}
			
			
			case 5: {
				String aa=request.getParameter("aa");
				List<gouwux> list = user.cha(aa);
				for(int i=0;i<list.size();i++) {
					writer.write(list.get(i).toString()+"\n");
				}
				break;
			}
			case 6: {
				String ll=request.getParameter("ll");
				String pp=request.getParameter("pp");
				
				int b = user.xiadana(ll,pp);
				int g =user.shan(ll);
				writer.write(b);
				writer.write(g);
				break;
			}
			case 7: {
				String uu=request.getParameter("uu");
				List<Dingdan> list = user.chad(uu);
				for(int i=0;i<list.size();i++) {
					writer.write(list.get(i).toString()+"\n");
				}
				break;
			}
			case 0:{
				String name=request.getParameter("name");
				String jobname=request.getParameter("jobname");
				String slary=request.getParameter("slary");
				writer.write(user.addpeople(name, jobname, slary));
				break;
			}
			case 23:{
			
				break;
			}
			case 8: {
				String z=request.getParameter("zzb");
				String x=request.getParameter("zzm");
				String c=request.getParameter("zzc");
				String v=request.getParameter("zzj");
				int m=user.zenjia(z, x, c, v);
				if(m==1) {
					writer.write("成功");
				}else {
					writer.write("失败");
				}
				
				break;
			}
			case 9:{
				String ooo=request.getParameter("ooo");
				int l=user.deletep(ooo);
				if(l==1) {
					writer.write("成功");
				}else {
					writer.write("失败");
				}
				break;
			}
			case 10:{
				String g=request.getParameter("xxb");
				String h=request.getParameter("xxm");
				String j=request.getParameter("xxc");
				String k=request.getParameter("xxj");
				int m=user.xx(g, h, j, k);
				
				
				if(m==1) {
					writer.write("成功");
					
				}else {
					writer.write("失败");
				}
				break;
			}
			case 11:{
				String yy=user.upddatejob();
				writer.write(yy);
				break;
			}
			case 12:{
				
				List<Dingdan> list = user.chadd();
				for(int i=0;i<list.size();i++) {
					writer.write(list.get(i).toString()+"\n");
				}
				break;
			}
			case 13:{
				String hh=request.getParameter("hh");
				String he=request.getParameter("he");
				if(user.zjw(hh,he)==1) {
					writer.write("成功");
				}else {
					writer.write("失败");
				}
				
				break;
			}
			default:{
				System.out.println("cacaca");
			}
		}
	} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
