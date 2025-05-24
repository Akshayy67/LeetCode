class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result= new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }
    public void helper(int[] nums,int i,List<Integer> list){
        result.add(new ArrayList<>(list));
        for(int idx=i;idx<nums.length;idx++){
            if(idx>i && nums[idx]==nums[idx-1]) continue;
            list.add(nums[idx]);
            helper(nums,idx+1,list);
            list.remove(list.size()-1);
        }
    }
}