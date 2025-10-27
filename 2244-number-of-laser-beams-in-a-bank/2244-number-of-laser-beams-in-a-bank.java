class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> list= new ArrayList<>();
        for(String s:bank){
            int count=0;
            for(char c:s.toCharArray()){
                if(c-'0'==1){
                     count++;
                }
            }
            if(count>0) list.add(count);
        }
        int result=0;
        for(int i=1;i<list.size();i++){
            result+=list.get(i)*list.get(i-1);
        }
        return result;
    }
}