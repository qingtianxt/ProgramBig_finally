<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>迪杰斯特拉算法</h1>
		<hr>

		<form action="${pageContext.request.contextPath }/servlet/zh_dijServlet" method="post">
			<table>
				<tr>
					<td>请输入顶点1到各顶点的距离</td>
					<td><input name="v1" id="v12" size="3"/></td>
					<td><input name="v1" id="v13" size="3"/></td>
					<td><input name="v1" id="v14" size="3"/></td>
					<td><input name="v1" id="v15" size="3"/></td>
				</tr>
				<tr>
					<td>请输入顶点2到各顶点的距离</td>
					<td><input name="v2" id="v23" size="3"/></td>
					<td><input name="v2" id="v24" size="3"/></td>
					<td><input name="v2" id="v25" size="3"/></td>
				</tr>
				<tr>
					<td>请输入顶点3到各顶点的距离</td>
					<td><input name="v3" id="v34" size="3"/></td>
					<td><input name="v3" id="v35" size="3"/></td>
				</tr>
				<tr>
					<td>请输入顶点4到各顶点的距离</td>
					<td><input name="v4" id="v45" size="3"/></td>
				</tr>
			</table>
			<input type="submit" value="提交" /> <br>
			<br> 参考内容
			<table>
				<tr>
					<td>10</td>
					<td>200</td>
					<td>200</td>
					<td>200</td>
				</tr>
				<tr>
					<td>20</td>
					<td>200</td>
					<td>200</td>
				</tr>
				<tr>
					<td>30</td>
					<td>200</td>
				</tr>
				<tr>
					<td>40</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>