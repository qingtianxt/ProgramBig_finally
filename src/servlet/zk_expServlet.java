package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.zk_fec;
import service.zk_services;

public class zk_expServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		zk_services zk = new zk_services();
		zk_fec fecBean = new zk_fec();
		String str = request.getParameter("str");
		fecBean = zk.fecService(str);
		System.out.println(str);
		response.getWriter().write("��׺���ʽΪ:"+str+"<br>");
		response.getWriter().write("ת��׺���ʽΪ��"+fecBean.getStr()+"<br>");
		response.getWriter().write("������Ϊ��"+fecBean.getNum());
		request.getRequestDispatcher("/main.jsp").include(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
