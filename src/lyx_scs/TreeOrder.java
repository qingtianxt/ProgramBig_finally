package lyx_scs;

import java.util.Stack;

public class TreeOrder {
	private static String pre="";
	 public static String preOrderMethodOne(TreeNode treeNode) { 
		    if (null != treeNode) { 
		     pre+=treeNode.data + " "; 
		      if (null != treeNode.left) { 
		        preOrderMethodOne(treeNode.left); 
		      } 
		      if (null != treeNode.right) { 
		        preOrderMethodOne(treeNode.right); 
		  
		      } 
		    } 
		    return pre;
		  } 
		  
		
		    
		  /** 
		   * 递归实现中序遍历 
		   * @param treeNode 
		   */
	 private static String in="";
		  public static String medOrderMethodOne(TreeNode treeNode){ 
		    if (null != treeNode) {      
		      if (null != treeNode.left) { 
		        medOrderMethodOne(treeNode.left); 
		      } 
		     in+=treeNode.data + " "; 
		      if (null != treeNode.right) { 
		        medOrderMethodOne(treeNode.right); 
		      } 
		    } 
		      return in;
		  } 
		    
		  
		    
		  /** 
		   * 递归实现后序遍历 
		   * @param treeNode 
		   */
		  private static String pos="";
		  public static String postOrderMethodOne(TreeNode treeNode){     
		    if (null != treeNode) {    
		      if (null != treeNode.left) { 
		        postOrderMethodOne(treeNode.left); 
		      } 
		      if (null != treeNode.right) { 
		        postOrderMethodOne(treeNode.right); 
		      } 
		      pos+=treeNode.data + " "; 
		    } 
		      return pos;
		  } 
}
