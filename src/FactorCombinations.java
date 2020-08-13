import java.util.*;
public class FactorCombinations {
	public List<List<Integer>> combinations(int target) {
	    // Write your solution here
	    List<List<Integer>> res=new ArrayList<List<Integer>>();
	    if(target==1){
	      return res;
	    }
	    List<Integer> factors=getFactors(target);
	    List<Integer> cur=new ArrayList<Integer>();
	    helper(res,cur,factors,0,target);
	    return res;
	  }
	  private void helper(List<List<Integer>> res,List<Integer> cur,List<Integer> factors,int index,int target){
	    //base case
	    if(index==factors.size()){
	      if(target==1){
	        res.add(new ArrayList<Integer>(cur));
	      }
	      return;
	    }
	    //case1.not add
	    helper(res,cur,factors,index+1,target);
	    int factor=factors.get(index);
	    int count=0;
	    //case2. add:any number could be added
	    //each time we add a factor,not matter different or repeated,we need to call a recursion
	    while(target%factor==0){
	      target/=factor;
	      cur.add(factor);
	      helper(res,cur,factors,index+1,target);
	      count++;
	    }
	    //go back
	    while(count>0){
	      cur.remove(cur.size()-1);
	      count--;
	    }
	   
	  }

	  private List<Integer> getFactors(int number){
	    List<Integer> factors=new ArrayList<Integer>();
	    for(int i=2;i<=number/2;i++){
	      if(number%i==0){
	        factors.add(i);
	      }
	    }
	    return factors;
	  }
	  
	  public static void main(String[] args) {
		  FactorCombinations test=new FactorCombinations();
		  test.combinations(12);
		 
	  }
}
