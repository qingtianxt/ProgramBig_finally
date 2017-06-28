package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wzw_jsp.wzw_jsp_rds;

/**
 * Servlet implementation class wzw_jspServlet
 */
public class wzw_jspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w= response.getWriter();
		String base = request.getParameter("base");
		String[] b = base.split(",");
		
		int m=b[0].length();
		for(int i=1;i<b.length;i++){
			if(b[i].length()>m)
			{
				m=b[i].length();
				//System.out.println(b[i].length());
			}
		}
		//System.out.println(m);
		int[]a=new int[b.length];
		for(int i=0;i<b.length;i++){
			a[i]=Integer.parseInt(b[i].trim());
//			System.out.println(a[i]+" ");
		}
		wzw_jsp_rds r =new wzw_jsp_rds();
		int []a1=r.sort(a, m);
		int l =a1.length;
		w.println("<h2 align='center'>升序排列结果：</h2>");
		w.print("<table align='center'>");
		for(int i=0;i<l;i++){
			w.print("<tr><td>第"+(i+1)+"个数</td><td>"+a1[i]+"</td></tr>");
		}
		w.println("</table>");
		w.println("<h2 align='center'>降序排列结果：</h2>");
		w.print("<table align='center'>");
		for(int i=l-1;i>=0;i--){
			w.print("<tr><td>第"+(l-i)+"个数</td><td>"+a1[i]+"</td></tr>");
		}
		w.println("</table>");
		request.getRequestDispatcher("/main.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
