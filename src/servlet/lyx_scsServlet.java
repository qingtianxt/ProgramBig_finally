package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lyx_scs.SearchTree;
import lyx_scs.TreeOrder;

/**
 * Servlet implementation class scsServlet
 */
public class lyx_scsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String data = request.getParameter("data");
		String[] split = data.split(",");
		int[] data1 = new int[split.length];
		for(int i=0;i<data1.length;i++){
			data1[i]=Integer.parseInt(split[i].trim());
		}	
		 SearchTree tree = new SearchTree();
		 String[]rs=new String[data1.length];//������¼��������ʱ�Ƿ�ɹ�
		 for(int i=0;i<data1.length;i++){
			  rs[i] = tree.addTreeNode(data1[i]);
		 }
		String pre= TreeOrder.preOrderMethodOne(tree.root);
		String in=TreeOrder.medOrderMethodOne(tree.root);
		String pos=TreeOrder.postOrderMethodOne(tree.root);
		out.println("�������ݵ����<br>");
		for(int i=0;i<data1.length;i++){
			out.print(rs[i]+"<br>");
		}
		out.println("<hr>");
		out.println("�����������������У�<br>");
		out.println(pre);
		out.println("�����������������У�<br>");
		out.println(in);
		out.println("���������ĺ������У�<br>");
		out.println(pos);
		request.getRequestDispatcher("/main.jsp").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
