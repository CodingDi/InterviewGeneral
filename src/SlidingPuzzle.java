import java.util.*;
public class SlidingPuzzle {
	final static int[][] directions= {{-1,0},{1,0},{0,1},{0,-1}};
	public int numSteps(List<List<Integer>> input) {
		int R=input.size();
		int C=input.get(0).size();
		int[][] board=new int[R][C];
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++) {
				board[i][j]=input.get(i).get(j);
			}
		}	
		
		 //use queu to do BFS search
	      Deque<Board> queue=new ArrayDeque<Board>();
	      Map<Board,Integer> step=new HashMap<>();
	      int[][] goal=new int[R][C];
	      for(int i=0;i<R;i++) {
	    	  for(int j=0;j<C;j++) {
	    		  goal[i][j]=i*C+j;
	    	  }
	      }
	      Board start=new Board(goal);
	      queue.offer(start);
	      step.put(start,0);
	      while(!queue.isEmpty()){
	        Board cur=queue.poll();
	        int steps=step.get(cur);
	        int[] zeroPos=cur.findZero();
	        int x=zeroPos[0];
	        int y=zeroPos[1];
	        for(int[] dir:directions){
	          int i=x+dir[0];
	          int j=y+dir[1];
	          if(!cur.outOfBound(i,j)){
	            cur.swap(x,y,i,j);
	            if(!step.containsKey(cur)){
	              Board newBoard=cur.clone();
	              queue.offer(newBoard);
	              step.put(newBoard,steps+1);
	            }
	            cur.swap(x,y,i,j);//swap back
	          }
	        }
	      }
	      return step.getOrDefault(new Board(board),-1);
		}
	
		class Board{
			int[][] board;
			int C;
			int R;
			public Board() {
				
			}
			public Board(int[][] board) {
				this.board=board;
				C=board.length;
				R=board[0].length;

			}			
			public int[] findZero() {
				for(int i=0;i<board.length;i++){
					for(int j=0;j<board[0].length;j++) {
						if(board[i][j]=='0')
						return new int[]{i,j};
					}
				}
				return null;
			}
			
	        public boolean outOfBound(int i,int j) {
	        	return i>=R||i<0||j>=C||j<0;
	        }
	        
	        public void swap(int i1,int j1,int i2,int j2){
	            int tmp=board[i1][j1];
	            board[i1][j1]=board[i2][j2];
	            board[i2][j2]=tmp;
	          }
	        	
	        //clone a board type
	        public Board clone(){
	        	Board c=new Board();
	        	for(int i=0;i<R;i++) {
	        		for(int j=0;j<C;j++) {
	        			c.board[i][j]=board[i][j];
	        		}
	        	}
	        	return c;
	        }
	        @Override
	        public int hashCode(){
	        	int code=0;
	        	for(int i=0;i<R;i++){
	        		for(int j=0;j<C;j++){
	        			code=code*10+board[i][j];
	        		}
	        	}
	        	return code;
	        }
	        @Override
	        public boolean equals(Object o){
	        	if(!(o instanceof Board)){
	        		return false;
	        	}
	        	Board b=(Board)o;
	        	for(int i=0;i<R;i++){
	        		for(int j=0;j<C;j++){
	        			if(board[i][j]!=b.board[i][j]){
	        				return false;
	        			}
	        		}
	        	}
	        	return true;
	        }
	}
		
		
}
