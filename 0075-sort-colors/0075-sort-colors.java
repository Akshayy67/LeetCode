class Solution {
    public void sortColors(int[] nums) {
        int[] freq= new int[3];
        for(int num:nums) freq[num]++;
        int j=0;
        for(int i=0;i<nums.length;i++){
            while(freq[j]==0) j++;
            nums[i]=j;
            freq[j]--;
        }
    }
}