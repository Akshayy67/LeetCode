class Solution {
    public int nextBeautifulNumber(int n){
        int i=n+1;
        while(true){
            int[] freq=findFreq(i);
            if(valid(freq)) break;
            i++;
        }
        return i;
    }
    public int[] findFreq(int n){
        int[] freq= new int[10];
        while(n>0){
            freq[n%10]++;
            n/=10;
        }
        return freq;
    }
    public boolean valid(int[] freq){
        for(int i=0;i<10;i++) if(freq[i]!=0 && freq[i]!=i) return false;
        return true;
    }
}