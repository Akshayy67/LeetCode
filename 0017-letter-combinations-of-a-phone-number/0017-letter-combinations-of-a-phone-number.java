class Solution {
    List<String> result;
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        result= new ArrayList<>();
        rec(digits,0,new StringBuilder());
        return result;
    }
    public void rec(String digits,int i,StringBuilder path){
        if(i==digits.length()){
            result.add(path.toString());
            return;
        }
        int dial=digits.charAt(i)-'0';
        char c=((char) ('a'+3*(dial-2)));
        if(dial>7) c++;
        int n=3;
        if(dial==7 || dial==9) n=4;
        for(int idx=0;idx<n;idx++){
            path.append((char)(c+idx));
            rec(digits,i+1,path);
            path.setLength(path.length()-1);
        }
    }
}