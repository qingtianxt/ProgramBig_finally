<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>首页</title>
<!--引入的外部CSS样式s文件-->
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--引入的外部JS脚本文件-->
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/jump.js"></script>

</head>

<body>
	<h1 align="center">《算法与数据结构综合训练(A)》第一阶段：基本算法演示程序</h1>
	<br>
	<p align="center">
		<a href="index.jsp">回到首页</a>
	</p>
	<hr>
	<div id="nav" class="nav">
		<ul style="position: absolute;">
			<li onmouseover="showsub(this)" onmouseout="hidesub(this)"><a
				href="#">王志伟</a>
				<ul>
					<li><a id="wzw_kmp" onclick="test()">KMP 模式匹配算法 </a></li>
					<li><a id="wzw_hfm" onclick="test()">哈夫曼编码算法 </a></li>
					<li><a id="wzw_huf" onclick="test()">由遍历序列恢复二叉 </a></li>
					<li><a id="wzw_jsp" onclick="test()">基数排序 </a></li>
				</ul></li>

			<li onmouseover="showsub(this)" onmouseout="hidesub(this)"><a
				href="#">张浩</a>
				<ul>
					<li><a id="zh_pri" onclick="test()">Prim 算法 </a></li>
					<li><a id="zh_kru" onclick="test()">Kruskal 算法 </a></li>
					<li><a id="zh_flo" onclick="test()">Floyd 算法 </a></li>
					<li><a id="zh_dij" onclick="test()">Dijkstra 算法 </a></li>
				</ul></li>
			<li onmouseover="showsub(this)" onmouseout="hidesub(this)"><a
				href="#">刘雨鑫</a>
				<ul>
					<li><a id="lyx_tup" onclick="test()">拓扑排序 </a></li>
					<li><a id="lyx_gjl" onclick="test()">关键路径算法</a></li>
					<li><a id="lyx_scs" onclick="test()">二叉排序树生成算法 </a></li>
					<li><a id="lyx_hax" onclick="test()">哈希表生成哈希查找算法 </a></li>
				</ul></li>
			<li onmouseover="showsub(this)" onmouseout="hidesub(this)"><a
				href="#">高雪彤</a>
				<ul>
					<li><a id="gxt_xer" onclick="test()">希尔排序 </a></li>
					<li><a id="gxt_kpa" onclick="test()">快速排序 </a></li>
					<li><a id="gxt_dui" onclick="test()">堆排序 </a></li>
					<li><a id="gxt_gub" onclick="test()">归并排序 </a></li>
				</ul></li>
			<li onmouseover="showsub(this)" onmouseout="hidesub(this)"><a
				href="#">曾凯</a>
				<ul>
					<li><a id="zk_exp" onclick="test()">四则表达式计算 </a></li>
					<li><a id="zk_juz" onclick="test()">矩阵运算 </a></li>
					<li><a id="zk_qlt" onclick="test()">有向图的强连通分量求解 </a></li>
				</ul></li>
		</ul>
	</div>
	<div align="center">
		<iframe id="iframe" src="main.jsp" width="1200" height="500"></iframe>
	</div>
</body>
</html>
