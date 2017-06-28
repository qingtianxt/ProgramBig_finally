package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wzw_huf.wzw_huf_TreeNode;
import wzw_huf.wzw_huf_restore;
import wzw_huf.wzw_huf_restore1;

/**
 * Servlet implementation class wzw_hufServlet
 */
public class wzw_hufServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		

		String[] data = request.getParameterValues("data");
		String order="";//用来接收先序和后序的String串
		for(int i=0;i<data.length;i++){
			if(data[i]!=null){
				order=data[i];
				break;
			}
		}
		String data1=request.getParameter("xianhou");
		String data2=request.getParameter("zhongxu");
		String[] qx=data1.split(",");
		String[] zx=data2.split(",");
		int []qx1= new int[qx.length];
		int []zx1= new int[zx.length];
		for(int i=0;i<qx.length;i++){
			qx1[i]=Integer.parseInt(qx[i]);
			zx1[i]=Integer.parseInt(zx[i]);
		}
		String xianxu="";
		String zhongxu="";
		String houxu="";
		
		if(order.equals("1")){
			wzw_huf_restore s1 =new wzw_huf_restore();
			wzw_huf_TreeNode node = s1.reConstructBinaryTree(qx1,zx1);
			xianxu=s1.preTraverseBinTree(node);
			zhongxu=s1.inTraverseBinTree(node);
			houxu=s1.postTraverseBinTree(node);
		}
		else{
			wzw_huf_restore1 s2 = new wzw_huf_restore1();
			wzw_huf_TreeNode node = s2.reConstructBinaryTree(zx1,qx1);
			xianxu=s2.preTraverseBinTree(node);
			zhongxu=s2.inTraverseBinTree(node);
			houxu=s2.postTraverseBinTree(node);
		}
		PrintWriter out=response.getWriter();
		out.println("<p>先序遍历结果：</p>"+xianxu);
		out.println("<p>中序遍历结果：</p>"+zhongxu);
		out.println("<p>后序遍历结果：</p>"+houxu);
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
