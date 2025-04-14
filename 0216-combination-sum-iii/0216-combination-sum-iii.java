class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result= new ArrayList<>();
        rec(new ArrayList<>(),new HashSet<>(),n,k,1);
        return result;    
    }
    public void rec(List<Integer> path,Set<Integer> st,int sum,int k,int idx){
        if(sum<0) return;
        if(path.size()==k){
            if(sum==0) result.add(new ArrayList<>(path));
            return ;
        }
        for(int i=idx;i<10;i++){
            if(!st.contains(i)){
                st.add(i);
                path.add(i);
                rec(path,st,sum-i,k,i+1);
                st.remove(i);
                path.remove(path.size()-1);
            }
        }
    }
}