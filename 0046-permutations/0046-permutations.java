class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result= new ArrayList<>();
        helper(nums,new ArrayList<>(),0);
        return result;
    }
    public void helper(int[] nums,List<Integer> path,int visited){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(((visited&(1<<i)))==0){
                path.add(nums[i]);
                helper(nums,path,visited|(1<<i));
                path.remove(path.size()-1);
            }
        }
    }
}