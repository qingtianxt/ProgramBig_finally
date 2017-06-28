package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wzw_kmp.wzw_kmp;

/**
 * Servlet implementation class wzw_kmpServlet
 */
public class wzw_kmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w =response.getWriter();
		String main = request.getParameter("mainstring");
		String child = request.getParameter("childstring");
		wzw_kmp k1 =new wzw_kmp();
		char[] m =main.toCharArray();
		char[] c =child.toCharArray();
		int[] next = k1.next(c);//模式串的next结果'
		int[] next1 = new int[next.length];
		for(int i=0;i<next.length;i++){
			next1[i]=next[i]+1;
		}
		int index = k1.KMP_Index(m, c);//最后需要获取的KMP比较的下标
		w.println("<h2 align='center'>模式串的每个字符对应的next值为：</h2>");
		w.println("<table>");
		for(int i=0;i<next.length;i++){
			
			w.print("<tr><td>"+(i+1)+"</td><td>"+next1[i]+"</td></tr>");
		}
		w.println("</table>");
		String rs="";
		if(index==-1)
		{
			rs="主串和模式串不匹配";
		}
		else
		{
			rs="模式串在主串中的下标是"+index+" ";
		}
		w.println("<hr>"+rs);
		request.getRequestDispatcher("/main.jsp").include(request, response);
		//response.sendRedirect(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/ceshi.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
