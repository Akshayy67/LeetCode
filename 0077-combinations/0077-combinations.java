class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result= new ArrayList<>();
        helper(1,n,k,new ArrayList<>());
        return result;
    }
    public void helper(int i,int n,int k,List<Integer> path){
        if(path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int idx=i;i<=n;i++){
            path.add(i);
            helper(i+1,n,k,path);
            path.remove(path.size()-1);
        }
    }
}