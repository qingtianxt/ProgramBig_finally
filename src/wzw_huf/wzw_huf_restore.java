package wzw_huf;
//solution类，实现重建二叉树
public class wzw_huf_restore {
	 //根据先序和中序遍历找回二叉树主功能函数
	public static wzw_huf_TreeNode reConstructBinaryTree(int in[],int []post)
	{
		if(post==null&&in==null){
			return null;
		}
		wzw_huf_TreeNode mm = reConstructBinaryTreeCore(in,post,0,in.length-1,0,post.length-1);
		return mm;
	}
	 //核心递归
	private static wzw_huf_TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
		wzw_huf_TreeNode tree = new wzw_huf_TreeNode(pre[preStart]);
		tree.left=null;
		tree.right=null;
		if(preStart == preEnd &&inStart == inEnd){//递归结束条件
			return tree;
		}
		int root = 0;//是用来记录先序序列和中序序列中相同值的下标,找到中序遍历中根节点的位置
		for(root = inStart;root<inEnd;root++){
			if(pre[preStart]==in[root]){//如果先序序列和中序序列中的值相同，则停止循环
				break;
			}
		}
		int leftlength =root - inStart; //把中序序列分成两个部分，分别记录两个的
		int rightlength =inEnd-root;
		if(leftlength>0){
			tree.left =reConstructBinaryTreeCore(pre, in, preStart+1, preStart+leftlength, inStart, root-1);
		}
		if(rightlength>0){
			tree.right =reConstructBinaryTreeCore(pre, in, preStart+1+leftlength, preEnd,root+1,inEnd);
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

	    	int pre[] = {1,2,8,7,3,4,5,6,9};
	        int in[]  = {8,2,7,1,5,4,6,3,9};
	        int post[] ={8,7,2,5,6,4,9,3,1};
//		        int []pre={1,2,4,5,3,};
//		    	int[]in={4,2,5,1,3};
//		    	int []post={4,5,2,3,1};
		        wzw_huf_TreeNode tree = reConstructBinaryTree(pre,in);
		        System.out.print("先序遍历结果: ");
		        String ft1= preTraverseBinTree(tree);
		        System.out.println(ft1);
		        System.out.print("中序遍历结果: ");
		        String zx1=inTraverseBinTree(tree);
		        System.out.println(zx1);
		        System.out.print("后序遍历结果: ");
		        String hx1=postTraverseBinTree(tree);
		        System.out.println(hx1);
	    }
}
