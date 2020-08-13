
public class ProductCuttingRope {

	public ProductCuttingRope() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		ProductCuttingRope test=new ProductCuttingRope();
		System.out.println(test.maxProduct(12));
	}
	public int maxProduct(int length) {
		/*idea: 
		 * recursively cut, from 2,we try different ways to cut the rope
		 * with array m,m[i]represents the max product with length i
		 * initialization:m[1]=0; we can't do any cut with less than 1
		 * induction rule: m[i]=max(j,m[j])*(i-j)  when 1<=j<i,so we have two parts for product
		 * max(j,m[j]) means we can either cut or directly use length j and do not cut.
		 * another part is(i-j)
		 * return:m[length] so we need a array of size length+1
		 */
		int[] m=new int[length+1];
		//initialization 
		m[1]=0;
		for(int i=2;i<=length;i++) {//a rope need cut should be at least 2 length
			for(int j=1;j<i;j++) {//we see where to cut for length i
				m[i]=Math.max(m[i], Math.max(j, m[j])*(i-j));//m[j] is where we can check what we've done befoere
 			}
			
		}
		return m[length];
		
	}

}
