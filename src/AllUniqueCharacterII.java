
public class AllUniqueCharacterII {
/*bit operation
 * use a bit_vector to represents all 0-255 chars each int is 32 255/32=8,we need 9 integers
 * for each char in the string,we need its position:
 * row->char/32 denotes which integer, column->i=char%32 position in specific int
 * after get its position,use number in nums[i] to right shift and  do &&operation with 1
 * case1: result is 1:return false,means this char repeated
 * case2:result is 0:mark this position as 1->use 1 to do left shift and do operation with the bit
	*/
	public AllUniqueCharacterII() {
		// TODO Auto-generated constructor stub
	}
	public boolean allUnique(String word) {
		int[] bitVector=new int[8];
		for(int i=0;i<word.length();i++) {
			char c=word.charAt(i);
			if((bitVector[c/32]>>(c%32)&1)!=0) {
				return false;
			}else {
				//we need to mark it as 1
				bitVector[c/32]|=(1<<(c%32));
			}
	}
		return true;

}
}