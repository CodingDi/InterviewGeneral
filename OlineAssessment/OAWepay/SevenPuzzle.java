package OAWepay;
import java.util.*;
public class SevenPuzzle {

		  
	    // Write your solution here
	 
	    //use a matrix position to indicates the possible diercionts we can go
	    //each element array is one direction
	    final static int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};   
	    public int numOfSteps(int[] values){
	      //use queu to do BFS search
	      Queue<Board> queue=new ArrayDeque<>();
	      Map<Board,Integer> step=new HashMap<>();
	      Board start=new Board(new int[]{0,1,2,3,4,5,6,7});
	      queue.offer(start);
	      step.put(start,0);
	      while(!queue.isEmpty()){
	        Board board=queue.poll();
	        int steps=step.get(board);
	        int[] zeroPos=board.findZero();
	        int x=zeroPos[0];
	        int y=zeroPos[1];
	        for(int[] dir:directions){
	          int i=x+dir[0];
	          int j=y+dir[1];
	          if(!board.outOfBound(i,j)){
	            board.swap(x,y,i,j);
	            if(!step.containsKey(board)){
	              Board newBoard=board.clone();
	              queue.offer(newBoard);
	              step.put(newBoard,steps+1);
	            }
	            board.swap(x,y,i,j);//swap back
	          }
	        }

	      }
	      return step.getOrDefault(new Board(values),-1);
	    }
	    

	    static class Board{
	      public final static int R=2;
	      public final static int C=4;
	      private int[][] board=new int[R][C];
	      public Board(){
	        
	      }
	      public Board(int[] values){
	        //get the boad as a int value
	        for(int i=0;i<R;i++){
	          for(int j=0;j<C;j++){
	            board[i][j]=values[i*C+j];
	          }
	        }
	      }

	    public void swap(int i1,int j1,int i2,int j2){
	      int tmp=board[i1][j1];
	      board[i1][j1]=board[i2][j2];
	      board[i2][j2]=tmp;
	    }
	      //find the position of 0,return as a position array
	      public int[] findZero(){
	        for(int i=0;i<R;i++){
	          for(int j=0;j<C;j++){
	            if(board[i][j]==0){
	              return new int[]{i,j};
	            }
	          }
	        }
	        return null;
	      }
	      //to see in the board if position(i,j) is out of the matrix bound
	      public boolean outOfBound(int i,int j){
	        return i<0||i>=R||j<0||j>=C;
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
	      @Override
	      public Board clone(){
	        Board c=new Board();
	        for(int i=0;i<R;i++){
	          for(int j=0;j<C;j++){
	            c.board[i][j]=board[i][j];
	          }
	        }
	        return c;
	      }
	      

	    }

	


}
