// --- bottom up approach---//
class Solution {
    Integer[] nextId;  // cache for storinf next interval after curent end
    public int maxValue(int[][] events, int k) {
        nextId= new Integer[events.length];
        // sort based on starting time
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int n=events.length;
        // dp[i][j]=max value using at most i events and starting from index j
        int[][] dp= new int[k+1][events.length+1];
        //fill dp table
        //i -> number of events allowed (1->k)
        //j -> cur index from right to left
        for(int i=1;i<=k;i++){
            for(int j=n-1;j>=0;j--){
                // find the next evetnt index start after event[j] ends
                int next=bs(events,j+1,events[j][1]);
                //two choices
                //   1.skip current -> d[i][j+1];
                //   2.take current event-> cur event profit +dp[i-1][next]
                dp[i][j]=Math.max(dp[i][j+1],events[j][2]+dp[i-1][next]);
            }
        }
        // max value using at most k events starting from index 0;
        return dp[k][0];
    }
    public int bs(int[][] events,int i,int target){
        if(nextId[i-1]!=null) return nextId[i-1];
        int low=i,high=events.length-1,mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(events[mid][0]<=target) low=mid+1;
            else high=mid-1;
        }
        return nextId[i-1]=low;
    }
}
    // -- Top down Approach--
class Solutio {
    Integer[][] dp;
    public int maxValue(int[][] events, int k) {
        dp= new Integer[k+1][events.length];
        // sort based on starting time
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        // recursion from first event and k remaining picks
        return helper(events,k,0);
    }
    public int helper(int[][] events,int k,int i){
        // no more events
        if(i>=events.length) return 0;
        // no picks left
        if(k==0) return 0;
        //memoization check
        if(dp[k][i]!=null) return dp[k][i];
        //skipppppp
        int leave=helper(events,k,i+1);
        //take cur value
        // use binary search to find next non-overlapping event
        int low=i+1,high=events.length-1,mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(events[mid][0]<=events[i][1]){
                low=mid+1;
            }
            else high=mid-1;
        }
        // now low points to the first event that starts after events[i] ends
        int take=events[i][2]+helper(events,k-1,low);
        //memoize
        return dp[k][i]=Math.max(take,leave);
        
    }
}