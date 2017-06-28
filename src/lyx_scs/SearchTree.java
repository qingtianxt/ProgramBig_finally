package lyx_scs;

public class SearchTree {
	 public TreeNode root; 
     
	   public long size; 
	      
	  /** 
	   * 往树中加节点  
	   * @param data 
	   * @return Boolean 插入成功返回true 
	   */
	  public String addTreeNode(Integer data) { 
	  String rs="";
	    if (null == root) { 
	      root = new TreeNode(data); 
	     rs+="数据"+data+"成功插入到平衡二叉树中"; 
	      return rs; 
	    } 
	  
	    TreeNode treeNode = new TreeNode(data);// 即将被插入的数据 
	    TreeNode currentNode = root; 
	    TreeNode parentNode; 
	  
	    while (true) { 
	      parentNode = currentNode;// 保存父节点 
	      // 插入的数据比父节点小 
	      if (currentNode.data > data) { 
	        currentNode = currentNode.left; 
	        // 当前父节点的左子节点为空 
	        if (null == currentNode) { 
	          parentNode.left = treeNode; 
	          treeNode.parent = parentNode; 
	          rs+="数据"+data+"成功插入到二叉查找树中"; 
	          size++; 
	          return rs; 
	        } 
	        // 插入的数据比父节点大 
	      } else if (currentNode.data < data) { 
	        currentNode = currentNode.right; 
	        // 当前父节点的右子节点为空 
	        if (null == currentNode) { 
	          parentNode.right = treeNode; 
	          treeNode.parent = parentNode; 
	          rs+="数据"+data+"成功插入到二叉查找树中";
	          size++; 
	          return rs; 
	        } 
	      } else { 
	        System.out.println(""); 
	        rs+="数据"+data+",插入失败，输入数据与节点的数据相同";
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
