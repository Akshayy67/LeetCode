class Solution {
    public int countSubstrings(String s) {
        int result=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalin(s,i,j)) result++;
            }
        }
        return result;
    }
    public boolean isPalin(String s,int i,int j){
        while(i<j && s.charAt(i)==s.charAt(j)){
            i++;j--;
        }
        return i>=j;
    }
}