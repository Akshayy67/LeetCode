class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> prev= new ArrayList<>();
        for(int num:nums) prev.add(num);
        for(int i=0;i<nums.length-1;i++){
            List<Integer> cur= new ArrayList<>();
            for(int j=0;j<prev.size()-1;j++){
                cur.add((prev.get(j)+prev.get(j+1))%10);
            }
            prev=cur;
        }
        return prev.get(0);
    }
}