
public class ReverseBSTUpsideDownIterative {

	public ReverseBSTUpsideDownIterative() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 *                1
	 *              /   \
	 *             2      5
	 *            / \    / \
	 *           3   4
	 * */
	//iterayive way:自己悟把
	public TreeNode reverse(TreeNode root) {
		TreeNode prev=null;//initialization of what root's left,since left will always be the parent,its just named as prev,
		TreeNode prevRight=null;//initialization of root's right,its the prev's right after reverse
		while(root!=null) {
			TreeNode next=root.left;  //record 2
			TreeNode right=root.right;//record 5
			root.left=prev;           //1.left->null
			root.right=prevRight;     //1.right->null
			prev=root;                //prev=1      
			prevRight=right;          //prevRight=5
			root=next;                //root=2
			
			
		}
		return prev;
	
	}


}
