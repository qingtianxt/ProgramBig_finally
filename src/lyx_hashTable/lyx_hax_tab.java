package lyx_hashTable;

public class lyx_hax_tab
{  
	public lyx_hax_tab(){
		
	}
private lyx_hax_dtl[] hashArray;    // 数组形式  
private int arraySize;           //哈希表的大小  
private lyx_hax_dtl nonItem;        // 删除数据时,将被删除的数据设为nonItem  
//-------------------------------------------------------------  
public lyx_hax_tab(int size)       //构造器，指定哈希表的大小  
   {  
   arraySize = size;  
   hashArray = new lyx_hax_dtl[arraySize];  
   nonItem = new lyx_hax_dtl(-1);   // 把nonItem的关键字设为-1  
   }  
//-------------------------------------------------------------  
public String displayTable()       //显示哈希表  
   {  
	String rs="";
   for(int j=0; j<arraySize; j++)  
      {  
      if(hashArray[j] != null)  
        rs+=hashArray[j].getKey() + " ";  
      else  
       rs+="** ";  //该位置没有存数据  ;
      } 
   return rs;
   }  
//-------------------------------------------------------------  
public int hashFunc(int key)  
   {  
   return key % arraySize;       // 哈希函数  
   }  
//-------------------------------------------------------------  
public String insert(lyx_hax_dtl item) // 插入数据  
// 默认表未满，事实上哈希表是不允许存满的，哈希表的大小比实际存储的数据数要大。  
   {  
   int key = item.getKey();      // 获取数据项的关键字，用于计算哈希值  
   int hashVal = hashFunc(key);  // 计算哈希值  
                                // 当前位置存有数据并且该数据未被删除  
   int z=0; //用来记录冲突的次数
   String rs="";//用来存取结果
   while(hashArray[hashVal] != null &&  hashArray[hashVal].getKey() != -1)  
      {
	   	  z++;
	   	  rs+=hashVal+"这个位置冲突,"+"冲突次数为:"+z+"查找下一个位置       ";
	      ++hashVal;                 // 查找下一个位置  
	      hashVal %= arraySize;      // 到达表的末尾时，hashVal值变成1,。构成循环，从而可以查找整个表  
      }  
   hashArray[hashVal] = item;    // 找到位置  
   rs+="找到位置："+hashVal;
   return rs;
   }  // end insert()  
//-------------------------------------------------------------  
public lyx_hax_dtl delete(int key)  // 根据关键字删除数据  
   {  
   int hashVal = hashFunc(key);  // 根据关键字计算哈希值  
  
   while(hashArray[hashVal] != null)  // 该位置存有数据  
      {                               // 两者的关键字是否相同  
      if(hashArray[hashVal].getKey() == key)  
         {  
         lyx_hax_dtl temp = hashArray[hashVal]; // 保存删除的数据项，用于返回  
         hashArray[hashVal] = nonItem;       // 删除  
         return temp;                        // 返回删除的数据项  
         }  
      ++hashVal;                 // 关键字不相同，继续查找下一个  
      hashVal %= arraySize;      //循环  
      }  
   return null;                  // 未找到  
   }  // end delete()  
//-------------------------------------------------------------  
public lyx_hax_dtl find(int key)    // 表中是否存在该关键字的数据项  
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