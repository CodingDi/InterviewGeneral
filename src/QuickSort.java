
import java.util.*;
public class QuickSort {
		  public int[] quickSort(int[] array) {
		    // Write your solution here
		    if(array==null||array.length==0){
		      return array;
		    }
		    quickSort(array,0,array.length-1);
		    return array;
		    
		  }

		  private void quickSort(int[] array,int left,int right){
		    if(array==null||array.length==0){
		      return;
		    }
		    Random rand=new Random();
		    //randomly generate a pivot index to do partition
		    int pivotIndex=left+rand.nextInt(right-left+1);
		      int i=left;
		      int j=right-1;//leave one for pivot, we don't need to move it
		      //we put the pivot to the rightmost position
		      swap(array,pivotIndex,right);
		      //now we start partition
		      while(i<=j){
		        if(array[i]<array[right]){
		          i++;
		        }else{
		          swap(array,i,j);
		          j--;
		        }
		      }
		      //put the pivot back
		      swap(array,i,pivotIndex);
		      //now pivot is in its right place, we do the same for the left and right part
		      quickSort(array,left,pivotIndex-1);
		      quickSort(array,pivotIndex+1,right);
		  }

		  //helepr function to do swap
		  private void swap(int[] array,int a,int b){
		    if(array==null||array.length==0){
		      return;
		    }
		    int temp=array[a];
		    array[a]=array[b];
		    array[b]=temp;
		  }

}
