package lyx_scs;

public class TreeNode {
	 public Integer data; 
	    
	  /*�ýڵ�ĸ��ڵ�*/ 
	  public TreeNode parent; 
	    
	  /*�ýڵ�����ӽڵ�*/ 
	  public TreeNode left; 
	    
	  /*�ýڵ�����ӽڵ�*/
	  public TreeNode right; 
	    
	  public TreeNode(Integer data) { 
	    this.data = data; 
	      
	  } 
	  
	  @Override
	  public String toString() { 
	    return "TreeNode [data=" + data + "]"; 
	  } 
}
