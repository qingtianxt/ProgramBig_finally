package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zk_diGraph.Tarjan;

public class zk_qltServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int dianNum = Integer.parseInt(request.getParameter("dianNum")) + 1;
		int bianNum = Integer.parseInt(request.getParameter("bianNum"));
		System.out.println(dianNum+", "+bianNum);
		List< ArrayList<Integer> > graph = new ArrayList<ArrayList<Integer>>(); //Í¼ 
        for(int i=0;i<dianNum ;i++){  
            graph.add(new ArrayList<Integer>());  
        }   
		for(int i = 0; i< bianNum;i++){
			int a = Integer.parseInt(request.getParameter("bian"+i+"-"+0));
			int b = Integer.parseInt(request.getParameter("bian"+i+"-"+1));
			graph.get(a).add(b);
			
		}
		Tarjan  t = new  Tarjan(graph, dianNum); 
		List< ArrayList<Integer> > result = t.run();  
        //´òÓ¡½á¹û  
		for(int i=1;i<result.size();i++){  
		    for(int j=0;j<result.get(i).size();j++){ 
		    	response.getWriter().write(result.get(i).get(j)+" "); 
		    	System.out.print(result.get(i).get(j)+" ");
		    }  
		    response.getWriter().write("<br>"); 
		    System.out.println();
			} 
		request.getRequestDispatcher("/main.jsp").include(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
