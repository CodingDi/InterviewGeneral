package OAWepay;
import java.util.*;
public class Puzzle3 {
    private static final int[] d = {0, 1, 0, -1, 0}; //  relative displacements of neighbors in board.
    public int slidingPuzzle(List<List<Integer>> input) {
        int N = input.size(), M = N == 0 ? 0 : input.get(0).size();
        char[][] board=new char[N][M];
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		board[i][j]=(char)(input.get(i).get(j)+'a');
        	}
        }
            StringBuilder sb = new StringBuilder();
            for (char[] row : board) {
                for (char i: row) sb.append(i);
            }
            String start = sb.toString();
            StringBuilder sb2=new StringBuilder();
            for(int i=0;i<N;i++) {
            	for(int j=0;j<M;j++) {
            		sb2.append(board[i][j]);
            	}
            }
            String goal=sb2.toString();
            Queue<String> queue = new LinkedList();
            Set<String> visited = new HashSet();
            int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            queue.add(start);
            visited.add(start);
            int steps = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    String cur = queue.poll();
                    if (cur.equals(goal)) return steps;
                    int i = cur.indexOf('a');
                    int m = i/N, n = i % N;                
                    for (int[] move : moves) {
                        int mt = m + move[0], nt = n + move[1];
                        if (mt < 0 || mt >= M || nt < 0 || nt >= N) continue;
                        String nxt = swap(cur, i, mt*N + nt);
                        if (visited.contains(nxt)) continue;
                        queue.add(nxt);
                        visited.add(nxt);
                    }
                }
                steps++;
            }
            return -1;
        }
        
        private String swap(String s, int i, int j) {
            char[] arr=s.toCharArray();
            char tmp = arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
            return new String(arr);
        }

}
