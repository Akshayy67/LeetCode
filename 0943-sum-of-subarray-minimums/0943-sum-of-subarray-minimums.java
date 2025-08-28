class Solution {
    int mod=(int)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        int[] ns=nse(arr);
        int[] ps=peos(arr);
        long ans=0;
        for(int i=0;i<arr.length;i++){
            long next_range=ns[i]-i;
            long prev_range=i-ps[i];
            // System.out.println(next_range+" "+prev_range);
            ans=(ans+next_range*prev_range*arr[i])%mod;
        }
        return (int) ans;
    }
    public int[] nse(int[] arr){
        int n=arr.length;
        int[] ns= new int[n];
        Arrays.fill(ns,n);
        Stack<Integer> stk= new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && arr[stk.peek()]>arr[i]){
                ns[stk.pop()]=i;
            }
            stk.push(i);
        }
        return ns;
    }
    public int[] peos(int[] arr){
        int n=arr.length;
        int[] ps= new int[n];
        Arrays.fill(ps,-1);
        Stack<Integer> stk= new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i]){
                ps[stk.pop()]=i;
            }
            stk.push(i);
        }
        return ps;
    }
}