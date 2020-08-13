import java.util.*;
public class ReconstructWithLevelandInorder {
	/*
	 * Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
	 */
	public ReconstructWithLevelandInorder() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 	idea: for levelOrder,each first element in the array is its root.
	 * we get the index of the root from inOrder,each number in levelOrder's index smaller than it is leftSubtree
	 * else is rightSubtree.
	 * do this recursively by call helper function
	 */
	public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
		//:use a map to map the index and its element Map<key=number,value=index>
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<inOrder.length;i++) {
			map.put(inOrder[i],i);
		}
		//construct live for level Order
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<levelOrder.length;i++) {
			list.add(levelOrder[i]);
		}
		return construct(map,list);
		
	}
	
	private TreeNode construct(Map<Integer,Integer> map,List<Integer> list) {
		TreeNode root=new TreeNode(list.remove(0));
		int index=map.get(root.key);
		List<Integer> left=new ArrayList<Integer>();
		List<Integer> right=new ArrayList<Integer>();
		for(Integer num:list) {
			if(map.get(num)<index) {
				left.add(num);
			}else {
				right.add(num);
			}
		}
		root.left=construct(map,left);
		root.right=construct(map,right);
		return root;
	}

}
