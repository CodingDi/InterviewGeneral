import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class AllAnagrams {	
	public static void main(String[] args) {
		AllAnagrams bugAnagram=new AllAnagrams();
		System.out.println(bugAnagram.allAnagrams("abc","abcghjbcahjkcab"));
		
		
	}
  public List<Integer> allAnagrams(String sh, String lo) {
    // Write your solution here	  
	  
 List<Integer> list=new ArrayList<Integer>();
    if(sh.length()>lo.length()){
      return list;
    }
   Map<Character,Integer> map=getMap(sh);
    int match=0;
    for(int i=0;i<lo.length();i++){
    	char ch=lo.charAt(i);
        Integer freq=map.get(ch);
        if(freq!=null){
            map.put(ch,freq-1);
            if(freq==1){
            match++;
            }
          } 
        if(i>=sh.length()){
          ch=lo.charAt(i-sh.length());
          freq=map.get(ch);
            //if it exists in the map,we need to add the count for a match by 1
            //alsoe need to check will we lose a match
            if(freq!=null){
              map.put(ch,freq+1);
              //0-->1,we lose a match
              if(freq==0){
                match--;
              }
            }
            //0123456
            //check the total #match to see do we need to ouput 
          }
      if(match==map.size()){
        list.add(i-sh.length()+1);
      }

    }
    return list;
  } 
  private Map<Character,Integer> getMap(String sh){
	    Map<Character,Integer> map=new HashMap<Character,Integer>();
	    for(int i=0;i<sh.length();i++){
	      Integer count=map.get(sh.charAt(i));
	      if(count!=null){
	        //012345
	        map.put(sh.charAt(i),count+1);
	      }else{
	        map.put(sh.charAt(i),1);
	      }
	    }
	    return map;
	  }
}
