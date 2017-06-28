package wzw_huf;
//solution类，根据中序和后序遍遍历二叉树
public class wzw_huf_restore1 {
	public static wzw_huf_TreeNode reConstructBinaryTree(int in[],int []post)
	{
		if(post==null&&in==null){
			return null;
		}
		wzw_huf_TreeNode mm = reConstructBinaryTreeCore(in,post,0,in.length-1,0,post.length-1);
		return mm;
	}

	private static wzw_huf_TreeNode reConstructBinaryTreeCore(int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd) {
		wzw_huf_TreeNode tree = new wzw_huf_TreeNode(post[postEnd]);
		tree.left=null;
		tree.right=null;
		if(inStart==inEnd&&postStart==postEnd){
			return tree;
		}
		int root = postEnd-1;
		for(root = inStart;root<inEnd;root++)
		{
			if(post[postEnd]==in[root])
			{
				break;
			}
		}
		int leftlength =root - inStart; 
		int rightlength =inEnd-root;
		if(leftlength>0){
			tree.left=reConstructBinaryTreeCore(in, post, inStart, root-1, postStart, postStart+leftlength - 1);
		}
		if(rightlength>0)
		{
			tree.right=reConstructBinaryTreeCore(in, post, root+1, inEnd, postStart+leftlength, postEnd-1);
		}
		 return tree;
	}
	private static String ft="";
	 public static String preTraverseBinTree(wzw_huf_TreeNode node){
	        if (node==null) {
	        		ft="这个二叉树为空";
	              return ft;
	          }
	         ft+=node.val+",";
	        if (node.left!=null) {
	            preTraverseBinTree(node.left);
	          }
	        if(node.right!=null){
	            preTraverseBinTree(node.right);
	        }
	        return ft;
	      }
	    //将二叉树中序遍历，用于测试结果
	 private static String zx="";
	    public static String inTraverseBinTree(wzw_huf_TreeNode node){
	        if (node==null) {
	        	zx="这个二叉树为空";
	              return zx;
	          }
	        if (node.left!=null) {
	            inTraverseBinTree(node.left);
	          }
	        zx+=node.val+",";
	        if(node.right!=null){
	            inTraverseBinTree(node.right);
	        }
	        return zx;
	      }
	    private static String hx="";
	  //将二叉树后序遍历，用于测试结果
	    public static String postTraverseBinTree(wzw_huf_TreeNode node){
	        if (node==null) {
	        	hx="这个二叉树为空";
	              return hx;
	          }
	        if (node.left!=null) {
	            postTraverseBinTree(node.left);
	          }
	        if(node.right!=null){
	            postTraverseBinTree(node.right);
	        }
	        hx+=node.val+",";
	        return hx;
	      }
	      //主函数，用于测试结果
	    public static void main(String[] args){
//	        int pre[] = {1,2,4,7,3,5,8,9,6};
//	        int in[]  = {4,7,2,1,8,5,9,3,6};
//	        int post[] ={7,4,2,8,9,5,6,3,1};
	    	int pre[] = {1,2,8,7,3,4,5,6,9};
	        int in[]  = {8,2,7,1,5,4,6,3,9};
	        int post[] ={8,7,2,5,6,4,9,3,1};
	        wzw_huf_TreeNode tree = reConstructBinaryTree(in,post);
	        System.out.print("先序遍历结果:  {");
	        System.out.println("1     " + preTraverseBinTree(tree));
	        System.out.println(ft);
	        System.out.println("}");
	        System.out.print("中序遍历结果:  {");
	        System.out.println("1   " + inTraverseBinTree(tree));
	        System.out.println(zx);
	        System.out.println("}");
	        System.out.print("后序遍历结果:  {");
	        System.out.println("1   " + postTraverseBinTree(tree));
	        System.out.println(hx);
	        System.out.println("}");
	    }
}