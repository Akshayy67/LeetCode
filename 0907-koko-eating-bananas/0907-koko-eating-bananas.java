class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=0,mid=0;
        for(int pile:piles) high=Math.max(high,pile);
        while(low<high){
            mid=(high-low)/2+low;
            if(possible(piles,mid,h)) high=mid;
            else low=mid+1;
        }
        return low;
    }
    public boolean possible(int[] piles,int speed, int hours){
        int count=0;
        for(int pile:piles){
            count+=Math.ceil((double)pile/speed);
        }
        return count<=hours;
    }
}