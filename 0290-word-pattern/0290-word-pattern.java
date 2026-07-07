class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> mp= new HashMap<>();
        Map<String,Character> mp2= new HashMap<>();
        String[] arry= s.split(" ");
        if(pattern.length()!=arry.length) return false;
        for(int i=0;i<pattern.length();i++){
            if(mp.containsKey(pattern.charAt(i))){
                if(!mp.get(pattern.charAt(i)).equals(arry[i])) return false;
            }
            else if(mp2.containsKey(arry[i]) && mp2.get(arry[i])!=pattern.charAt(i)) return false;
            else{
                mp.put(pattern.charAt(i),arry[i]);
                mp2.put(arry[i],pattern.charAt(i));
            }
        }
        return true;
    }
}