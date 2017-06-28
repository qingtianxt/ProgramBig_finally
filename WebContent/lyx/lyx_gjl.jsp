<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>关键路径</title>
    </head>
  
  <body>
  	<form action="${pageContext.request.contextPath }/servlet/lyx_gjlServlet" method="post"> 
  	请输入有向图点个数<input type="text" name="diannum" id="diannum"/><br>
  	请输入有向图边个数<input type="text" name="biannum" id="biannum"/>
  	<input type="button" value="下一步" onclick="setdiv()">
  	<div id="inputDiv">
  	<div>
  	<table id="dianT">
  	
  	</table>
  	</div>
  	
  	<div>
  	<table id="bianT">
  	
  	</table>
  	</div>
  	</div>
  	<script language="javascript">
  	function setdiv(){
  		var diannum=document.getElementById("diannum").value;
  		var biannum=document.getElementById("biannum").value;
  		var div=document.getElementById("div");
  		var dianT=document.getElementById("dianT");
  		var bianT=document.getElementById("bianT");
  		
  		var tr1=document.createElement('tr');
  		var th1=document.createElement('th');
  		var textNode1=document.createTextNode("顶点序号");
  		th1.appendChild(textNode1);
  		tr1.appendChild(th1);
  		
  		var th2=document.createElement('th');
  		var textNode2=document.createTextNode("顶点名称");
  		th2.appendChild(textNode2);
  		tr1.appendChild(th2);
  		dianT.appendChild(tr1);
  		
  		for(var i=0;i<diannum;i++){
  			var tr2=document.createElement('tr');
  			var td1=document.createElement('td');
  			var textNode1 = document.createTextNode((i + 1) + " : ");
			td1.appendChild(textNode1);
			tr2.appendChild(td1);
			
			var td3 = document.createElement('td');
			var inputTag = document.createElement('input');
			inputTag.type='text';
			inputTag.name="dian" + (i + 1);
			
			td3.appendChild(inputTag);
		
			tr2.appendChild(td3);
			dianT.appendChild(tr2);	
  		}
  		var tr11 = document.createElement('tr');
		var th11 = document.createElement('th');
		var textNode11 = document.createTextNode("边序号");
		th11.appendChild(textNode11);
		tr11.appendChild(th11);

		var th22 = document.createElement('th');
		var textNode22 = document.createTextNode("起点名称");
		th22.appendChild(textNode22);
		tr11.appendChild(th22);
		bianT.appendChild(tr11);


		var th23 = document.createElement('th');
		var textNode23 = document.createTextNode("终点名称");
		th23.appendChild(textNode23);
		tr11.appendChild(th23);
		bianT.appendChild(tr11);

		
		var th24 = document.createElement('th');
		var textNode24 = document.createTextNode("权值");
		th24.appendChild(textNode24);
		tr11.appendChild(th24);
		bianT.appendChild(tr11);

		for(var i = 0;i < biannum;i++)
		{
			var tr2 = document.createElement('tr');
			var td1 = document.createElement('td');
			var textNode1 = document.createTextNode((i + 1) + " : ");
			td1.appendChild(textNode1);
			tr2.appendChild(td1);


			var td2 = document.createElement('td');
			var inputTag1 = document.createElement('input');
			inputTag1.type='text';
			inputTag1.name="bian1" + (i + 1);
			
			td2.appendChild(inputTag1);
			tr2.appendChild(td2);

			var td3 = document.createElement('td');
			var inputTag2 = document.createElement('input');
			inputTag2.type='text';
			inputTag2.name="bian2" + (i + 1);

			td3.appendChild(inputTag2);
			tr2.appendChild(td3);
			
			var td4= document.createElement('td');
			var inputTag3 = document.createElement('input');
			inputTag3.type='text';
			inputTag3.name="quan1" + (i + 1);
			
			td4.appendChild(inputTag3);
			tr2.appendChild(td4);
			
			bianT.appendChild(tr2);
  	   }
  	}
		</script>
		<input type="submit" value="提交"/>
		</form> 
  	
  </body>
</html>
