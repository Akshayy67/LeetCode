class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for(int i=0;i<nums.size()-2*k+1;i++){
            if(isIncreasing(nums,i,k)&& isIncreasing(nums,i+k,k)) return true;
            System.out.println();
        }
        return false;
    }
    public boolean isIncreasing(List<Integer> nums,int i,int k){
        for(int j=i;j<i+k-1;j++){
            if(nums.get(j)>=nums.get(j+1)) return false;
            System.out.print(nums.get(j)+" ");
        }
        System.out.println();
        return true;
    }
}