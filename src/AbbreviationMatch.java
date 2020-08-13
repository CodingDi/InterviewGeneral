
public class AbbreviationMatch {

	public AbbreviationMatch() {
		// TODO Auto-generated constructor stub
	}
	/*IDEA: recursive way
	 * corner case:
	 * when both lengths are 0 or null->T
	 * when only one of their length is 0->F
	 * when any one the strings is out of length while the either is not->F
	 * 
	 * recursive rule:
	 * case1:when char in the string is letter,
	 *  if equal to corresponding letter at target->recursively call another;if not equal->F
	 * 
	 * case2:when the char in the string is a digit,get the total digit until its not digit and recursively call
	 * WAY to get the digit:
	 * initialized to 0,each time we get a new digit,time previous digit by 10,its like it left shift in digit bit
	 */
	public boolean match(String input,String pattern) {
		
		return helper(input,pattern,0,0);
	}
	
	
	
	//helper function:deal with the char at i for input and j for pattern
	private boolean helper(String input,String pattern,int i,int j) {
		//base case:if both reaches end at this time,T
		if(i==input.length()&&j==pattern.length()) {
			return true;
		}
		//if any of them is out of bound but another isn't ->F
		if(i>=input.length()||j>=pattern.length()) {
			return false;
		}
		//case 1:if is a letter in input
		char a=input.charAt(i);
		char b=pattern.charAt(j);
		if(pattern.charAt(j)<'0'||pattern.charAt(j)>'9') {
			if(a==b) {
				return helper(input,pattern,i+1,j+1);//when they are equal,recursively call
			}
			return false;		
			}
		//case2:when its a number
		int count=0; //the (char)number in input that were abbreviated
		while(j<pattern.length()&&pattern.charAt(j)>='0'&&pattern.charAt(j)<='9') {
			count=count*10+(pattern.charAt(j)-'0');
			j++;
		}
		return helper(input,pattern,i+count,j);
		
	}
	
}
