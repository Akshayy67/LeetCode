public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        var mp= new Dictionary<int,int>();
        for(int i=0;i<nums.Length;i++){
            int need=target-nums[i];
            if(mp.TryGetValue(need,out int j)) return new int[] {j,i};
            mp[nums[i]]=i;
        }
        return new int[] {};
    }
}