class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        Queue<Integer> q= new LinkedList<>();
        q.add(1);
        boolean[] visited= new boolean[n*n+1];
        visited[1]=true;
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int cur=q.poll();
                if(cur == n*n) return steps;
                for(int i=cur+1;i<=Math.min(cur+6,n*n);i++){
                    int idx=i-1;
                    int row= (n-1)-(idx/n);
                    int col=idx%n;
                    if((n-1-row)%2==1) col=n-1-col;
                    // if((row+1)*(col+1)==n*n) return steps;
                    if(!visited[i]){
                        visited[i]=true;
                        if(board[row][col]==-1){
                            q.add(i);
                        }
                        else{
                            q.add(board[row][col]);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}