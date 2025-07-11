class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        int[] count= new int[n];
        PriorityQueue<Integer> free= new PriorityQueue<>();
        for(int i=0;i<n;i++) free.add(i);
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        for(int i=0;i<meetings.length;i++){
            long start=meetings[i][0];
            long end=meetings[i][1];
            while(!busy.isEmpty() &&  start>=busy.peek()[0]){
                long[] cur=busy.poll();
                count[(int)cur[1]]++;
                free.add((int)cur[1]);
            }
            if(!free.isEmpty()){
                busy.add(new long[] {end,free.poll()});
            }
            else{
                long[] cur=busy.poll();
                busy.add(new long[] {Math.max(cur[0]+end-start,end),cur[1]});
                count[(int)cur[1]]++;
            }
        }
        while(!busy.isEmpty()){
            count[(int)busy.poll()[1]]++;
        }
        long max=0;
        int result=0;
        for(int i=0;i<n;i++){
            if(count[i]>max){
                max=count[i];
                result=i;
            }
        }
        return result;
    }
}