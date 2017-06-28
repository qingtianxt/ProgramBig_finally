<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>11</title>
  </head>
  <body>
     <p>请将需要插入的数据输入到文本框，数与数之间用，隔开</p>
	<form action="${pageContext.request.contextPath }/servlet/lyx_haxServlet" method="post">
		要插入的数<input name="data">
		<input type="submit" value="提交">
	</form>
  </body>
</html>
