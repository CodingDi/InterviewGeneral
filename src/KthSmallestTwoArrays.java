
public class KthSmallestTwoArrays {
/*
 * Given two sorted arrays of integers, find the Kth smallest number.

 */
	public KthSmallestTwoArrays() {
		// TODO Auto-generated constructor stub
	}
	public int kth(int[] a,int[] b,int k) {
		/*
		 * idea:use binary search tree for both arrays at the same time, each time we minimize the search space
		 * each time,we compare the mid value for both to decide which to explore next time 
		 * use a helper function to do search with specified start position for search space
		 */
		return kth(a,b,0,0,k);
		
	}
	private int kth(int[] a,int[] b,int aleft,int bleft,int k) {
		//base case,when the left bound is out of the array bound
		if(aleft>=a.length) {
			return b[bleft+k-1];
		}
		if(bleft>=b.length) {
			return a[aleft+k-1];
		}
		if(k==1) {
			return Math.min(a[aleft], b[bleft]);
		}
		//for other case,step,find the mid index
		int amid=aleft+k/2-1;
		int bmid=bleft+k/2-1;
		int aval=amid>=a.length?Integer.MAX_VALUE:a[amid];
		int bval=bmid>=a.length?Integer.MAX_VALUE:b[bmid];
		//case1:when a array is larger,we search b first 
		if(aval>bval) {
			return kth(a,b,aleft,bmid+1,k-k/2);
			
		}else {
			return kth(a,b,amid+1,bleft,k-k/2);
		}
		
	}

}
