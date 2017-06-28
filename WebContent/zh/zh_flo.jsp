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
		<h1>弗洛伊德算法</h1>
		<hr>

		<form action="${pageContext.request.contextPath }/servlet/zh_floServlet" method="post">
			<table>
				<tr>
					<td>请输入顶点1到各顶点的距离</td>
					<td><input name="v1" id="v11" size="3"/></td>
					<td><input name="v1" id="v12" size="3"/></td>
					<td><input name="v1" id="v13" size="3"/></td>
					<td><input name="v1" id="v14" size="3"/></td>
					<td><input name="v1" id="v15" size="3"/></td>
				</tr>
				<tr>
					<td>请输入顶点2到各顶点的距离</td>
					<td><input name="v2" id="v21" size="3"/></td>
					<td><input name="v2" id="v22" size="3"/></td>
					<td><input name="v2" id="v23" size="3"/></td>
					<td><input name="v2" id="v24" size="3"/></td>
					<td><input name="v2" id="v25" size="3"/></td>
				</tr>
				<tr>
					<td>请输入顶点3到各顶点的距离</td>
					<td><input name="v3" id="v31" size="3"/></td>
					<td><input name="v3" id="v32" size="3"/></td>
					<td><input name="v3" id="v33" size="3"/></td>
					<td><input name="v3" id="v34" size="3"/></td>
					<td><input name="v3" id="v35" size="3"/></td>
				</tr>
				<tr>
					<td>请输入顶点4到各顶点的距离</td>
					<td><input name="v4" id="v41" size="3"/></td>
					<td><input name="v4" id="v42" size="3"/></td>
					<td><input name="v4" id="v43" size="3"/></td>
					<td><input name="v4" id="v44" size="3"/></td>
					<td><input name="v4" id="v45" size="3"/></td>
				</tr>
				<tr>
					<td>请输入顶点5到各顶点的距离</td>
					<td><input name="v5" id="v51" size="3"/></td>
					<td><input name="v5" id="v52" size="3"/></td>
					<td><input name="v5" id="v53" size="3"/></td>
					<td><input name="v5" id="v54" size="3"/></td>
					<td><input name="v5" id="v55" size="3"/></td>
				</tr>
			</table>
			<input type="submit" value="提交" /> <br>
			<br> 参考内容
			<table>
				<tr>
					<td>0</td>
					<td>3</td>
					<td>8</td>
					<td>m</td>
					<td>4</td>
				</tr>
				<tr>
					<td>m</td>
					<td>0</td>
					<td>m</td>
					<td>1</td>
					<td>7</td>
				</tr>
				<tr>
					<td>m</td>
					<td>4</td>
					<td>0</td>
					<td>m</td>
					<td>m</td>
				</tr>
				<tr>
					<td>2</td>
					<td>m</td>
					<td>5</td>
					<td>0</td>
					<td>m</td>
				</tr>
				<tr>
					<td>m</td>
					<td>m</td>
					<td>m</td>
					<td>6</td>
					<td>0</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>