package zh;

public class Kruskal_text {
	
	
	public static String kruskal(int[][] arcs) {
		
		String a = "";
		//顶点个数
		int num = arcs.length;
		//存放对应顶点所在连通图标识
		int[] group = new int[num];   //自动赋值为0
		
		int n1 = 0, n2 = 0;
		boolean finished = false;
		int groupNum = 1;

		while(!finished) 
		{
			int min = Integer.MAX_VALUE;
			
			//找出所有边中的最小值
			for(int i = 0; i < num; i++) 
			{
				for(int j = i+1; j < num; j++) 
				{
					if(arcs[i][j] > 0 && arcs[i][j] < min)
					{
						//如果group相同，则表示处理过，不相同或都为0都表示没处理过
						if (group[i] != group[j] || (group[i] == 0 && group[j] == 0)) 
						{
							min = arcs[i][j];     //找到距离最小的两个顶点
							n1 = i;
							n2 = j;    
						}                                            
					}
				}
			}
	    
			if(min == Integer.MAX_VALUE)
			{
				continue;        //距离不可达，则继续
			}
	    
			System.out.println(n1 + " ---> " + n2 + " " + min);
			a+= n1 + " ---- " + n2 + "    ";
	    
			
			if(group[n1] == 0 && group[n2] == 0)//如果两个都没被处理，设置连通标记，标记为同一个数
			{
				group[n1] = groupNum;
				group[n2] = groupNum;
				groupNum++;
			}
			else if(group[n1] > 0 && group[n2] > 0)  //连接两点，如果两个顶点都分别连接其他点，把两个顶点的值赋成同一个数；
			{
				int tmp = group[n2];
				for(int m = 0; m < group.length; m++)
				{
					if(group[m] == tmp)
					{
						group[m] = group[n1];
					}
				}
			}
			else                                    //如果一个数是0，一个不是，则把是0的顶点赋成不是0的那个
			{
				if(group[n1] == 0)
				{
					group[n1] = group[n2];
				}
				else
				{
					group[n2] = group[n1];
				}
			}
	    
			for(int i = 0; i < group.length; i++) 
			{
				if(group[i] != group[0])
				{
					finished = false;
					break;
				}
				else
				{
					finished = true;
				}
			}
	    
			if(finished) 
			{
				break;
			}
		}
		return a;
	}

}
