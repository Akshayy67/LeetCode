class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp= new HashMap<>();
        for(String s:strs){
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            String str=new String(chars);
            mp.putIfAbsent(str,new ArrayList<>());
            mp.get(str).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}