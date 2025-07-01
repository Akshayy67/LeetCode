class Solution {
    public int possibleStringCount(String word) {
        int j=0,result=0;
        for(int i=0;i<word.length();i++){
            while(word.charAt(i)!=word.charAt(j)) j++;
            if(i-j>=1) result++;
        }
        return result+1;
    }
}