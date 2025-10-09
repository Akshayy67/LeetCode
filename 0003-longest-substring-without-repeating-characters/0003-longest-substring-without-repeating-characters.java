class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st= new HashSet<>();
        int i=0,j=0;
        int result=0;
        while(i<s.length()){
            while(st.contains(s.charAt(i))) st.remove(s.charAt(j++));
            result=Math.max(result,i-j+1);
            st.add(s.charAt(i));
            i++;
        }
        return result;
    }
}