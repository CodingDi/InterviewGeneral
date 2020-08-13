import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderII {

	public static void main(String[] args) {
		InOrderII test1=new InOrderII();
		int[] nums= {5,5};
		
	}
	private List<Integer> inOrder(TreeNode root){
		List<Integer> inOrder=new ArrayList<Integer>();
		if(root==null) {
			return inOrder;
		}
		Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
		TreeNode cur=root;
		while(!stack.isEmpty()||cur!=null) {
			if(cur!=null) {
				stack.offerFirst(cur);
				cur=cur.left;
			}else {
				cur=stack.pollFirst();
				inOrder.add(cur.key);
				cur=cur.right;
			}
		}
		
		return inOrder;
		
	}

}
