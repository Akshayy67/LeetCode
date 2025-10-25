class Solution {
    public String reorganizeString(String s) {
        int[] freq= new int[26];
        for(char c:s.toCharArray()) freq[c-'a']++;
        int max=0, max_char=1;
        for(int i=0;i<26;i++){
            if(freq[i]>max){
                max_char=i;
                max=freq[i];
            }
        }
        if(max>(s.length()+1)/2) return "";
        int i=0;
        char[] result= new char[s.length()];
        while(freq[max_char]>0){
            result[i]=(char)(max_char+'a');
            freq[max_char]--;
            i+=2;
        }
        for(int j=0;j<26;j++){
            while(freq[j]>0){
                if(i>=s.length()) i=1;
                result[i]=(char)(j+'a');
                freq[j]--;
                i+=2;
            }
        }
        return new String(result);
    }
}