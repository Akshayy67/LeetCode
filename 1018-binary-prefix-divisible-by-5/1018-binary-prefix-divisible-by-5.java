class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        long num=0;
        List<Boolean> result= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            num=num*2+nums[i];
            num=num%5;
            if(num%5==0) result.add(true);
            else result.add(false);
        }
        return result;
    }
}