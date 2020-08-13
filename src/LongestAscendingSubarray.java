
public class LongestAscendingSubarray {

	public LongestAscendingSubarray() {
		
		// TODO Auto-generated constructor stub
		/*dynamic programming:  
		 * do dp[i]=dp[i-1]+1 if array[i]>array[i-1] where dp[i] denores the longest subarray contains array[i]
		 * else dp[i]=1 if array[i]<=array[i-1]
		 * here we can make dp[i] as a j since we only need the most recent dp,so we can ignore the array space
		 * j:the longest subarray length includes array[j]
		*/
	}
	public static void main(String[] args) {
		LongestAscendingSubarray test=new LongestAscendingSubarray();
		int[] nums1= {1,2,2,3,3,4,5,6,6,7};
		int[] nums2= {1,2,3,3,4,4,5};
		System.out.println(test.longest(nums1));
		System.out.println(test.longest(nums2));
		
		
	}
	private int longest(int[] array) {
		if(array==null||array.length==0) return 0;
		int j=1;
		int max=1;
		for(int i=1;i<array.length;i++) {
			if(array[i]> array[i-1]) {
				j=j+1;
				max=Math.max(max, j);
			}else {
				j=1;
			}
		}
		return max;
		
	}

}
