class Solution {
    public int longestPalindrome(String[] words) {
        boolean ip = false;
        Map<String, Integer> mp = new HashMap<>();
        for (String s : words) {
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }
        int result = 0;
        for (String s : mp.keySet()) {
            String rev= new StringBuilder(s).reverse().toString();
            if(!s.equals(rev)){
                if(mp.containsKey(rev)){
                    int min=Math.min(mp.get(s),mp.get(rev));
                    result+=min*4;
                    mp.put(rev,mp.get(rev)-min);
                    mp.put(s,mp.get(s)-min);
                }
            }
            else{
                int min=mp.get(s)/2;
                result+=min*4;
                if(mp.get(s)%2==1) ip=true;
            }
        }
        if (ip)
            result += 2;
        return result;
    }
}