class Solution {
    public int possibleStringCount(String word) {
        int result=0;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)==word.charAt(i-1)) result++;
        }
        return result+1;
    }
}