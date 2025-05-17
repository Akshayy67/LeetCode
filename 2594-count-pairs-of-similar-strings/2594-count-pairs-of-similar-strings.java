class Solution {
    public int similarPairs(String[] words) {
        Map<String,Integer> mp= new HashMap<>();
        int result=0;
        for(String word:words){
            Set<Character> st= new TreeSet<>();
            for(char c:word.toCharArray()){
                st.add(c);
            }
            StringBuilder s=new StringBuilder();
            for(char c:st) s.append(c);
            String str= s.toString();
            mp.put(str,mp.getOrDefault(str,0)+1);
        }
        for(String s:mp.keySet()){
            int count=mp.get(s);
            result+=((count)*(count-1))/2;
        }
        return result;
    }
}