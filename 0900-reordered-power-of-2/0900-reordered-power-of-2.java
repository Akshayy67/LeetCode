class Solution {
    public boolean reorderedPowerOf2(int n) {
       char[] sortedN= String.valueOf(n).toCharArray();
       Arrays.sort(sortedN);
       String pat=new String(sortedN);
       for(int i=0;i<31;i++){
        char[] iPow=String.valueOf(1<<i).toCharArray();
        Arrays.sort(iPow);
        if(pat.equals(new String(iPow))){
            return true;
        }
       }
       return false;
    }
}