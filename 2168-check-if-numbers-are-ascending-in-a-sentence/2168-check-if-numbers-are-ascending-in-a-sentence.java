class Solution {
    public boolean areNumbersAscending(String str) {
        String[] strs= str.split(" ");
        int prev=-1;
        for(String s:strs){
            try{
                int num=Integer.parseInt(s);
                if(num<=prev) return false;
                prev=num;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        return true;
    }
}