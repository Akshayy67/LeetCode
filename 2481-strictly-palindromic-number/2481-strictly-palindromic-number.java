class Solution {
    public boolean isStrictlyPalindromic(int n) {
        int b=n-2;
        StringBuilder seq= new StringBuilder();
        while(n>0){
            seq.append(n%b);
            n=n/b;
        }
        System.out.println(seq);
        return false;
    }
}