package OAWepay;
import java.util.*;
public class Puzzle4 {
	public int R;
	public int C;
	// Write your solution here
	 
    //use a matrix position to indicates the possible diercionts we can go
    //each element array is one direction
    final static int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};   
    public int numOfSteps(List<List<Integer>> input){
    	R=input.size();
    	C=input.get(0).size();
    	
      //use queue to do BFS search
      Queue<Board> queue=new ArrayDeque<>();
      Map<Board,Integer> step=new HashMap<>();
      int n=input.size();
      int m=input.get(0).size();
      List<List<Integer>> target=new ArrayList<>();
      for(int i=0;i<n;i++) {
    	 List<Integer> row=new ArrayList<>();
    	  for(int j=0;j<m;j++) {
    		  row.add(i*m+j);
    	  }
    	  target.add(new ArrayList<>(row));
      }
      Board start=new Board(target);
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
      return step.getOrDefault(new Board(input),-1);
    }
    

    static class Board{
      public int R;
      public int C;
      public List<List<Integer>> input;
      private int[][] board;
      public Board(){
        
      }
      public Board(List<List<Integer>> input){
        //get the board as a int value
    	 this.input=input;

    	this.board=new int[R][C];
        for(int i=0;i<R;i++){
          for(int j=0;j<C;j++){
            board[i][j]=input.get(i).get(j);
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
