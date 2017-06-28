<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>11</title>
  </head>
  <body>
  <h1 align="center" style="color: red">四则表达式计算 </h1>
  <hr>
    <h3 align="center">请输入需要计算的表达式（可以有小数，多位数）</h3>
    <div align="center">
    <form action="${pageContext.request.contextPath }/servlet/zk_expServlet" method="post">
        <input type="text" name="str" />
        <input type="submit" value="提交"/>
    </form>
        <p>参考内容</p>
        <p>11.2+(20.2-3*3-5.6+70.5)*(2.2+9.3)/12.9</p>  
    </div> 
  </body>
</html>
