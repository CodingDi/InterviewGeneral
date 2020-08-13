package OAWepay;
import java.util.*;
public class Puzzle6 {
	public int slidingPuzzle(List<List<Integer>> input) {
        // m * n version
        int n = input.size();
        int m = input.get(0).size();

        //build target string
        //1->A 2->B ...etc
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        for (int i = 0; i < m * n-1 ; i++){
            sb.append((char)(i+65));
        }     
        String target = sb.toString();
        
        //build start string
        String start = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (input.get(i).get(j)== 0){
                    start += 0;
                }else {
                    start += (char)(input.get(i).get(j) +64);
                }
            }
        }
        
        HashSet<String> visited = new HashSet<>();
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int res = 0;
        //BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return res;
                }
                int index = cur.indexOf('0');
                int x = index / m;
                int y = index % m;
                for (int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx <n && ny >= 0 && ny < m){
                        int indexToSwap = nx * m + ny; 
                        String next = swap(cur, index, indexToSwap);
                        if (visited.contains(next)){
                            continue;
                        }
                        visited.add(next);
                        queue.offer(next);
                    }
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
