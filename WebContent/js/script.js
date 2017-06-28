function showsub(li){
    var submenu=li.getElementsByTagName("ul")[0];  
    submenu.style.display="block";  
}  
function hidesub(li){  
    var submenu=li.getElementsByTagName("ul")[0];  
    submenu.style.display="none";  
}
function check() {
    if(confirm("您确定要退出吗?")){
	        window.location.href = "logout.jsp"
         }
     }