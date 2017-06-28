<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>e</title>
    </head>
  
  <body>
   <form 
   		action="${pageContext.request.contextPath }/servlet/lyx_tupServlet" method="post">
		请输入有向图点个数<input type="text" name="diannum" id="diannum"/><br> 
		请输入有向图边个数<input type="text" name="biannum" id="biannum" /> 
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
			var diannum = document.getElementById("diannum").value;
			var biannum = document.getElementById("biannum").value;
			var div = document.getElementById("div");
			var dianT = document.getElementById('dianT');
			var bianT = document.getElementById('bianT');
			// var result = "";
			//document.getElementById("div").innerHTML = "<div id='div'>"
			//------------------------------------
			var tr1 = document.createElement('tr');
			var th1 = document.createElement('th');
			var textNode1 = document.createTextNode("顶点序号");
			th1.appendChild(textNode1);
			tr1.appendChild(th1);

			var th2 = document.createElement('th');
			var textNode2 = document.createTextNode("顶点名称");
			th2.appendChild(textNode2);
			tr1.appendChild(th2);
			dianT.append(tr1);



			for(var i = 0;i < diannum;i++)
			{
				var tr2 = document.createElement('tr');
				var td1 = document.createElement('td');
				var textNode1 = document.createTextNode((i + 1) + " : ");
				td1.appendChild(textNode1);
				tr2.appendChild(td1);


				var td3 = document.createElement('td');
				var inputTag = document.createElement('input');
				inputTag.type='text';
				inputTag.name="dian" + (i + 1);
				
				td3.appendChild(inputTag);
			
				tr2.appendChild(td3);
				dianT.append(tr2);
			}


			var tr11 = document.createElement('tr');
			var th11 = document.createElement('th');
			var textNode11 = document.createTextNode("边序号");
			th11.appendChild(textNode11);
			tr11.appendChild(th11);

			var th22 = document.createElement('th');
			var textNode22 = document.createTextNode("始点");
			th22.appendChild(textNode22);
			tr11.appendChild(th22);
			bianT.append(tr11);


			var th23 = document.createElement('th');
			var textNode23 = document.createTextNode("终点");
			th23.appendChild(textNode23);
			tr11.appendChild(th23);
			bianT.append(tr11);



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
				bianT.append(tr2);
			}
			





			//------------------------------------

			// for(var i = 0;i < dianshu;i++){
				
			// }
			// var node = document.createTextNode();
			
			// node.innerHTML = result;
			// div.appendChild(node);
				/*for (i = 0; i < diannum; i++) {
			 		document.getElementById("div").innerHTML += "请输入第" + (i + 1) + "条边的起点和终点:";
					for (j = 0; j < 2; j++) {
						document.getElementById("div").innerHTML += "<input type='text' name='bian" + i + "-" + j + "' size='4'/>";
					}
					document.getElementById("div").innerHTML += "<br>";
				}
				document.getElementById("div").innerHTML += "</div>" ;*/
		}
		
		</script>
		
		<input type="submit" value="提交" />
	</form>
  </body>
</html>
