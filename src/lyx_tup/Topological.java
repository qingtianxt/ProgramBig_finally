package lyx_tup;

/*
 * 1. ��ظ������
���������Ƕ�������Ȧͼ�����һ������ʹ�ô���һ��vi��vj�ıߣ���ô��������vi������vj��ǰ�档
2. �㷨����
���Ҫ�Ե�������������������ȿ����ҵ����Ϊ0�ĵ㣬ɾ�������Ҹ�����ָ��ڵ����ȡ�
�������ҵ����Ϊ��ĵ㣬���Բ���ѭ�����������Ӷ�Ϊo(V^2)�������ǲ������ȼ����У������Ϊ0�ĵ������У�����ȡ����ӣ�Ȼ���Ӷ�Ϊ0(E+V).
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
    	System.out.println("�������һ���������ź����");
        Vertex v1=new Vertex(sc.next());
        v1.indegree=sc.nextInt();
        */
    	/*System.out.println("������ڶ����������ź����");
        Vertex v2=new Vertex(sc.next());
        v2.indegree=sc.nextInt();
    	
    	System.out.println("������������������ź����");
        Vertex v3=new Vertex(sc.next());
        v3.indegree=sc.nextInt();
    	
    	System.out.println("��������ĸ��������ź����");
        Vertex v4=new Vertex(sc.next());
        v4.indegree=sc.nextInt();
        
    	System.out.println("�����������������ź����");
        Vertex v5=new Vertex(sc.next());
        v5.indegree=sc.nextInt();
     
    	System.out.println("������������������ź����");
        Vertex v6=new Vertex(sc.next());
        v1.indegree=sc.nextInt();
 
    	System.out.println("��������߸��������ź����");
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
    
    //��ʼ�����ݣ��������ݣ�
    public static void init(){
    	vs=new ArrayList<Vertex>();
    	Scanner scan = new Scanner(System.in);
    	System.out.println("�����붥�������");
    	int n = scan.nextInt();
    	for(int i = 0;i < n;i++){
    		System.out.print("�������" + (i + 1) + "���������ƣ�");
    		String name = scan.next();
    		Vertex v=new Vertex(name);
    		vs.add(v);
    	}
    	System.out.println("������ߵĸ�����");
    	n = scan.nextInt();
    	for(int i = 0;i < n;i++){
    		System.out.println("�������" + (i + 1) + "���ߵ�ʼ����յ������");
    		String b = scan.next();
    		String e = scan.next();
    		int bn = setChild(b,e);
    		if(bn == 0){
    			System.out.println("������������������������룡");
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
//    			System.out.println("������������������������룡");
//    			i--;
//    			continue;
//    		}
		}
	}
	
    
    public static void topsort()  
    {  
        //��¼���Ϊ0�Ķ���  
        Queue<Vertex> queue=new LinkedList<Vertex>();  
          int count=0;  
        //���ȳ�ʼ������  
        for(Vertex v:vs)  
        {  
            if(v.indegree==0)  
                queue.add(v);  
        }  
        //���δӶ�����ȡ���ڵ㣬�������ڽӽڵ�����  
        while(!queue.isEmpty())  
        {  
            Vertex v=queue.poll();  
            v.topNum=++count;  
         /*   System.out.println(v.getName()+" "+v.getTopNum()); */ 
             
//            if(count!=vs.size())  
//            {  
//                System.out.println("ͼ��Ȧ");  
//            }
//            if(count==vs.size())
//            {
//            	System.out.println("ΪAOV��");
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
            System.out.println("ͼ��Ȧ");  
        }
        if(count==vs.size())
        {
        	type = 1;
        	System.out.println("ΪAOV��");
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