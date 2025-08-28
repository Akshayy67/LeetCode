class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        for(int i=1;i<n;i++){
            PriorityQueue<Integer> pq= new PriorityQueue<>();
            int ni=0,nj=i;
            while(ni<n && nj<n){
                pq.offer(grid[ni][nj]);
                ni++;nj++;
            }
            ni=0;nj=i;
            while(ni<n && nj<n){
                grid[ni][nj]=pq.poll();
                ni++;nj++;
            }
        }
        for(int i=0;i<n;i++){
            PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
            int ni=i,nj=0;
            while(ni<n && nj<n){
                pq.offer(grid[ni][nj]);
                ni++;nj++;
            }
            ni=i;nj=0;
            while(ni<n && nj<n){
                grid[ni][nj]=pq.poll();
                ni++;nj++;
            }
        }
        return grid;
    }
}