package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.zk_juz;
import service.zk_services;

public class zk_juzServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int row1 = Integer.parseInt(request.getParameter("row1"));
		int row2 = Integer.parseInt(request.getParameter("row2"));
		int column1 = Integer.parseInt(request.getParameter("column1"));
		int column2 = Integer.parseInt(request.getParameter("column2"));
		String sign = request.getParameter("sign");
		double[][] array1 = new double[row1][column1];
		double[][] array2 = new double[row2][column2];
		for(int i = 0;i<row1;i++){
			for(int j=0;j<column1;j++){
				array1[i][j] = Double.parseDouble(request.getParameter("s1tr"+i+"-"+j));
				array2[i][j] = Double.parseDouble(request.getParameter("s2tr"+i+"-"+j));
			}
		}
		zk_juz juzBean1 = new zk_juz(row1, column1, array1);
		zk_juz juzBean2 = new zk_juz(row2, column2, array2);
		zk_services zk = new zk_services();
		zk_juz juzBean = zk.juzService(juzBean1, juzBean2, sign);
		for(int i = 0;i<juzBean.getRow();i++){
			for(int j=0;j<juzBean.getColumn();j++){
				response.getWriter().write(String.valueOf(juzBean.getArray()[i][j]+" "));
			}
			response.getWriter().write("<br>");
		}
		request.getRequestDispatcher("/main.jsp").include(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
