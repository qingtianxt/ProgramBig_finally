<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'lyx_scs.jsp' starting page</title>

  </head>
  
  <body>
  <h1 align="center" style="color: red">二叉排序树生成算法（含平衡化）</h1>
  <hr>
    <h3 align="center"></h3>
    <div align="center">
    <form action="${pageContext.request.contextPath }/servlet/lyx_scsServlet" method="post">
    <table align="center">
            <tr>
                <td><input name="data"></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
        
    </form>
    </div>
</html>