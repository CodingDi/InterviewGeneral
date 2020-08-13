
public class LongestConsecutiveOnes {

	public LongestConsecutiveOnes() {
		// TODO Auto-generated constructor stub
	}
	/*IDEA:
	 * from the begin to the end,
	 * case1:cur==1,count++, update max if necessary
	 * case2:cur==0,case2.1 if credit >0,count++,credit--;
	 *              case2.2 no credit,check if left side pointer is 0,if yes,credit++,move pointers
	 * 
	 * */
	public int longestConsecutiveOnes(int[] nums, int k) {
		int right=0;
		int left=0;
		int credit=k;
		int max=0;
		while(right<nums.length){
			if(nums[right]==1) {
				right++;
				max=Math.max(right-left, max);
			}else {
				if(credit>0) {
					credit--;
					right++;
					max=Math.max(right-left, max);
				}else if(nums[left]==0) {
					credit++;
				}
			}
		}
		return max;
		
	}
	

}
