public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    // Write your solution here
    //orner case
    if(array==null||array.length==0){
      return new int[0];
    }
    if(k==0){
      return new int[0];
    }
    //we use an array of size k to store the target results
    int[] res=new int[k];
    int leftIndex=largestSmallerOrEqual(array,target);//calling the helper funciton
    int rightIndex=leftIndex+1;
    //by centered at the leftIndex,we expand to bothsize by moving pointers which are closer to the target
    //and we need to move until got k elements or out of bound
    for(int i=0;i<k;i++){
      //we advande the leftIndex under case1:rightIndex is out of bound
      //case2: both right and left index are within the bound and leftINdex is closer to the target
      if(rightIndex>array.length-1||leftIndex>=0&&Math.abs(array[leftIndex]-target)<=Math.abs(array[rightIndex]-target)){
        res[i]=array[leftIndex++];
      }else{
        res[i]=array[rightIndex++];
      }
    }
    return res;
  }

  //helper function:largestSmallerOrEqual 关于为什么用这个可以看自己的一亩三分地！
  private int largestSmallerOrEqual(int[] array,int target){
    if(array==null||array.length==0){
      return -1;
    }
    int left=0;
    int right=array.length-1;
    while(left<right-1){
      int mid=left+(right-left)/2;
      if(array[mid]<=target){
        left=mid;
      }else if(array[mid]>target){
        right=mid;
      }
    }
    //post processing: we check right first
    //DEBUG:remember here we need check when"=="!!
    if(array[right]<=target){
      return right;
    }
    if(array[left]<=target){
      return left;
    }
    //no anyone <=target
    return -1;
  }
}
