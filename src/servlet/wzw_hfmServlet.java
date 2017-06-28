package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wzw_hfm.wzw_hfm_cod;
import wzw_hfm.wzw_hfm_hfn;
import wzw_hfm.wzw_hfm_hft;

/**
 * Servlet implementation class wzw_hfmServlet
 */
public class wzw_hfmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		String weight = request.getParameter("weight");
		//System.out.println(weight);
		String[] w = weight.split(",");
		int n=w.length;
		int w1[]=new int[n];
		for(int i=0;i<n;i++){
			w1[i]=Integer.parseInt(w[i].trim());
		}
		wzw_hfm_hft haffTree = new wzw_hfm_hft(n);
		haffTree.haffman(w1);
		haffTree.haffmanCode();
		wzw_hfm_hfn[] nodes = haffTree.nodes;
		wzw_hfm_cod[] codes = haffTree.haffCode; 
		 //¹¹Ôì¹þ·òÂüÊ÷
        
        //Éú³É¹þ·òÂü±àÂë
       
        int a1[]=new int[n];
        String a2[]=new String[n];
        
        //´òÓ¡¹þ·òÂü±àÂë
        out.print("¹þ·òÂü±àÂë½á¹û£º"+"<hr>");
        for(int i=0;i<n;i++)
        {
            out.print("Weight="+codes[i].weight+" Code=");
            for(int j=codes[i].start+1;j<n;j++)
            {
               out.print(codes[i].bit[j]);    
            }
            out.println("<hr>");
        }
        
        
        wzw_hfm_hfn[] jiema = haffTree.jieMa();
        
        out.print("<br>");
    	out.print("½«¹þ·òÂü±àÂëºó½âÂëµÄ½á¹ûÊÇ£º");
        for(int i=0;i<jiema.length;i++){
        	out.print(jiema[i].weight+"&nbsp;&nbsp;");
        }
       request.getRequestDispatcher("/main.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
