class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int result=0;
        for(String s:operations){
            boolean add=false;
            if(s.charAt(0)=='X'){
                add=s.charAt(1)=='+';
            }
            else{
                add=s.charAt(0)=='+';
            }
            result+=(add)?1:-1;
        }
        return result;
    }
}