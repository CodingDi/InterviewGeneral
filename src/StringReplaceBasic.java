
public class StringReplaceBasic {

	public StringReplaceBasic() {
		// TODO Auto-generated constructor stub
	}
	/* use string interface's method.use stringBuilder sb
	 * each time we got a match index named from. copy string to stringBuider.
	 * continue until no more match. each time we got a match,need to update the from index and the match index.
	 * post-processing,need to copy all othethings left
	 */
	public String replace(String input, String source, String target) {
		StringBuilder sb=new StringBuilder();
		int from=0;
		int match=input.indexOf(source, from);//find the first match's position
		while(match!=-1) {//as long as we can find a match
			sb.append(input,from,match).append(target);
			from=match+source.length();//update the from index by add it from match+t.len
			match=input.indexOf(source,from);
		}
		//post-processing:we finished all match,but left some non-match chars
		sb.append(input,from,input.length());
		return sb.toString();
	}
	

}
