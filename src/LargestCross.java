
public class LargestCross {

	public LargestCross() {
		// TODO Auto-generated constructor stub
	}
	/*idea: for each cross,the arms length are always the same. for the center,it always get four arms' smallest length as its length
	 * the four arms are left right up and down(includes itself).
	 * we will check each cell and get the max result.
	 * implementation:
	 * use a helper function to dynamically computes four arms' length respectively.
	 * but note that up and left can starts from 0 to the end
	 * right and down starts from the end to 0
	 * we need to merge four arms to take the minimum
	 * 
	*/
	public int largest(int[][] matrix) {
		if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
		int n=matrix.length;
		int m=matrix[0].length;
		int[][] leftUp=leftUp(matrix,n,m);
		int[][] rightDown=rightDown(matrix,n,m);
		return merge(leftUp,rightDown,n,m);
		
	}
	private int[][] leftUp(int[][] matrix,int n,int m){
		int[][] left=new int[n][m];
		int[][] up=new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(matrix[i][j]==1) {
					if(i==0&&j==0) {//case1:both are 0
						left[i][j]=1;
						up[i][j]=1;
					}else if(i==0) {//case2:row is zero,up can only be 1,left could inherit left side
						left[i][j]=left[i][j-1]+1;
						up[i][j]=1;
					}else if(j==0){//case3:column is zero
						left[i][j]=1;
						up[i][j]=up[i-1][j]+1;
					}else {
						up[i][j]=up[i-1][j]+1;
						left[i][j]=left[i][j-1]+1;
					}
				}
				//for others when matrix[i][j]==0,we don't need to do anything they are 0 by default
			}
			
		}
		merge(left,up,n,m);
		return left;
	}
	
	private int[][] rightDown(int[][] matrix,int n,int m){
		int[][] right=new int[n][m];
		int[][] down=new int[n][m];
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				if(matrix[i][j]==1) {
					if(i==n-1&&j==m-1) {
						right[i][j]=1;
						down[i][j]=1;
					}else if(i==n-1) {
						down[i][j]=1;
						right[i][j]=right[i][j+1]+1;
					}else if(j==m-1) {
						down[i][j]=down[i+1][j]+1;
						right[i][j]=1;
					}else {
						down[i][j]=down[i+1][j]+1;
						right[i][j]=right[i][j+1]+1;
					}
				}
			}
		}
		merge(right,down,n,m);
		return right;
	}
	//merge helper function: we always take the min
	private int merge(int[][] leftUp,int[][] rightDown,int n,int m){
		
		int res=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				leftUp[i][j]=Math.min(leftUp[i][j], rightDown[i][j]);
				res=Math.max(leftUp[i][j], res);
			}
		}
		return res;
	}

}
