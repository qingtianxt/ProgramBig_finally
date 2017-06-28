<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'wzw_huf.jsp' starting page</title>
   
  </head>
  
  <body>
  <h1 align="center" style="color: red">由遍历序列回复二叉树</h1>
  <hr>
  <h3 align="center">请输入主串和子串</h3>
	<form action="${pageContext.request.contextPath }/servlet/wzw_hufServlet" method="post">
		<table align="center">
			<tr>
				<td>先序</td>
				<td><input type="radio" name="data" value="1" checked="checked"></td>
				<td>后序</td>
				<td><input type="radio" name="data" value="2"></td>
			</tr>
			<tr>
				<td>先序或后序</td>
				<td><input name="xianhou"></td>
			</tr>
			<tr>
				<td>中序</td>
				<td><input name="zhongxu"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
  <div align="center">
	  <p>参考内容</p>
        <p>先序：1,2,8,7,3,4,5,6,9</p>
        <p>中序：8,2,7,1,5,4,6,3,9</p>
        <p>后序：8,7,2,5,6,4,9,3,1</p>  
  </div>
  </body>
</html>
