package lyx_scs;

public class SearchTree {
	 public TreeNode root; 
     
	   public long size; 
	      
	  /** 
	   * �����мӽڵ�  
	   * @param data 
	   * @return Boolean ����ɹ�����true 
	   */
	  public String addTreeNode(Integer data) { 
	  String rs="";
	    if (null == root) { 
	      root = new TreeNode(data); 
	     rs+="����"+data+"�ɹ����뵽ƽ���������"; 
	      return rs; 
	    } 
	  
	    TreeNode treeNode = new TreeNode(data);// ��������������� 
	    TreeNode currentNode = root; 
	    TreeNode parentNode; 
	  
	    while (true) { 
	      parentNode = currentNode;// ���游�ڵ� 
	      // ��������ݱȸ��ڵ�С 
	      if (currentNode.data > data) { 
	        currentNode = currentNode.left; 
	        // ��ǰ���ڵ�����ӽڵ�Ϊ�� 
	        if (null == currentNode) { 
	          parentNode.left = treeNode; 
	          treeNode.parent = parentNode; 
	          rs+="����"+data+"�ɹ����뵽�����������"; 
	          size++; 
	          return rs; 
	        } 
	        // ��������ݱȸ��ڵ�� 
	      } else if (currentNode.data < data) { 
	        currentNode = currentNode.right; 
	        // ��ǰ���ڵ�����ӽڵ�Ϊ�� 
	        if (null == currentNode) { 
	          parentNode.right = treeNode; 
	          treeNode.parent = parentNode; 
	          rs+="����"+data+"�ɹ����뵽�����������";
	          size++; 
	          return rs; 
	        } 
	      } else { 
	        System.out.println(""); 
	        rs+="����"+data+",����ʧ�ܣ�����������ڵ��������ͬ";
	        return rs; 
	      } 
	    }     
	  } 
	    
	  /** 
	   * @param data 
	   * @return TreeNode 
	   */
	  public TreeNode findTreeNode(Integer data){ 
	    if(null == root){ 
	      return null; 
	    } 
	    TreeNode current = root; 
	    while(current != null){ 
	      if(current.data > data){ 
	        current = current.left; 
	      }else if(current.data < data){ 
	        current = current.right; 
	      }else { 
	        return current; 
	      } 
	        
	    } 
	    return null; 
	  } 
}
