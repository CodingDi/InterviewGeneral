
public class LargestSubarraySumQuiz {
/*
 * Given an unsorted integer array, find the subarray that has the greatest sum.
 * Return the sum and the indices of the left and right boundaries of the subarray. 
 * If there are multiple solutions, return the leftmost subarray.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestSubarraySumQuiz test=new LargestSubarraySumQuiz();
		int[] array=new int[] {2, -1, 4, -2, 1};
		System.out.println(test.largestSum(array));
	}
	/*
	 * idea:for each number in the array,we want to know the previous sum before it,if previous sum >0,we add the two;
	 * otherwise,we restart the sum from current; and we need to a index of left bound and right bound(current idnex i)
	 * implementation:an array of sum[] sum[i] represents current max subarray includes array[i]
	 */
	public int[] largestSum(int[] array) {
		//assumption:the input is now null and length larger than 1,
		//all numbers are integers
		int globalLeft=0;//records the left bound we need to return
		int globalRight=0;
		int curLeft=0;
		int[] sum=new int[array.length];
		sum[0]=array[0];//initialization
		int max=sum[0];//global max
		
		for(int i=1;i<array.length;i++) {
			if(sum[i-1]>0) {
				sum[i]=sum[i-1]+array[i];
			}else {
				curLeft=i;//reset left
				sum[i]=array[i];
			}
			
			if(max<sum[i]) {
				globalLeft=curLeft;
				globalRight=i;
				max=sum[i];
				
			}
			
		}
		int[] res=new int[3];
		res[0]=max;
		res[1]=globalLeft;
		res[2]=globalRight;
		return res;
	}

}
