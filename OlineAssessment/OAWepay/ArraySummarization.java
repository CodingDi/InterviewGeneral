package OAWepay;
import java.util.*;
public class ArraySummarization {
	public boolean twoPair(List<Integer> input,List<Integer> test) {
		//build a map<key=unique numbers in input,value=the corresponding frequency for the key>
		Map<Integer,Integer> map=new HashMap<>();
		for(Integer a:input) {
			Integer frequency=map.get(a);
			if(!map.containsKey(a)) {
				map.put(a, 1);
			}else {
				map.put(a, frequency+1);
			}			
		}
		//2.for each number b in test list,
		//		for each number arr1 in input list,
		//			we will check if goal=b-a exists in the hashMap
		//			if a!=goal,count++
		//			else if a=goal, check if the map has move than 2 a
		for(int i=0;i<test.size();i++) {
			for(int j=0;j<input.size();j++) {
				int a=input.get(j);
				int goal=test.get(i)-a;
				if(map.containsKey(goal)) {
					if(goal!=a) {
						return true;
					}else if(map.get(a)>=2) {
						return true;
					}
				}
			}
			
		}
		return false;		
		
	}

}
