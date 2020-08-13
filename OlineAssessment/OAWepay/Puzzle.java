package OAWepay;
import java.util.*;
public class Puzzle {
	
	public int slidingPuzzle(List<List<Integer>> input) {
		 int R = input.size(), C = input.get(0).size();
	        int[][] board=new int[R][C];
	        for(int i=0;i<R;i++) {
	        	for(int j=0;j<C;j++) {
	        		board[i][j]=input.get(i).get(j);
	        	}
	        }

        String target = "";
	    for(int i=0;i<R;i++) {
	    	for(int j=0;j<C;j++) {
	    		target+=i*C+j+','; 
	    	}
	    }
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j]+',';
            }
        }
        HashSet<String> visited = new HashSet<>();
        // all the positions 0 can be swapped to
        int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            // level count, has to use size control here, otherwise not needed
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return res;
                }
                int zero = cur.indexOf('a');//position of '0' is position os 'a'
                // swap if possible
                int row=zero/C;
                int col=zero%C;
                for (int[] dir : directions) {
                	if(dir[0]+row>=R||dir[0]+row<0||dir[1]+col>=C||dir[1]+col<0) {
                		continue;
                	}
                	int shift=(dir[0]+row)*C+(dir[1]+col);
                    String next = swap(cur, zero, shift);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);

                }
            }
            res++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) { 
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

}
