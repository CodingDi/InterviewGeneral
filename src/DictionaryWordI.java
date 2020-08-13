import java.util.HashSet;
import java.util.Set;

public class DictionaryWordI {

	public DictionaryWordI() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		DictionaryWordI test=new DictionaryWordI();
		String s="robcatbobb";
		String[] d= {"bob","rob","cat"};
		System.out.println(test.canBreak(s,d));
	}
	
	public boolean canBreak(String input,String[] dict) {
		//use a boolean array m,m[i]: denotes if we can cut at i
	    //string from 0 to before i can be composed by concatenating words from dict
	    //data struture:two pointers i and j [i,j] can be searching space to see if (i,j) is a word from dict
	    //a hashSet to stores dictionary
	    //case1:we make m[j]==T when m[i]=T and (i,j) belongs to dict
	    //return: m[input.length()] so the array should be length length+1
		boolean[] canCut=new boolean[input.length()+1];
		canCut[0]=true;
		Set<String> set=new HashSet<String>();
		for(String s:dict) {
			set.add(s);
		}
		for(int j=1;j<=input.length();j++) {
			//case1: the whole input is a word
			if(set.contains(input.substring(0,j))){
				canCut[j]=true;
			}
			//case 2:we go back to see if any can be a word
			for(int i=1;i<j;i++) {
				if(canCut[i]&&set.contains(input.substring(i,j))){
					canCut[j]=true;
				}
			}
			
		}
		
		return canCut[input.length()];
	}
	
		

}
