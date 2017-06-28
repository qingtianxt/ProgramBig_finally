<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'wzw_hfm.jsp' starting page</title>
  </head>
  
  <body>
  <h1 align="center" style="color: red">哈夫曼树编码算法演示</h1>
  <hr>
	<h3 align="center">请输入需要编码的权值与权值之间用，隔开</h3>
	<div align="center">
	<form action="${pageContext.request.contextPath }/servlet/wzw_hfmServlet" method="post">
	<table align="center">
			<tr>
				<td><input name="weight"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>		
	</form>
        <p>参考内容</p>
        <p>3,2,4</p>  
	</div>
</html>
