
public class NiceTuple {
	
	/*
	 * code interview of Postmates from code Signal
	 */
	public int count(int[] nums) {
		int count = 0;
		for (int i = 1; i < nums.length -1; i++) {
		    if ((nums[i-1] == nums[i] && nums[i] != nums[i+1]) ||
		     (nums[i-1] != nums[i] && nums[i] == nums[i+1])||(nums[i-1]==nums[i+1]&&nums[i-1]!=nums[i])){
		        count++;
		    }
		}
		return count;
	}
	
	public static void main(String[] args) {
		NiceTuple test1=new NiceTuple();
		int[] nums=new int[] {4,6,4,1,3,4};
		int[] nums2=new int[] {4,4,6,1,2,2,2,3};
		System.out.println(test1.count(nums));
		System.out.println(test1.count(nums2));
	}
}
