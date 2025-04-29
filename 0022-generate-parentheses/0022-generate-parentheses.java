class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result= new ArrayList<>();
        StringBuilder path= new StringBuilder();
        path.append('(');
        backTrack(n-1,1,path);
        return result;
    }
    public void backTrack(int n,int count ,StringBuilder path){
        if(n==0 && count==0) {
            result.add(path.toString());
            return;
        }
        if(n>0){
            path.append('(');
            backTrack(n-1,count+1,path);
            path.setLength(path.length()-1);
        }
        if(count>0){
            path.append(')');
            backTrack(n,count-1,path);
            path.setLength(path.length()-1);
        }
    }
}