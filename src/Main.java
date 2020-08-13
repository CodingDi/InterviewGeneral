
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		int[] nums1= {-2,1,-3,4,-1,2,1,-5,4};
		int[] nums2= {2, -1, 4, -2, 1};
		LargestSubarraySum test1=new LargestSubarraySum();
		System.out.println(test1.largest(nums1));
		System.out.println(test1.largest(nums2));
		
		
		ReverseWordsInSentenceI test2=new  ReverseWordsInSentenceI();
		String s1="A B C D";
		System.out.println(test2.reverseWords(s1));
		NQueen test3=new NQueen();
		System.out.println(test3.nqueens(4));//[[1,3,0,2],[2,0,3,1]]
		System.out.println(test3.nqueens(8));
		
		AbbreviationMatch test4=new AbbreviationMatch();
		test4.match("laioffercom", "6er3");
	}

}
