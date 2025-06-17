class Solution {
    public int[] frequencySort(int[] n) {
        int[] freq= new int[210];
        Integer[] nums= new Integer[n.length];
        for(int i=0;i<n.length;i++){
            nums[i]=n[i];
        }
        for(int num:nums){
            freq[num+100]++;
        }
        Arrays.sort(nums,(a,b)->{
            if(freq[a+100]==freq[b+100]){
                return b-a;
            }
            return freq[a+100]-freq[b+100];
        });

        for(int i=0;i<n.length;i++){
            n[i]=nums[i];
        }
        return n;
    }
}