package OAWepay;

import java.util.ArrayList;
import java.util.List;

public class TestWepay {
	public static void main(String[] args) {
		List<List<Integer>> list1=new ArrayList<>();
		List<Integer> row11=new ArrayList<>();
		
	
		row11.add(1);
		row11.add(2);
		row11.add(7);
		row11.add(3);
		row11.add(4);
		list1.add(row11);
		
		List<Integer> row12=new ArrayList<>();
		row12.add(5);
		row12.add(6);
		row12.add(12);
		row12.add(8);
		row12.add(9);
		list1.add(row12);
		
		List<Integer> row13=new ArrayList<>();
		row13.add(10);
		row13.add(11);
		row13.add(17);
		row13.add(13);
		row13.add(14);
		list1.add(row13);
		
		List<Integer> row14=new ArrayList<>();
		row14.add(15);
		row14.add(16);
		row14.add(22);
		row14.add(18);
		row14.add(19);
		list1.add(row14);
		List<Integer> row15=new ArrayList<>();		
		row15.add(20);
		row15.add(21);
		row15.add(0);
		row15.add(23);
		row15.add(24);
		list1.add(row15);
//		SlidingPuzzle test1=new SlidingPuzzle();
//		System.out.println("test needs:"+test1.slidingPuzzle(list1));
//		Puzzle test2=new Puzzle();
//		System.out.println("test2 needs:"+test2.slidingPuzzle(list1));
//		Puzzle3 test3=new Puzzle3();
//		System.out.println("test3 need:"+test3.slidingPuzzle(list1));
//		Puzzle6 test4=new Puzzle6();
//		System.out.println("test4 needs"+test4.slidingPuzzle(list1));
//		int[] values=new int[] {1,2,3,0,4,5,6,7};
//		SevenPuzzle test5=new SevenPuzzle();
//		System.out.println(test5.numOfSteps(values));
		ArraySummarization arr1=new ArraySummarization();
		List<Integer> list2=new ArrayList<>();
		list2.add(0);
		list2.add(2);
		list2.add(6);
		List<Integer> list3=new ArrayList<>();
		list3.add(3);
		list3.add(7);
		list3.add(4);
		System.out.println(arr1.twoPair(list2,list3));
		
	}

}
