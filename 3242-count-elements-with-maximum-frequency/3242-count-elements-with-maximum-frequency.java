class Solution {
    public int maxFrequencyElements(int[] nums) {
        int result=0,max=0;
        int[] freq= new int[101];
        for(int num:nums){
            freq[num]++;
            max=Math.max(max,freq[num]);
        }
        for(int num:nums){
            if(freq[num]==max) result++;
        }
        return result;
    }
}