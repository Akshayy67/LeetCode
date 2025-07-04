class Solution {
    public char kthCharacter(long k, int[] operations) {
        if(k==1) return 'a';
        int presentInPower=(int)Math.ceil(Math.log(k)/Math.log(2));
        int jump=presentInPower-1;
        char result= (char)(kthCharacter(k-(long)Math.pow(2,jump), operations)+operations[jump]); 
        if(result>'z') result='a';
        return result;
    }
}