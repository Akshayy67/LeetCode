class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int count=0;
        for(int i=1;i<nums.size()-2*k+1;i++){
            if(nums.get(i)>nums.get(i-1) && nums.get(i+k+1)>nums.get(i+k)) count++;
            else count=1;
            if(count==k) return true;
            System.out.println(count);
        }
        return false;
    }
}