package wzw_huf;
//solution�࣬ʵ���ؽ�������
public class wzw_huf_restore {
	 //�����������������һض����������ܺ���
	public static wzw_huf_TreeNode reConstructBinaryTree(int in[],int []post)
	{
		if(post==null&&in==null){
			return null;
		}
		wzw_huf_TreeNode mm = reConstructBinaryTreeCore(in,post,0,in.length-1,0,post.length-1);
		return mm;
	}
	 //���ĵݹ�
	private static wzw_huf_TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
		wzw_huf_TreeNode tree = new wzw_huf_TreeNode(pre[preStart]);
		tree.left=null;
		tree.right=null;
		if(preStart == preEnd &&inStart == inEnd){//�ݹ��������
			return tree;
		}
		int root = 0;//��������¼�������к�������������ֵͬ���±�,�ҵ���������и��ڵ��λ��
		for(root = inStart;root<inEnd;root++){
			if(pre[preStart]==in[root]){//����������к����������е�ֵ��ͬ����ֹͣѭ��
				break;
			}
		}
		int leftlength =root - inStart; //���������зֳ��������֣��ֱ��¼������
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
	        		ft="���������Ϊ��";
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
	    //��������������������ڲ��Խ��
	 private static String zx="";
	    public static String inTraverseBinTree(wzw_huf_TreeNode node){
	        if (node==null) {
	        	zx="���������Ϊ��";
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
	  //��������������������ڲ��Խ��
	    public static String postTraverseBinTree(wzw_huf_TreeNode node){
	        if (node==null) {
	        	hx="���������Ϊ��";
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
	      //�����������ڲ��Խ��
	    public static void main(String[] args){

	    	int pre[] = {1,2,8,7,3,4,5,6,9};
	        int in[]  = {8,2,7,1,5,4,6,3,9};
	        int post[] ={8,7,2,5,6,4,9,3,1};
//		        int []pre={1,2,4,5,3,};
//		    	int[]in={4,2,5,1,3};
//		    	int []post={4,5,2,3,1};
		        wzw_huf_TreeNode tree = reConstructBinaryTree(pre,in);
		        System.out.print("����������: ");
		        String ft1= preTraverseBinTree(tree);
		        System.out.println(ft1);
		        System.out.print("����������: ");
		        String zx1=inTraverseBinTree(tree);
		        System.out.println(zx1);
		        System.out.print("����������: ");
		        String hx1=postTraverseBinTree(tree);
		        System.out.println(hx1);
	    }
}
