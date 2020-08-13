
public class ArrayHopperII {

	public ArrayHopperII() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		ArrayHopperII test=new ArrayHopperII();
		int[] array1= {3, 3, 1, 0, 4};
		int[] array2= {2, 1, 1, 0, 2};
		System.out.println(test.minJump(array1));
		System.out.println(test.minJump(array2));
	}
	public int minJump(int[] array) {
		//idea:use an array minJump[] to denotes the min jump:m[i]=x means min jump to array[i]=x
		//return minJump[array.length-1]
		//data structure: a minJump[],initialize each element as -1 to indicates unreachable
		//start from the index 0 we check each of its previous number, what's the min to reaches cur number
		//for each previous nodes,we check if previous can reaches it
		//case1:can reach->update if necessary ->if the cur is unreachable or we find a shorte route
		//case 2:can't reaches,we continue to go back further
		int[] minJump=new int[array.length];
		minJump[0]=0;
		for(int i=1;i<array.length;i++) {//for each number in the array
			minJump[i]=-1;//initialize to be unreachable
			for(int j=i-1;j>=0;j--) {//check each of its previous number to see any closer steps
				if(minJump[j]!=-1&&array[j]+j>=i) {//for each reachable middlepoint, update if necessary
					if(minJump[i]==-1||minJump[j]+1<minJump[i]) {
						minJump[i]=minJump[j]+1;
					}
				}
			}
		}
		
		return minJump[array.length-1];
	}

}
