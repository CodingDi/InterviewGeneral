
public class HIndexII {

	private int hIndex(int[] citations) {
        int n=citations.length;
        for(int i=0;i<n;i++){
            if(citations[i]>=n-i){
                return n-i;
            }else{
                 i++;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
    	int[] nums= {0,1};
    	HIndexII test=new HIndexII();
    	System.out.println(test.hIndex(nums));
    }

}
