class Solution {
    String vowel="aeiou";
    public int maxVowels(String s, int k) {
        int count=0,max=0;
        for(int i=0;i<s.length();i++){
            if(vowel.indexOf(s.charAt(i))!=-1) count++;
            if(i>=k-1){
                if(i>=k && vowel.indexOf(s.charAt(i-k))!=-1) count--;
                max=Math.max(max,count);
            }
        }
        return max;
    }
}