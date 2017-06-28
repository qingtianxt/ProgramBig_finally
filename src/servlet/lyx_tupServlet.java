package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lyx_tupServlet
 */
public class lyx_tupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lyx_tupServlet() {
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
		int dianNum = Integer.parseInt(request.getParameter("diannum"));
		int bianNum = Integer.parseInt(request.getParameter("biannum"));
		String[] dianStr = new String[dianNum];
		String[] bianStr = new String[bianNum];
		
		for(int i = 0;i < dianNum;i++){
			dianStr[i] = request.getParameter("dian" + (i + 1));
			System.out.println(dianStr[i]);
		}
		for(int i = 0;i < bianNum;i++){
			bianStr[i] = request.getParameter("bian1" + (i + 1)) + "#" + request.getParameter("bian2" + (i + 1));
			System.out.println(bianStr[i]);
		}
		lyx_tup.Topological.initjsp(dianStr, bianStr);
		lyx_tup.Topological.topsort();
		String result = lyx_tup.Topological.output();
		String[] results = result.split("#");
		StringBuffer buffer = new StringBuffer();  
		if(results[0].equals("0")){
			buffer.append("该图有圈");
		}
		else{
			//为AOV网
			buffer.append("为AOV网,拓扑序列为：");
			for(int i = 1;i < results.length;i++){
				buffer.append(results[i] + "\t");
			}
		}
		PrintWriter out = response.getWriter();
		out.println("<hr>" + buffer.toString());
		request.getRequestDispatcher("main.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
