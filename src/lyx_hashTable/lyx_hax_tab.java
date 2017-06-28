package lyx_hashTable;

public class lyx_hax_tab
{  
	public lyx_hax_tab(){
		
	}
private lyx_hax_dtl[] hashArray;    // ������ʽ  
private int arraySize;           //��ϣ��Ĵ�С  
private lyx_hax_dtl nonItem;        // ɾ������ʱ,����ɾ����������ΪnonItem  
//-------------------------------------------------------------  
public lyx_hax_tab(int size)       //��������ָ����ϣ��Ĵ�С  
   {  
   arraySize = size;  
   hashArray = new lyx_hax_dtl[arraySize];  
   nonItem = new lyx_hax_dtl(-1);   // ��nonItem�Ĺؼ�����Ϊ-1  
   }  
//-------------------------------------------------------------  
public String displayTable()       //��ʾ��ϣ��  
   {  
	String rs="";
   for(int j=0; j<arraySize; j++)  
      {  
      if(hashArray[j] != null)  
        rs+=hashArray[j].getKey() + " ";  
      else  
       rs+="** ";  //��λ��û�д�����  ;
      } 
   return rs;
   }  
//-------------------------------------------------------------  
public int hashFunc(int key)  
   {  
   return key % arraySize;       // ��ϣ����  
   }  
//-------------------------------------------------------------  
public String insert(lyx_hax_dtl item) // ��������  
// Ĭ�ϱ�δ������ʵ�Ϲ�ϣ���ǲ���������ģ���ϣ��Ĵ�С��ʵ�ʴ洢��������Ҫ��  
   {  
   int key = item.getKey();      // ��ȡ������Ĺؼ��֣����ڼ����ϣֵ  
   int hashVal = hashFunc(key);  // �����ϣֵ  
                                // ��ǰλ�ô������ݲ��Ҹ�����δ��ɾ��  
   int z=0; //������¼��ͻ�Ĵ���
   String rs="";//������ȡ���
   while(hashArray[hashVal] != null &&  hashArray[hashVal].getKey() != -1)  
      {
	   	  z++;
	   	  rs+=hashVal+"���λ�ó�ͻ,"+"��ͻ����Ϊ:"+z+"������һ��λ��       ";
	      ++hashVal;                 // ������һ��λ��  
	      hashVal %= arraySize;      // ������ĩβʱ��hashValֵ���1,������ѭ�����Ӷ����Բ���������  
      }  
   hashArray[hashVal] = item;    // �ҵ�λ��  
   rs+="�ҵ�λ�ã�"+hashVal;
   return rs;
   }  // end insert()  
//-------------------------------------------------------------  
public lyx_hax_dtl delete(int key)  // ���ݹؼ���ɾ������  
   {  
   int hashVal = hashFunc(key);  // ���ݹؼ��ּ����ϣֵ  
  
   while(hashArray[hashVal] != null)  // ��λ�ô�������  
      {                               // ���ߵĹؼ����Ƿ���ͬ  
      if(hashArray[hashVal].getKey() == key)  
         {  
         lyx_hax_dtl temp = hashArray[hashVal]; // ����ɾ������������ڷ���  
         hashArray[hashVal] = nonItem;       // ɾ��  
         return temp;                        // ����ɾ����������  
         }  
      ++hashVal;                 // �ؼ��ֲ���ͬ������������һ��  
      hashVal %= arraySize;      //ѭ��  
      }  
   return null;                  // δ�ҵ�  
   }  // end delete()  
//-------------------------------------------------------------  
public lyx_hax_dtl find(int key)    // �����Ƿ���ڸùؼ��ֵ�������  
   {  
   int hashVal = hashFunc(key);    
   
   while(hashArray[hashVal] != null)    
      {                                 
      if(hashArray[hashVal].getKey() == key)  
         return hashArray[hashVal];     
      ++hashVal;                
      hashVal %= arraySize;        
      }  
   return null;                  
   }  
//-------------------------------------------------------------  
} 