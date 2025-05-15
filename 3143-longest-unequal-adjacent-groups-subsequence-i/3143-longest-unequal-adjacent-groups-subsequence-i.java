class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
       List<String> result= new ArrayList<>();
       for(int i=0;i<words.length;i++){
            int n=(i==words.length-1)?5:groups[i+1];
            if(groups[i]!=n) result.add(words[i]);
       }
       return result;
    }
}