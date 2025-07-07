class Solution {
    public int maxEvents(int[][] events) {
       Arrays.sort(events,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
       });
       int count=0;
       int max=0;
       for(int i=0;i<events.length;i++){
        max=Math.max(max,events[i][1]);
       }
       PriorityQueue<Integer> pq= new PriorityQueue<>();
       for(int i=1,j=0;i<=max;i++){
            while(j<events.length && events[j][0]<=i){
                pq.offer(events[j][1]);
                j++;
            }
            while(!pq.isEmpty() && pq.peek()<i) pq.poll();
            if(!pq.isEmpty()){
                count++;
                pq.poll();
            }
       }
       return count;
    }
}