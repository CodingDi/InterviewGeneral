
import java.util.*;
public class AddTwoNumbersNoCarry {
	public int[] addNoCarry(int[] one,int[] two) {
		
		if(one==null||one.length==0) {
			return two;
		}
		if(two==null||two.length==0) {
			return two;
		}
		List<Integer> list=new ArrayList<Integer>();
		int i=one.length-1;
		int j=two.length-1;
		while(i>=0&&j>=0) {
			int sum=one[i]+two[j];
			if(sum>=10) {
				list.add(sum%10);
				list.add(sum/10);
			}else {
				list.add(sum);
			}
			i--;
			j--;
		}
		while(i>=0) {
			list.add(one[i]);
			i--;
		}
		while(j>=0) {
			list.add(two[j]);
			j--;
		}
		int[] res=new int[list.size()];
		
		for(int k=res.length-1;k>=0;k--) {
			res[k]=list.get(res.length-k-1);
		}
		return res;
	}
	public static void main(String[] args) {
		AddTwoNumbersNoCarry test=new AddTwoNumbersNoCarry();
				int[] one=new int[]{9,9};
				int[] two=new int[] {0};
				test.addNoCarry(one, two);
				int[] res=test.addNoCarry(one, two);
				for(int i=0;i<res.length;i++) {
					System.out.println(res[i]);
				}
				
	}

}
