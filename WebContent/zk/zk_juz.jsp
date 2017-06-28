<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>11</title>
  </head>
  <body>
    <h1 align="center" style="color: red">矩阵运算  </h1>
  <hr>
    <div align="center">
    <form action="${pageContext.request.contextPath }/servlet/zk_juzServlet" method="post">
                       请输入第一个矩阵的行数<input type="text" name="row1" id="row1" size="3"/><br>
                       请输入第一个矩阵的列数<input type="text" name="column1" id="column1" size="3"/>
         <input type="button" value="下一步" onclick="setdiv1()"> 
            <div id="div1"></div>
			<script language="javascript"> 
			function setdiv1() 
			{ 
			var row1 = document.getElementById("row1").value;
		    var column1 = document.getElementById("column1").value;
		    var div1 = document.getElementById("div1");
		    document.getElementById("div1").innerHTML="<div  id='div1'>" 
		     for( i = 0; i< row1;i++){
		        for( j = 0;j< column1;j++ ){
		        document.getElementById("div1").innerHTML+="<input type='text' name='s1tr"+i+"-"+j+"' size='4'/>" ;
		        } 
		         document.getElementById("div1").innerHTML+="<br>";
		       }   
			  document.getElementById("div1").innerHTML+="</div>" ;
			} 
			</script>
                       请输入第二个矩阵的行数<input type="text" name="row2" id="row2" size="3"/><br>
                       请输入第二个矩阵的列数<input type="text" name="column2" id="column2" size="3"/>
         <input type="button" value="下一步" onclick="setdiv2()"> 
            <div id="div2"></div>
            <script language="javascript"> 
            function setdiv2() 
            { 
            var row2 = document.getElementById("row2").value;
            var column2 = document.getElementById("column2").value;
            var div2 = document.getElementById("div2");
            document.getElementById("div2").innerHTML="<div  id='div2'>" 
             for( i = 0; i< row2;i++){
                for( j = 0;j< column2;j++ ){
                document.getElementById("div2").innerHTML+="<input type='text' name='s2tr"+i+"-"+j+"' size='4'/>" ;
                } 
                 document.getElementById("div2").innerHTML+="<br>";
               }   
              document.getElementById("div2").innerHTML+="</div>" ;
            } 
            </script>  
            请输入运算符(+ | - | * | /):<input type="text" name="sign" size="3"/>         
        <input type="submit" value="提交" />
     </form>
     </div>
  </body>
</html>