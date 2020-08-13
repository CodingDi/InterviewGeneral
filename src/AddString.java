
public class AddString {

	
	    public String addBinary(String a, String b) {
	        StringBuilder sb=new StringBuilder();
	        int i=a.length()-1;
	        int j=b.length()-1;
	        int carry=0;
	        while(i>=0||j>=0){
	            int aval=0;
	            int bval=0;
	            if(i>=0){
	                aval=a.charAt(i);
	                i--;
	            }
	            if(j>=0){
	                bval=b.charAt(j);
	                j--;
	            }
	            int sum=aval+bval+carry;
	            sb.append(sum%2);
	            carry=sum/2;            
	        }
	        
	        if(carry>0){
	            sb.append(1);
	        }
	        return sb.reverse().toString();
	    
	}
	    public static void amin(String[] args) {
	    	String s1="101111";
	    	String s2="1010";
	    	AddString test=new AddString();
	    	System.out.println(test.addBinary(s1, s2));
	    }




}
