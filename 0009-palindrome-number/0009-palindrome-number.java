class Solution {
    public boolean isPalindrome(int x) {
       String num=String.valueOf(x);
       return new StringBuilder(num).reverse().toString().equals(num);
    }
}