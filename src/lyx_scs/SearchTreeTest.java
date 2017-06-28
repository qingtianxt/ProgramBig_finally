package lyx_scs;

public class SearchTreeTest {
	public static void main(String[] args) { 
	    SearchTree tree = new SearchTree(); 
//	    tree.addTreeNode(50); 
//	    tree.addTreeNode(80); 
//	    tree.addTreeNode(20); 
//	    tree.addTreeNode(60);   
//	    tree.addTreeNode(10); 
//	    tree.addTreeNode(30); 
//	    tree.addTreeNode(70); 
//	    tree.addTreeNode(90);   
//	    tree.addTreeNode(100); 
//	    tree.addTreeNode(40); 
	    tree.addTreeNode(12); 
	    tree.addTreeNode(24);
	    tree.addTreeNode(90);
	    tree.addTreeNode(45); 
	    tree.addTreeNode(24); 
	    tree.addTreeNode(53); 
	    tree.addTreeNode(45);   
	 
	    System.out.println("=============================="+"采用递归的前序遍历开始"+"=============================="); 
	    System.out.println(TreeOrder.preOrderMethodOne(tree.root)); 
	    System.out.println(); 
	    
	    System.out.println("=============================="+"采用递归的后序遍历开始"+"=============================="); 
	    System.out.println(TreeOrder.postOrderMethodOne(tree.root)); 
	    System.out.println(); 
	   
	    System.out.println("=============================="+"采用递归的中序遍历开始"+"=============================="); 
	   System.out.println(TreeOrder.medOrderMethodOne(tree.root));  
	    System.out.println(); 
	   
	  } 
	  
}
