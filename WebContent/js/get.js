function juz1(){
	var row1 = document.getElementById("row1").value;
    var column1 = document.getElementById("column1").value;
    var div1 = document.getElementById("div1");
    var div2 = document.getElementById("div2");
     for( i = 0; i< row1;i++){
        for( j = 0;j< column1;j++ ){
       
        div1.innerHTML="<input type='text' name='str"+i+"-"+j+"' size='4'/>";
        } 
        div1.innerHTML="<br>";
       }   
}