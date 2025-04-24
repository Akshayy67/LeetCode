class Solution {
    public int minAddToMakeValid(String s) {
        int count=0,cur=0;
        for(char c:s.toCharArray()){
            if(c=='(') cur++;
            else{
                if(cur==0) count++;
                else cur--;
            }
        }
        return count+cur;
    }
}