<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>希尔排序</title>
</head>

<body>
<center>
    <form action="${pageContext.request.contextPath }/servlet/gxt_shellServlet" method="post">
    <br><br><br>
        请输入需要排序的数字(以逗号分隔)：<input type="text" name="number" id="number" /> <input
            type="button" value="下一步" onclick="setdiv1()"> <br>
        <div id="div1"></div>
        <script language="javascript">
            function setdiv1() {
                var number = document.getElementById("number").value;
                var div1 = document.getElementById("div1");
                document.getElementById("div1").innerHTML = "<div id='div1'>"
                for (i = 0; i < number; i++) {

                    document.getElementById("div1").innerHTML += "<input type='text' name='"+i+"' size='4'/>";
                }
                document.getElementById("div1").innerHTML += "</div>";
            }
        </script>

        请选择排序类型： 从小到大<input type="radio" checked="checked" name="type"
            value="1"> 从大到小<input type="radio" name="type" value="2">
        <br> <br> <input type="submit" value="提交" />
    </form>
</center>
</body>
</html>