import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNoDuplicate {

	public LongestSubstringNoDuplicate() {
		// TODO Auto-generated constructor stub
	}
	public int longest(String input) {
	    // Write your solution here
		/*idea:use a hashSet for deduplication
		 * use a count to records the global longest substring;
		 * a integer of cur: the longest subString includes char at index i
		 * for each char in the input,we need add it in the set
		 * case1: successful add->char is unique so fat, counter++,update max if necessary
		 * case2:failure->duplicated char exist,we need to remove char of left side from set,until no duplication,
		 * because we don't which repeats with cur char,we need always remove until done
		 * */
		if(input==null) return 0;
		int left=0;
		int right=0;
		int max=0;//max length of global
		Set<Character> set=new HashSet<Character>();
		while(right<input.length()) {
			if(set.add(input.charAt(right))) {
				right++;
				max=Math.max(max, right-left);
			}else {
				set.remove(input.charAt(left));
				left++;
			}
		}
		return max;
	  }

}
