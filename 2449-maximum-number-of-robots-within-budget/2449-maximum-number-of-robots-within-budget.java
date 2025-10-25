class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int result=0;
        int low=1,high=chargeTimes.length,mid=0;
        while(low<=high){
            mid=(high-low)/2+low;
            if(possible(chargeTimes,runningCosts,mid,budget)){
                low=mid+1;
                result=mid;
            }
            else high=mid-1;
        }
        return result;
    }
    public boolean possible(int[] nums,int[] nums2,int winsize,long budget){
        long calc=0,sum=0;
        Deque<Integer> dq= new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            sum+=nums2[i];
            if(i>0 && dq.peekFirst()==i-winsize) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]) dq.pollLast();
            dq.addLast(i);
            if(i+1>=winsize){
                calc=nums[dq.peekFirst()]+(long)winsize*sum;
                if(calc<=budget) return true;
                sum-=nums2[i-winsize+1];
            }
        }
        return false;
    }
}