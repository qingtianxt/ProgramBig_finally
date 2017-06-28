package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gxt.ArrayUtils;

public class gxt_heapServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String number = (String)request.getParameter("number");
		String a[] = number.split(",");
		int type = Integer.parseInt((String)request.getParameter("type"));
		double b[]=new double [a.length];
		for(int i=0;i<a.length;i++)
		{
			b[i]=Integer.parseInt(a[i]);
		}
		String str = "";
		ArrayUtils d = new ArrayUtils();
		
		double brray[] = d.heapSort(type, b);
		for (int i = 0; i < b.length; i++) {
			double eps = 1e-10; // ¾«¶È·¶Î§
			if (brray[i] - (double) ((int) brray[i]) < eps) {
				System.out.print((int) brray[i] + " ");
				str+=""+brray[i]+", ";
			} else {
				System.out.print(brray[i] + " ");
				
				str+=""+brray[i]+", ";
			}
		}
		out.println("<center>");
		out.println("<h1>¶ÑÅÅÐòÎª</h1>");
		out.println("<hr>");
		out.print(str);
		out.print("<br>");
		out.print(d.output);
		out.println("</center>");
		request.getRequestDispatcher("/main.jsp").include(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
