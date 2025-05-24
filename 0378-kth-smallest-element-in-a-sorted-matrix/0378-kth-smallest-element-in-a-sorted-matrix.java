class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(pq.size()==k){
                    if(pq.peek()>matrix[i][j]) {
                        pq.poll();
                        pq.offer(matrix[i][j]);
                    }
                }
                    else 
                        pq.offer(matrix[i][j]);
            }
        }
        return pq.peek();
    }
}