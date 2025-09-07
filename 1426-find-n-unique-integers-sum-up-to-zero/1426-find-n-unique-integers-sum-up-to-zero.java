class Solution {
    public int[] sumZero(int n) {
        int[] result= new int[n];
        int i=0;
        if(n%2==1) result[i++]=0;
        while(i<n){
            result[i]=i+1;
            result[i+1]=-(i+1);
            i+=2;
        }
        return result;
    }
}