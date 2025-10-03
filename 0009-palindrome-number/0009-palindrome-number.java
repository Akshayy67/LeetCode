class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder str= new StringBuilder().append(x);
        return str.toString().equals(str.reverse().toString());
    }
}