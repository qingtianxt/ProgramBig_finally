<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'wzw_kmp.jsp' starting page</title>
  </head>
  
  <body>
  <h1 align="center" style="color: red">KMP算法演示实例</h1>
  <hr>
  <h3 align="center">请输入主串和子串</h3>
	<form action="${pageContext.request.contextPath }/servlet/wzw_kmpServlet" method="post">
		<table align="center">
			<tr>
				<td>主串</td>
				<td><input name="mainstring"></td>
			</tr>
			<tr>
				<td>子串</td>
				<td><input name="childstring"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
	  <p>参考内容</p>
        <p>主串:abbabbbbcab</p>
        <p>模式串:b</p>
  </body>
</html>
