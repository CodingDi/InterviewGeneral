
public class MaxProductCuttingRope {
	/*
	 * Given a rope with positive integer-length n, how to cut the rope into m integer-length parts 
	 * with length p[0], p[1], ...,p[m-1], 
	 * in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you 
	 * and must be greater than 0 (at least one cut must be made). 
	 * Return the max product you can have.
	 */
	public MaxProductCuttingRope() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * dynamic programming: use an array to indicates the max product 
	 * m[i] represents the max product with length i
	 * induction rule: for(0,i-1) we try Math.max(j,m[j])*(i-j) for each j,and we need to update m[i]=Math.max(m[i],xxx)
	 * initialization:m[1]=0
	 */
	public int maxProduct(int length) {
		int[] m=new int[length+1];
		m[1]=0;
		for(int i=2;i<=length;i++) {
			for(int j=1;j<i;j++) {
				int cur=Math.max(j, m[j])*(i-j);
				m[i]=Math.max(m[i], cur);
			}
		}
		return m[length];
	}

}
