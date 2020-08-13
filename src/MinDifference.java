import java.util.*;
public class MinDifference {

	  public int minDifference(int[] array) {
	    // Write your solution hee
	    List<Integer> group1=new ArrayList<Integer>();
	    List<Integer> group2=new ArrayList<Integer>();
	    int[] min=new int[]{Integer.MAX_VALUE};
	    helper(group1,group2,array,min,0,0,0);
	    return min[0];
	  }
	  private void helper(List<Integer> group1,List<Integer> group2,int[] array,int[] min,int index,int sum1,int sum2){
	    //for each number in the array,we either add it in the group1 or group2
	    //try both and call recursion for next number
	    //use diff=sum group1-sum group2.
	    //so while we add number to group1,diff=diff+number
	    //if we add number to group2,diff=diff-number
	    //base case:when we added all the array to two groups
	    //update the |diff| if necessary
	    if(index==array.length){
	    	if(group1.size()==group2.size()) {
	    		 min[0]=Math.min(min[0],Math.abs(sum1-sum2));
	    	}
	     
	      return;
	    } 
	    group1.add(array[index]);
	    helper(group1,group2,array,min,index+1,sum1+array[index],sum2);
	    group1.remove(group1.size()-1);
	    group2.add(array[index]);
	    helper(group1,group2,array,min,index+1,sum1,sum2+array[index]);
	    group2.remove(group2.size()-1);
	  }
	  public static void main(String[] args) {
		  MinDifference diff=new MinDifference();
		  int[] arr1=new int[] {5,-2,-10,3};
		  System.out.print(diff.minDifference(arr1));
	  }
	}
