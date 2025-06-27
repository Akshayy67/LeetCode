class Solution {
    public int countSubstrings(String s) {
        int i=0,count=0;
        while(i+1<s.length()){
            count+=palins(s,i,i+1);
            i++;
        }
        i=0;
        while(i<s.length())
        count+=palins(s,i,i++);
        return count;
    }
    public int palins(String s,int st,int end){
        int count=0;
        while(st>=0 && end<s.length()){
            if(s.charAt(st)==(s.charAt(end))){
                st--;
                end++;
                count++;
            }
            else break;
        }
        return count;
    }
}