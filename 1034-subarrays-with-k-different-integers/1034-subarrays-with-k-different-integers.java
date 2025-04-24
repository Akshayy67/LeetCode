class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countDistinctK(nums,k)-countDistinctK(nums,k-1);
    }
    public int countDistinctK(int[] nums,int k){
        int count=0,j=0;
        Map<Integer,Integer> mp= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            while(mp.size()>k){
                mp.put(nums[j],mp.get(nums[j])-1);
                if(mp.get(nums[j])==0) mp.remove(nums[j]);
                j++;
            }
            count+=(i-j+1);
        }
        return count;
    }
}