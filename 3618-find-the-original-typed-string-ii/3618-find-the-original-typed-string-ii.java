class Solution {
    int mod=(int) 1e9 +7;
    public int possibleStringCount(String word, int k) {
        int n=word.length();
        int cnt=1;
        List<Integer> freq= new ArrayList<>();
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)!=word.charAt(i-1)){
                freq.add(cnt);
                cnt=1;
            }
            else cnt++;
        }
        freq.add(cnt);
        long ans=1;
        for(int f:freq){
            ans=(ans*f)%mod;
        }
        if(freq.size()>=k) return (int)ans;
        int[] f= new int[k];
        int[] g= new int[k];
        f[0]=1;
        Arrays.fill(g,1);
        for(int i=0;i<freq.size();i++){
            int[] f_new= new int[k];
            for(int j=1;j<k;j++){
                f_new[j]=g[j-1];
                if(j-freq.get(i)-1>=0){
                    f_new[j]=(f_new[j]-g[j-freq.get(i)-1]+mod)%mod;
                }
            }
            int[] g_new = new int[k];
            for(int j=1;j<k;j++){
                g_new[j]=(g_new[j-1]+f_new[j])%mod;
            }
            f=f_new;
            g=g_new;
        }
        return (int)(ans-g[k-1]+mod)%mod;
    }
}