class Solution {
    public int smallestNumber(int n) {
        String s=Integer.toBinaryString(n);
        char[] chars=s.toCharArray();
        for(int i=0;i<s.length();i++){
            chars[i]='1';
        }
        return Integer.parseInt(new String(chars),2);
    }
}