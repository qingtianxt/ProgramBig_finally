package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lyx_gjl.GuanJianLuJing;


/**
 * Servlet implementation class lyx_gjlServlet
 */
public class lyx_gjlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lyx_gjlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		 request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 int dianNum=Integer.parseInt(request.getParameter("diannum"));
		 int bianNum=Integer.parseInt(request.getParameter("biannum"));
		 String[] dianStr=new String[dianNum];
		 String[] bianStr=new String[bianNum];
		 
		 for(int i=0;i<dianNum;i++)
		 {
			 dianStr[i]=request.getParameter("dian"+(i+1));
			 System.out.println(dianStr[i]);
		 }
		 
		 for(int i=0;i<bianNum;i++)
		 {
			 bianStr[i]=request.getParameter("bian1"+(i+1))+"#"+request.getParameter("quan1"+(i+1))+"#"+request.getParameter("bian2"+(i+1));
			 System.out.println(bianStr[i]);
		 }
		 
		 
		 
		 GuanJianLuJing gjlj = new GuanJianLuJing();
		 gjlj.init(dianStr, bianStr);
		
		 
		 
		 //-------test
//		 String[] vexs = {"v0","v1","v4","v6","v7","v8"};
//			String[] arcs = {"v0#1#v1","v1#2#v4","v4#3#v6","v4#5#v7","v6#4#v8","v7#6#v8"};
			
//		gjlj.init(vexs, arcs);
		 
		 
		 StringBuffer buffer = new StringBuffer();
		 if(!gjlj.isAOV()){
			 buffer.append("有圈");
		 }
		 else{
		     String vel = gjlj.getVEL();
		     String el = gjlj.getEL();
		     List<String> list = gjlj.getGJL();
		     
		     
		     buffer.append("顶点：<br>");
		     String[] vels = vel.split("#");
		     for(int i = 0;i < vels.length;i++){
		    	 buffer.append(vels[i] + "<br>");
		     }
		     buffer.append("边：<br>");
		     String[] els = el.split("#");
		     for(int i = 0;i < els.length;i++){
		    	 buffer.append(els[i] + "<br>");
		     }
	         buffer.append("<br>");  
	
	         buffer.append("关键活动有：<br>");  
	         int w = 0;
	         for (String s : list) {  
	        	 String[] gj = s.split("#");
	        	 w += Integer.parseInt(gj[2]);
	        	 buffer.append(gj[0] + "---w:" + gj[2] + "--->" + gj[1] + "<br>");  
	         }  
	         buffer.append("总路径长度为： " + w + "<br>"); 
		 }
         PrintWriter out = response.getWriter();
 		out.println("<hr>" + buffer.toString());
 		request.getRequestDispatcher("/main.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
