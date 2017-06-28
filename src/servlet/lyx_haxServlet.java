package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lyx_hashTable.lyx_hax_dtl;
import lyx_hashTable.lyx_hax_tab;

/**
 * Servlet implementation class lyx_haxServlet
 */
public class lyx_haxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String data = request.getParameter("data");
		String[] split = data.split(",");
		int[] data1 = new int[split.length];
		for(int i=0;i<data1.length;i++){
			data1[i]=Integer.parseInt(split[i].trim());
		}
		
		lyx_hax_tab h1 = new lyx_hax_tab(data1.length+5);
		String[] rs=new String[data1.length];
		 
		for(int i=0;i<data1.length;i++){
			lyx_hax_dtl cc=new lyx_hax_dtl(data1[i]);
			rs[i]=h1.insert(cc);//把数据插入其中，并把插入的情况用rs数组接收
		}
		lyx_hax_dtl cc=new lyx_hax_dtl();
		String dpt = h1.displayTable();//接受哈希表内的数据
		for(int i=0;i<rs.length;i++){
			out.print(rs[i]+"<br>");
		}
		out.print("<hr>");
		out.print(dpt);
		 //request.getRequestDispatcher("main.jsp").include(request, response);
        out.print("<a href='/ProgramBig/main.jsp'>返回</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
