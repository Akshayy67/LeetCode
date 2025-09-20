class Solution {
    List<String> result;
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        result= new ArrayList<>();
        helper(digits,0,new StringBuilder());
        return result;
    }
    public void helper(String digits, int i,StringBuilder path){
        if(i==digits.length()){
            result.add(path.toString());
            return;
        }
        int num=digits.charAt(i)-'2';
        int start=(num>5)?3*num+1:3*num;
        int end=(num==5 || num==7)?4:3;
        for(int idx=0;idx<end;idx++){
            path.append((char)(start+'a'));
            helper(digits,i+1,path);
            path.setLength(path.length()-1);
            start++;
        }
    }
}