package zh;

public class Prim_text {
	
	
	
	 
	 public String prim(int n,int [][]w)
	 {
		 String a="";
		 int verNum = w.length;        //顶点个数
		 int []lowerW = new int[verNum];    //顶点数组
		 int []edge = new int[verNum];        //边数组
		 boolean []checked = new boolean[verNum];  //判断是否访问
		  checked[1]=true;            //抽取第一个顶点	  
		  for(int i=1; i<=n; i++)
		  {          
			  lowerW[i] = w[1][i];          //初始化顶点集合，第一顶点到各个点的距离
			  edge[i] = 1;
			  checked[i] = false;
		  }
		  
		  for(int i=1;i<=n;i++)
		  {	  
			  int min=Integer.MAX_VALUE;
			  int j=1;
			  for(int k=2;k<=n;k++)
			  {        
				  if(lowerW[k] < min && (!checked[k]))   //判断改点是否可达和是否抽取该顶点
				  {
					  min = lowerW[k];          //将最小距离的赋给min，直到找到最小的距离，
					  j = k;                   //j是找出的与当前i顶点距离最小的顶点
				  }
			  }
			  
			  if(i < n)                //避免输出第一个顶点到第一个顶点的情况
			  {
				  System.out.println(j + "-->" + edge[j]);
				  a+=j + "-->" + edge[j]+"     ";
			  }
		    
			  checked[j] = true;           //将顶点加入到新集合中，说明该顶点已被访问过
		     
			  for(int k = 2 ; k<=n ; k++)
			  {        //根据新加入的顶点，求得最小的权值
				  if((w[j][k] < lowerW[k] ) && ( !checked[k] ))
				  {
					  lowerW[k] = w[j][k];           //将刚连接的那个顶点,距离各顶点的值赋给lowerW[]
					  edge[k] = j;				   
				  }
			  }
			 
		  }
		  return a;
	}

}
