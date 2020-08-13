
import java.util.*;
public class NQueen {

	public NQueen() {
		// TODO Auto-generated constructor stub
	}
	/*IDEA:each row canhs only 1 Queen,so we may do the recursion tree like
	 * for level 0,we try N branches,with each specifies i column and do validate helper function
	 * for level 1,we try (N-1) branches with each specify ..
	 * ...
	 * 
	 * HELPER FUNCTION: note that how we validate the column for specific solution List:
	 * with each row,there's impossible way to attack the same wor,but we need to check 
	 * 1. any previous row's column so far is the same with cur row's column
	 * 2. the trick for diagonal attack is that (row-other'row)=abs(column-cur'column)
	 * we get column by list.get(i) where i is the i t row,get(i0 is i'th row's column
	 * */
	public List<List<Integer>> nqueens(int n){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		List<Integer> cur=new ArrayList<Integer>();//cur stores the column# for each ith position row
		helper(n,res,cur);
		return res;
	}
	
	//helper function to distribute put row's queen
	private void helper(int n,List<List<Integer>> res,List<Integer> cur) {
		//base case:when all rows got its position of column,cur became a solution
		if(cur.size()==n) {
			res.add(new ArrayList<Integer>(cur));
		}
		//other case:for all (0,n-1) rows,we try all possible columns named i.
		//if its valid,add it, and we need to call for next layer; remove the newlt added one to try other choice
		for(int i=0;i<n;i++) {
			if(valid(i,cur)) {
				cur.add(i);
				helper(n,res,cur);//go
				cur.remove(cur.size()-1);//back
			}
		}
	}
	//helper function:used to check if for current row,can we use column 
	private boolean valid(int column,List<Integer> cur) {
		//when to be invalid:its by default can't be the same row
		//but we need to check if the same column used before in cur list
		//and check if the cross may attack
		for(int i=0;i<cur.size();i++) {
			if(cur.get(i)==column||Math.abs(cur.get(i)-column)==cur.size()-i) { //use the same column or met in cross
				return false;
			}
		}
		return true;
	}

}
