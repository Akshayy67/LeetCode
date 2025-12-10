class Solution {
    int mod=(int)1e9+7;
    public int countPermutations(int[] complexity) {
        int first=complexity[0];
        long fact=1;
        for(int i=1;i<complexity.length;i++){
            if(complexity[i]<=first) return 0;
            fact=(fact*i)%mod;
        }
        return (int)fact;
    }
}