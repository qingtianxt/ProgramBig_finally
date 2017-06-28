package lyx_tup;

/*
 * 1. 相关概念介绍
拓扑排序是对有向无圈图顶点的一种排序，使得存在一条vi到vj的边，那么在排序中vi出现在vj的前面。
2. 算法分析
如果要对点进行拓扑排序，我们首先可以找到入度为0的点，删除，并且更新其指向节点的入度。
在这里找到入度为零的点，可以采用循环搜索，复杂度为o(V^2)，或者是采用优先级队列，把入度为0的点加入队列，依次取出添加，然后复杂度为0(E+V).
 */
import java.util.*;  
public class Topological {  
    
	static class Vertex  
    {  
        private String name;  
        private List<Vertex> children=new ArrayList<Vertex>();  
        private int topNum;  
        private int indegree;  
        Vertex(String name)  
        {  
            this.name=name;  
        }  
        public String getName() {  
            return name;  
        }  
        public void setName(String name) {  
            this.name = name;  
        }  
        public List<Vertex> getChildren() {  
            return children;  
        }  
        public void setChildren(List<Vertex> children) {  
            this.children = children;  
        }  
        public int getTopNum() {  
            return topNum;  
        }  
        public void setTopNum(int topNum) {  
            this.topNum = topNum;  
        }  
        public int getIndegree() {  
            return indegree;  
        }  
        public void setIndegree(int indegree) {  
            this.indegree = indegree;  
        }  
        public void vertex(String name,int indegree){
        	this.name=name;
        	this.indegree=indegree;
        }
    }  
    
    
    static List<Vertex> vs = null;
    static int type;
    
    public static void main(String args[])  
    {  
    	/*Scanner sc=new Scanner(System.in);
    	System.out.println("请输入第一个顶点的序号和入度");
        Vertex v1=new Vertex(sc.next());
        v1.indegree=sc.nextInt();
        */
    	/*System.out.println("请输入第二个顶点的序号和入度");
        Vertex v2=new Vertex(sc.next());
        v2.indegree=sc.nextInt();
    	
    	System.out.println("请输入第三个顶点的序号和入度");
        Vertex v3=new Vertex(sc.next());
        v3.indegree=sc.nextInt();
    	
    	System.out.println("请输入第四个顶点的序号和入度");
        Vertex v4=new Vertex(sc.next());
        v4.indegree=sc.nextInt();
        
    	System.out.println("请输入第五个顶点的序号和入度");
        Vertex v5=new Vertex(sc.next());
        v5.indegree=sc.nextInt();
     
    	System.out.println("请输入第六个顶点的序号和入度");
        Vertex v6=new Vertex(sc.next());
        v1.indegree=sc.nextInt();
 
    	System.out.println("请输入第七个顶点的序号和入度");
        Vertex v7=new Vertex(sc.next());
        v7.indegree=sc.nextInt(); 
*/
       
    	
    	
//    	Vertex v1=new Vertex("v1");
//        Vertex v2=new Vertex("v2");  
//        Vertex v3=new Vertex("v3");  
//        Vertex v4=new Vertex("v4");  
//        Vertex v5=new Vertex("v5");  
//        Vertex v6=new Vertex("v6");  
//        Vertex v7=new Vertex("v7");  
//        
//        v1.children.add(v2);  
//        v1.children.add(v3);  
//        v1.children.add(v4);  
//        v1.indegree=0;  
//        v2.children.add(v4);  
//        v2.children.add(v5);  
//        v2.indegree=1;  
//        v3.children.add(v6);  
//        v3.indegree=2;  
//        v4.children.add(v3);  
//        v4.children.add(v6);  
//        v4.children.add(v7);  
//        v4.indegree=3;  
//        v5.children.add(v4);  
//        v5.children.add(v7);  
//        v5.indegree=1;  
//        v6.indegree=3;  
//        v7.children.add(v6);  
//        v7.indegree=2;  
//    	
//
//        List<Vertex> vs=new ArrayList<Vertex>();  
//        vs.add(v1);  
//        vs.add(v2);  
//        vs.add(v3);  
//        vs.add(v4);  
//        vs.add(v5);  
//        vs.add(v6);  
//        vs.add(v7);  
    	init();
        topsort(); 
    }  
    
    
    public static int setChild(String b,String e){
    	Vertex ve = null;
    	for(Vertex v : vs){
    		if(v.getName().equals(e)){
    			ve = v;
    			break;
    		}
    	}
    	Vertex vb = null;
    	for(Vertex v : vs){
    		if(v.getName().equals(b)){
    			vb = v;
    			break;
    		}
    	}
    	
    	if(ve == null || vb == null){
    		return 0;
    	}
    	
    	vb.children.add(ve);
    	ve.indegree++;
    	return 1;
    }
    
    //初始化数据（输入数据）
    public static void init(){
    	vs=new ArrayList<Vertex>();
    	Scanner scan = new Scanner(System.in);
    	System.out.println("请输入顶点个数：");
    	int n = scan.nextInt();
    	for(int i = 0;i < n;i++){
    		System.out.print("请输入第" + (i + 1) + "个顶点名称：");
    		String name = scan.next();
    		Vertex v=new Vertex(name);
    		vs.add(v);
    	}
    	System.out.println("请输入边的个数：");
    	n = scan.nextInt();
    	for(int i = 0;i < n;i++){
    		System.out.println("请输入第" + (i + 1) + "条边的始点和终点的名称");
    		String b = scan.next();
    		String e = scan.next();
    		int bn = setChild(b,e);
    		if(bn == 0){
    			System.out.println("顶点名称输入错误，请重新输入！");
    			i--;
    			continue;
    		}
    		
    	}
    	scan.close();
    }
	
	public static void initjsp(String[] ves,String[] arcs){
		vs=new ArrayList<Vertex>();
		for(int i = 0;i < ves.length;i++){
			Vertex v=new Vertex(ves[i]);
    		vs.add(v);
		}
		for(int i = 0;i < arcs.length;i++){
			String[] a = arcs[i].split("#");
			int bn = setChild(a[0],a[1]);
//    		if(bn == 0){
//    			System.out.println("顶点名称输入错误，请重新输入！");
//    			i--;
//    			continue;
//    		}
		}
	}
	
    
    public static void topsort()  
    {  
        //记录入度为0的队列  
        Queue<Vertex> queue=new LinkedList<Vertex>();  
          int count=0;  
        //首先初始化队列  
        for(Vertex v:vs)  
        {  
            if(v.indegree==0)  
                queue.add(v);  
        }  
        //依次从队列中取出节点，并更新邻接节点的入度  
        while(!queue.isEmpty())  
        {  
            Vertex v=queue.poll();  
            v.topNum=++count;  
         /*   System.out.println(v.getName()+" "+v.getTopNum()); */ 
             
//            if(count!=vs.size())  
//            {  
//                System.out.println("图有圈");  
//            }
//            if(count==vs.size())
//            {
//            	System.out.println("为AOV网");
//            }
            
            for(Vertex w:v.getChildren())  
            {  
                if(--w.indegree==0)  
                {  
                    queue.add(w);  
                }  
            } 
            System.out.println(v.getName()+" "+v.getTopNum());
        }  
        if(count!=vs.size())  
        {  
        	type = 0;
            System.out.println("图有圈");  
        }
        if(count==vs.size())
        {
        	type = 1;
        	System.out.println("为AOV网");
        }
       
    }  
    
    
    public static String output(){
    	StringBuffer buffer = new StringBuffer();
    	if(type == 0){
    		buffer.append("0");
    	}
    	else{
    		buffer.append("1");
    		String[] a = new String[vs.size()];
    		for(Vertex v : vs){
    			a[v.topNum - 1] = v.name;
    		}
    		for(int i = 0;i < a.length;i++){
    			buffer.append("#" + a[i]);
    		}
    	}
    	return buffer.toString();
    }
}  