<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>求解有向图强连通分量</title>
</head>
<body>
<h1 align="center" style="color: red">求解有向图强连通分量 </h1>
  <hr>
    <h3 align="center"></h3>
    <div align="center">
	<form
		action="${pageContext.request.contextPath }/servlet/zk_qltServlet" method="post">
		请输入有向图点个数<input type="text" name="dianNum" size="3"/><br> 
		请输入有向图边个数<input type="text" name="bianNum" id="bianNum" size="3"/> 
		<input type="button" value="下一步" onclick="setdiv()">
		<div id="div"></div>
		<script language="javascript">
			function setdiv() {
				var bianNum = document.getElementById("bianNum").value;
				var div1 = document.getElementById("div1");
				document.getElementById("div").innerHTML = "<div id='div'>"
				for (i = 0; i < bianNum; i++) {
			 		document.getElementById("div").innerHTML += "请输入第" + (i + 1) + "条边的起点和终点:";
					for (j = 0; j < 2; j++) {
						document.getElementById("div").innerHTML += "<input type='text' name='bian" + i + "-" + j + "' size='4'/>";
					}
					document.getElementById("div").innerHTML += "<br>";
				}
				document.getElementById("div").innerHTML += "</div>" ;
			}
		</script>
		<input type="submit" value="提交" />
	</form>
    </div>
</body>
</html>
