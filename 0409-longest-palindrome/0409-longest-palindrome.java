class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> mp= new HashMap<>();
        for(char c:s.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        int result=0;
        for(char c:mp.keySet()){
            result+=(mp.get(c)/2)*2;
        }
        return result==s.length()?result:result+1;
    }
}