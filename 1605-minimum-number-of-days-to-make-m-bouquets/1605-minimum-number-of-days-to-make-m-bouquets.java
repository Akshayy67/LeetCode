class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length) return -1;
        int low=Integer.MAX_VALUE,high=0,mid=0;
        for(int day:bloomDay){
            low=Math.min(low,day);
            high=Math.max(high,day);
        }
        while(low<=high){
            mid=(high-low)/2+low;
            if(possible(bloomDay,mid,k,m)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public boolean possible(int[] bloomDay,int day,int k,int m){
        int count=0,cur=0;
        for(int d:bloomDay){
            if(d<=day) count++;
            else count=0;
            if(count==k){
                cur++;
                count=0;
            }
        }
        return cur>=m;
    }
}