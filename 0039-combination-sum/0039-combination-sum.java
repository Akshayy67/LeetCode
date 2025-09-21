class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result= new ArrayList<>();
        helper(candidates,0,target,new ArrayList<>());
        return result;
    }
    public void helper(int[] nums,int i,int target,List<Integer> path){
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(i>=nums.length || target<0) return ;
        helper(nums,i+1,target,path);
        path.add(nums[i]);
        helper(nums,i,target-nums[i],path);
        path.remove(path.size()-1);
    }
}