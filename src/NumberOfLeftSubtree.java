
public class NumberOfLeftSubtree {

	public NumberOfLeftSubtree() {
		// TODO Auto-generated constructor stub
	}
	/*recursion classic problem
	 * what do you want form child
	 * (1)total number of left child
	 * (2)total number of right child 
	 * 
	 * what do you want to do in the current layer:(1)
	 *  
	 * what do you want to presents for your parent:(1)+(2)
	 * */
	public void numNodesLeft(TreeNodeLeft root) {
		if(root==null) {
			return;
		}
		helper(root);
	
	}
	private int helper(TreeNodeLeft root) {
		if(root==null) {
			return 0;
		}
		int leftNumber=helper(root.left);
		int rightNumber=helper(root.right);
		root.numNodesLeft=leftNumber;
		return leftNumber+rightNumber+1;
	}

}
