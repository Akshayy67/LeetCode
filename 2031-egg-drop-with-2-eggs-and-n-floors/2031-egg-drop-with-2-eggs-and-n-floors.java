class Solution {
    public int twoEggDrop(int n) {
        int i=0;
        while(true){
            int sum= i*(i+1)/2;
            if(sum>=n) return i;
            i++;
        }
    }
}