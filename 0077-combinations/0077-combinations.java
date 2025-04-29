class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result= new ArrayList<>();
        backTrack(new ArrayList<>(),k,n,1);
        return result;
    }
    public void backTrack(List<Integer> path,int k,int n,int i){
        // if(i>n) return;
        if(path.size()==k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int j=i;j<=n;j++){
            path.add(j);
            backTrack(path,k,n,j+1);
            path.remove(path.size()-1);
        }
    }
}