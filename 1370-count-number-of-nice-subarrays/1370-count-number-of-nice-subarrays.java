class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1) list.add(i);
        }
        int result=0;
        for(int i=0;i<list.size()-k+1;i++){
            int l=list.get(i)-((i==0)?-1:list.get(i-1));
            int r=((i+k==list.size())?nums.length:list.get(i+k))-list.get(i+k-1);
            result+=(l*r);
        }
        return result;
    }
}