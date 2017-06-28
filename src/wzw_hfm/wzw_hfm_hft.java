package wzw_hfm;


public class wzw_hfm_hft {
	//���Ȩֵ
    static final int MAXVALUE=1000;
    int nodeNum ; //Ҷ�ӽ�����
    public wzw_hfm_hfn[] nodes;
    public wzw_hfm_cod[] haffCode;
    
    public wzw_hfm_hft(int n)
    {
       this.nodeNum = n;
    }
    
    public static void main(String[] args) {
		wzw_hfm_hft t = new wzw_hfm_hft(8);
		int[] a = {5,29,7,8,14,23,3,11};
		t.haffman(a);
		t.haffmanCode();
		wzw_hfm_hfn[] result = t.jieMa();
		for(int i = 0;i < result.length;i++){
			System.out.println(result[i].weight);
		}
		System.out.println("dd");
	}
    
    
    //������������㷨
    public void haffman(int[] weight)//Ȩֵ���飬���нڵ�����
    {
        int n = this.nodeNum;
        //m1,m2,��ʾ��С������Ȩֵ��x1,x2,��ʾ��С����Ȩֵ��Ӧ�ı��,m1��ʾ��С��m2��ʾ��С
        int m1,m2,x1,x2; 
        
        nodes = new wzw_hfm_hfn[weight.length * 2 - 1];
        
        //��ʼ�����еĽ�㣬��Ӧ��n��Ҷ�ӽ��Ĺ�����������2n-1����㡣
        for(int i=0;i < 2*n-1;i++)
        {
        	wzw_hfm_hfn temp = new wzw_hfm_hfn();
            //��ʼ��n��Ҷ�ӽ�㣬��������Ľڵ㡣0��1��2��3��Ҷ�ӽڵ�Ҳ������Ľڵ�
            if(i < n)
            {
               temp.weight = weight[i];    
            }
            else
            {
               temp.weight = 0;    
            }
            temp.parent = 0;
            temp.flag = 0;
            temp.leftChild = -1;
            temp.rightChild = -1;
            nodes[i] = temp;
        }
        
        for(int i=0;i<n-1;i++){//��ʼ��n-1����Ҷ�ӽ�㣬n-1��ʾҪѭ��n-1�����n-1������
           m1 = m2 = MAXVALUE;
           x1 = x2 =0;
           for(int j=0;j< n+i;j++)//�����n-1����ʱ��ÿ�ζ��Ǵ�0��n+i-1,����flag=0�ģ�flag=1��ʾ�Ѿ����뵽��������
           {   
        	   
        	   //����2�����ҳ�Ȩֵ��С��2��
               if(nodes[j].weight<m1 && nodes[j].flag==0)//if������else��else if�Ͳ���ȥ�ˡ�
               {
                //m1,x1��ʼֵΪ��һ��Ԫ�أ����������m1ҪС����m1ָ���С�ģ�ԭ��m1ָ���������m2ָ��
                //��������m1���m2С����m2ָ�������m1���m2С�ģ�
                //Ҳ����˵m1ָ����С�ģ�m2ָ���2С�ġ�
                  m2 = m1;
                  x2 = x1;
                  m1 = nodes[j].weight;
                  x1 = j;
               }
               else if(nodes[j].weight<m2 && nodes[j].flag ==0)
               {
                  m2 = nodes[j].weight;
                  x2 = j;
               }
           }
           //��Ȩֵ��С��2����ϳ�һ��2����
           nodes[x1].parent = n+i;
           nodes[x2].parent = n+i;
           nodes[x1].flag = 1;
           nodes[x2].flag = 1;
           nodes[n+i].weight = nodes[x1].weight + nodes[x2].weight;
           nodes[n+i].leftChild = x1;
           nodes[n+i].rightChild = x2;
        }
    }
    //�����������㷨
    public void haffmanCode()
    {
        int n = this.nodeNum;
        haffCode = new wzw_hfm_cod[n];//4
        int child,parent;
        
        for(int i=0;i<n; i++)//��ǰ��n������Ľڵ���б���
        {
        	wzw_hfm_cod code = new wzw_hfm_cod(n);
           code.start = n-1;//3
           code.weight = nodes[i].weight;//1
           child = i;//0
           parent = nodes[child].parent;
           //��Ҷ�ӽڵ������������ɱ��룬��ͼ���ɡ�
           while(parent!=0)
           {
              if(nodes[parent].leftChild == child)
              {
                  code.bit[code.start] = 0;
              }
              else
              {
                  code.bit[code.start] = 1;
              }
              
              code.start--; 
              child = parent;
              parent = nodes[child].parent;
           }
           haffCode[i] = code;
        }
    }
    
    
    public wzw_hfm_hfn jieMa(int n){
    	wzw_hfm_hfn tmp_node = nodes[nodes.length - 1];
    	
    	wzw_hfm_cod code = haffCode[n];
    	int i = code.start + 1;
    	while(i < code.bit.length){
    		if(code.bit[i] == 0){
    			tmp_node = nodes[tmp_node.leftChild];
    		}
    		else{
    			tmp_node = nodes[tmp_node.rightChild];
    		}
    		i++;
    	}
    	return tmp_node;
    }
    
    
    public wzw_hfm_hfn[] jieMa(){
    	wzw_hfm_hfn[] result = new wzw_hfm_hfn[haffCode.length];
    	for(int i = 0;i < haffCode.length;i++){
    		result[i] = jieMa(i);
    	}
    	return result;
    }
    
    
}


