class Solution {
    public int maxProduct(String[] words) {
        int[] masks= new int[words.length];
        for(int i=0;i<masks.length;i++){
            String word=words[i];
            for(char c:word.toCharArray()){
                masks[i]|=(1<<(c-'a'));
            }
        }
        int result=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((masks[i]&masks[j])==0){
                    result= Math.max(result,words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}