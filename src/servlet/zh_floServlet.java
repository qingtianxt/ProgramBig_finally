package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.Folyd_text;

public class zh_floServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int m = Integer.MAX_VALUE;
		PrintWriter out=response.getWriter();
		String[] str1 = (String[])request.getParameterValues("v1");
		String[] str2 = (String[])request.getParameterValues("v2");
		String[] str3 = (String[])request.getParameterValues("v3");
		String[] str4 = (String[])request.getParameterValues("v4");
		String[] str5 = (String[])request.getParameterValues("v5");
		
		int[][] dist;
		int[][] path;
		List result = new ArrayList();
		
		Folyd_text folyd = new Folyd_text(5);
		
		int a[][]={
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}
				};
		
		for(int i=0;i<str1.length;i++)
		{
			if(str1[i].equals("m"))
				a[0][i]=m;
			else
				a[0][i] = Integer.parseInt(str1[i]);
		}
		for(int i=0;i<str2.length;i++)
		{
			if(str2[i].equals("m"))
				a[1][i]=m;
			else
				a[1][i] = Integer.parseInt(str2[i]);
		}
		for(int i=0;i<str3.length;i++)
		{
			if(str3[i].equals("m"))
				a[2][i]=m;
			else
				a[2][i] = Integer.parseInt(str3[i]);
		}
		for(int i=0;i<str4.length;i++)
		{
			if(str4[i].equals("m"))
				a[3][i]=m;
			else
				a[3][i] = Integer.parseInt(str4[i]);
		}
		for(int i=0;i<str5.length;i++)
		{
			if(str5[i].equals("m"))
				a[4][i]=m;
			else
				a[4][i] = Integer.parseInt(str5[i]);
		}
		
		folyd.Floyd(a);
		folyd.findCheapestPath(4, 1, a);
		List list1 = folyd.result;
		out.println("<center>");
		out.println("<h1>佛洛依德算法</>");
		out.println("<hr>");
		out.println("从4到1的最短路径为："+list1.toString());
		out.println("</center>");
		request.getRequestDispatcher("/main.jsp").include(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
