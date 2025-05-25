class Solution {
    public boolean isStrictlyPalindromic(int n) {
        int b=n-2;
        String seq="";
        while(n>0){
            seq=seq+""+(n%b);
            n=n/b;
        }
        System.out.println(seq);
        return false;
    }
}