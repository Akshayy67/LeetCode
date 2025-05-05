class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st= new HashSet<>();
        int i=0,j=0,max=0;
        for(i=0;i<s.length();i++){
            while(st.contains(s.charAt(i))){
                st.remove(s.charAt(j++));
            }
            st.add(s.charAt(i));
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}