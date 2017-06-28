package zk_diGraph;
import java.util.ArrayList;  
import java.util.List;  

  
public class Main {  
    public static void main(String[] args) {  
                //����ͼ  
        int numOfNode = 7;  //�����
        List< ArrayList<Integer> > graph = new ArrayList<ArrayList<Integer>>();  
        for(int i=0;i<numOfNode;i++){  
            graph.add(new ArrayList<Integer>());  
        }  
        graph.get(1).add(2);  
        graph.get(1).add(3);  
        graph.get(3).add(5);  
        graph.get(3).add(4);  
        graph.get(2).add(4);  
        graph.get(4).add(1);  
        graph.get(5).add(6);  
        graph.get(4).add(6);  
        //����Tarjan�㷨�󼫴���ͨ��ͼ  
        Tarjan t = new Tarjan(graph, numOfNode);  
        List< ArrayList<Integer> > result = t.run();  
                //��ӡ���  
        for(int i=1;i<result.size();i++){  
            for(int j=0;j<result.get(i).size();j++){  
                System.out.print(result.get(i).get(j)+" ");  
            }  
            System.out.println();  
        }  
          
    }  
}  

