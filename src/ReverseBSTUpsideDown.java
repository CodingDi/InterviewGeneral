
public class ReverseBSTUpsideDown {

	public ReverseBSTUpsideDown() {
		// TODO Auto-generated constructor stub
	}
	
	
	//recursive way
	
	   public TreeNode reverse(TreeNode root) {
	 
		/*except subproblem,we need to do 4 things:
		 * 1. root.lchild.lchild=root;
		 * 2.root.lchild.rchild=root.rchild;
		 * 3.root.lchild==null
		 * 4.root.rchild=null
		 * 
		 * subproblem:do the same thing for root's left child
		*/
		
		if(root==null) {
			return root;
		}
		TreeNode newRoot=reverse(root.left);
		root.left.left=root;
		root.left.right=root.right;
		root.left=null;
		root.right=null;
		return newRoot;
	}

     

}
