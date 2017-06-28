package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.Prim_text;

public class zh_priServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int m = Integer.MAX_VALUE;
		PrintWriter out=response.getWriter();
		String[] str1 = (String[])request.getParameterValues("v1");
		String[] str2 = (String[])request.getParameterValues("v2");
		String[] str3 = (String[])request.getParameterValues("v3");
		String str4 = request.getParameter("v4");
		int a[][]={
				{0,0,0,0,0,0},
				{0,m,0,0,0,0},
				{0,0,m,0,0,0},
				{0,0,0,m,0,0},
				{0,0,0,0,m,0},
				{0,0,0,0,0,m}
				};
		
		for(int i=2;i<str1.length+2;i++)
		{
			a[1][i] = Integer.parseInt(str1[i-2]);
			a[i][1] = a[1][i];
		}
		for(int i=3;i<str2.length+3;i++)
		{
			a[2][i] = Integer.parseInt(str2[i-3]);
			a[i][2] = a[2][i];
		}
		for(int i=4;i<str3.length+4;i++)
		{
			a[3][i] = Integer.parseInt(str3[i-4]);
			a[i][3] = a[3][i];
		}
		a[4][5] = Integer.parseInt(str4);
		a[5][4] = a[4][5];
		
		int verNum = a.length;        //顶点个数
		int []lowerW = new int[verNum];    //顶点数组
		int []edge = new int[verNum];        //边数组
		boolean []checked = new boolean[verNum];  //判断是否访问
		
		Prim_text prim = new Prim_text();
		String b = prim.prim(verNum-1, a);
		
		out.println("<center>");
		out.println("<h1>迪杰斯特拉算法</h1>");
		out.println("<hr>");	
		out.println("最小生成树的边为："+b);
		out.println("</center>");
		request.getRequestDispatcher("/main.jsp").include(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
