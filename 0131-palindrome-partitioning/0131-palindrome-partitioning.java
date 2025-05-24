class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result= new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return result;
    }
    public void helper(String s,int i,List<String> list){
        if(i==s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int idx=i;idx<s.length();idx++){
            String sub=s.substring(i,idx+1);
            if(isPalin(sub)){
                list.add(sub);
                helper(s,idx+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalin(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}