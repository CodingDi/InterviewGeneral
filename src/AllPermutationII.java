import java.util.*;
public class AllPermutationII {

	public AllPermutationII() {
		// TODO Auto-generated constructor stub
	}
	/*idea:for each char in the input,fix one,and swap it with the right side chars one by one
	 * also,for deduplication, we need to use a hashset each level.
	 * use a helper function,each level,we need to call once. 
	 * recursion tree: each level for one position of a char,one side be add cur char,another side be not add
	 * */
	public List<String> permutations(String input){
		List<String> res=new ArrayList<String>();
		if(input==null||input.length()==0) {
			res.add(input);
			return res;
		}
		
		return res;
	}
	private void helper(char[] array,int index,List<String> res) {
		//base case
		if(index==array.length) {
			res.add(new String(array));
			return;
		}
		//recursion rule
		Set<Character> set=new HashSet<Character>();
		for(int i=index;i<array.length;i++) {
			if(set.add(array[i])) {
				swap(array,index,i);
				helper(array,index+1,res);
				swap(array,index,i);
			}
		}
	}
	private void swap(char[] array,int a,int b) {
		char temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}

}
