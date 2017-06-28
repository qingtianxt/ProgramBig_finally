function test(){
     var e = window.event;
     var iFrameElem = document.getElementById('iframe');
     var target = e.target||e.srcElement;
     //----曾凯-----
     if(target.getAttribute("id") == "zk_exp"){
    	 iFrameElem.src="zk/zk_exp.jsp";
     }else if(target.getAttribute("id") == "zk_juz"){
    	 iFrameElem.src="zk/zk_juz.jsp";
     }else if(target.getAttribute("id") == "zk_qlt"){
    	 iFrameElem.src="zk/zk_qlt.jsp";
     }
   //----王志伟----
     else if(target.getAttribute("id") == "wzw_kmp"){
    	 iFrameElem.src="wzw/wzw_kmp.jsp";
     }else if(target.getAttribute("id") == "wzw_hfm"){
    	 iFrameElem.src="wzw/wzw_hfm.jsp";
     }else if(target.getAttribute("id") == "wzw_huf"){
    	 iFrameElem.src="wzw/wzw_huf.jsp";
     }else if(target.getAttribute("id") == "wzw_jsp"){
    	 iFrameElem.src="wzw/wzw_jsp.jsp";
     } 
     //----张浩----
     else if(target.getAttribute("id") == "zh_pri"){
    	 iFrameElem.src="zh/zh_pri.jsp";
     }else if(target.getAttribute("id") == "zh_kru"){
    	 iFrameElem.src="zh/zh_kru.jsp";
     }else if(target.getAttribute("id") == "zh_flo"){
    	 iFrameElem.src="zh/zh_flo.jsp";
     }else if(target.getAttribute("id") == "zh_dij"){
    	 iFrameElem.src="zh/zh_dij.jsp";
     } 
   //----刘雨鑫----
     else if(target.getAttribute("id") == "lyx_tup"){
    	 iFrameElem.src="lyx/lyx_tup.jsp";
     }else if(target.getAttribute("id") == "lyx_gjl"){
    	 iFrameElem.src="lyx/lyx_gjl.jsp";
     }else if(target.getAttribute("id") == "lyx_scs"){
    	 iFrameElem.src="lyx/lyx_scs.jsp";
     }else if(target.getAttribute("id") == "lyx_hax"){
    	 iFrameElem.src="lyx/lyx_hax.jsp";
     } 
   //----高雪彤----
     else if(target.getAttribute("id") == "gxt_xer"){
    	 iFrameElem.src="gxt/gxt_xer.jsp";
     }else if(target.getAttribute("id") == "gxt_kpa"){
    	 iFrameElem.src="gxt/gxt_kpa.jsp";
     }else if(target.getAttribute("id") == "gxt_dui"){
    	 iFrameElem.src="gxt/gxt_dui.jsp";
     }else if(target.getAttribute("id") == "gxt_gub"){
    	 iFrameElem.src="gxt/gxt_gub.jsp";
     } 
     
}

