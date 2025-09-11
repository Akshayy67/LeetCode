class Solution {
    public String sortVowels(String s) {
        List<Character> lst= new ArrayList<>();
        for(char c:s.toCharArray()){
            if("AEIOUaeious".indexOf(c)!=-1) lst.add(c);
        }
        Collections.sort(lst);
        int i=0;
        char chars[] = s.toCharArray();
        for(int j=0;j<chars.length;j++){
            if(("AEIOUaeious".indexOf(chars[j])!=-1)) chars[j]=lst.get(i++); 
        } 
        return new String(chars);
    }
}