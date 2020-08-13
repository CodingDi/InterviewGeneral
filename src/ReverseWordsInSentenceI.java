

public class ReverseWordsInSentenceI {

	public ReverseWordsInSentenceI() {
		// TODO Auto-generated constructor stub
	}
	/*idea:for each char in the given input,we reverse within each word first, 
	 * and then we reverse the whole sentence
	 * implementation:need a helper function used for reverse a string from start to the end
	 * use two pointers to record where to reverse a word which is seperated by empty space
	 * 	 
	 *  */
	public String reverseWords(String input) {
		//corner case
		if(input==null||input.length()==0) return input;
		int start=0;
		char[] array=input.toCharArray();
		for(int i=0;i<input.length();i++) {
			//get the start 
			if(array[i]!=' '&&(i==0||array[i-1]==' ')) {
				start=i;
			}
			//get the end of each word
			if(array[i]!=' '&&(i==array.length-1||array[i+1]==' ')){
				reverse(array,start,i);//reverse each word
			}
		}
		//now we reverse the whole sentence
		reverse(array,0,array.length-1);
		return new String(array);
	}
	private void reverse(char[] array,int left,int right) {
		while(left<right) {
			char temp=array[left];
			array[left]=array[right];
			array[right]=temp;
			left++;
			right--;
		}
	}

}
