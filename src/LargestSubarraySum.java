
public class LargestSubarraySum {

	public LargestSubarraySum() {
		// TODO Auto-generated constructor stub
	}
	
	
	/*idea:starts form 0 to the end of the array,we see if previous sum in total is larger than 0
	 * case1:if yes,add cur to the sum;
	 * case2:if its less than zero,we ignore it and add the cur number as sum
	 * update global max if necessary
	 * use a max to record the largest sum in the global range.
	 * use a sum int to record the largest sum includes cur number
	 *  for each numbers in the array,if(sum<0) sum=cur;because previous sum is less then 0,we ignore it;
	 *  otherwise if sum>0,sum+=array[i]
	 * 
	 * */
	public int largest(int[] array) {
		if(array==null||array.length==0) return 0;
		//initialization
		int max=array[0];
		int sum=array[0];
		for(int i=1;i<array.length;i++) {
			if(sum>0) {
				sum+=array[i];
				
			}else {
				sum=array[i];
			}
			max=Math.max(max, sum);//for both case we need to update,because either case may lead to max change
		}
		return max;
	}
	

}
