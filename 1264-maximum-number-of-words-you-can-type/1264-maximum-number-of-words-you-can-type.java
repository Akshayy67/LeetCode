class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> st = new HashSet<>();
        for(char c:brokenLetters.toCharArray()){
            st.add(c);
        }
        int result=0;
        for(String s:text.split(" ")){
            int i=0;
            for(i=0;i<s.length();i++){
                if(st.contains(s.charAt(i))) break;
            }
            if(i==s.length()) result++;
        }
        return result;
    }
}