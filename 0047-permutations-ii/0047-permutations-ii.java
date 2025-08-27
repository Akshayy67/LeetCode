class Solution {
    List<List<Integer>> result;
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums=nums;
        result= new ArrayList<>();
        helper(new LinkedHashSet<>(),new ArrayList<>());
        return result;
    }
    public void helper(Set<Integer> st,List<Integer> path){
        if(st.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!st.contains(i)){
                if(i>0 && nums[i]==nums[i-1] && !st.contains(i-1)) continue;
                st.add(i);
                path.add(nums[i]);
                helper(st,path);
                path.remove(path.size()-1);
                st.remove(i);
            }
        }
    }
}