package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.Kruskal_text;

public class zh_kruServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int MAX = Integer.MAX_VALUE;
		PrintWriter out=response.getWriter();
		String[] str1 = (String[])request.getParameterValues("v1");
		String[] str2 = (String[])request.getParameterValues("v2");
		String[] str3 = (String[])request.getParameterValues("v3");
		String str4 = request.getParameter("v4");
		int a[][]={
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}
				};
		
		for(int i=1;i<str1.length+1;i++)
		{
			a[0][i] = Integer.parseInt(str1[i-1]);
			a[i][0] = a[0][i];
		}
		for(int i=2;i<str2.length+2;i++)
		{
			a[1][i] = Integer.parseInt(str2[i-2]);
			a[i][1] = a[1][i];
		}
		for(int i=3;i<str3.length+3;i++)
		{
			a[2][i] = Integer.parseInt(str3[i-3]);
			a[i][2] = a[2][i];
		}
		a[3][4] = Integer.parseInt(str4);
		a[4][3] = a[3][4];
		
		Kruskal_text kruskal = new Kruskal_text();
		String b = kruskal.kruskal(a);
		out.println("<center>");
		out.println("<h1>克鲁斯卡尔算法</h1>");
		out.println("<hr>");
		out.println("最小生成树的边是："+b);
		out.println("</center>");
		request.getRequestDispatcher("/main.jsp").include(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
