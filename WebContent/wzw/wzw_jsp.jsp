<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
  <h1 align="center" style="color: red">基数排序算法演示实例</h1>
  <hr>
  <h3 align="center">请输入需要排序的数据，数与数之间用，隔开</h3>
	<form action="${pageContext.request.contextPath }/servlet/wzw_jspServlet" method="post">
		<table align="center">
			<tr>
				<td>字符串</td>
				<td><input name="base"></td>
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
        <p>3,2,4</p>  
        </div>
  </body>
</html>
