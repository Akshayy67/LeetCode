class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result= new ArrayList<>();
        result.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(!isAnagram(words[i],result.get(result.size()-1))){
                result.add(words[i]);
            }
        }
        return result;
    }
    public boolean isAnagram(String a,String b){
        char[] charsA=a.toCharArray();
        char[] charsB=b.toCharArray();
        Arrays.sort(charsA);
        Arrays.sort(charsB);
        String aa=new String(charsA);
        String bb=new String(charsB);
        return aa.equals(bb);
    }
}