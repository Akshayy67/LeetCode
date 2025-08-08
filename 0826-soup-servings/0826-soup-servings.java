class Solution {
    Map<String,Double> mp= new HashMap<>();
    public double soupServings(int n) {
        if(n>=4500) return 1.0;
        return helper(n,n);
    }
    public double helper(int a,int b){
        if(a<=0 && b<=0) return 0.5;
        if(a<=0) return 1.0;
        if(b<=0) return 0.0;
        String key=a+" "+b;
        if(mp.containsKey(key)) return mp.get(key);
        double res=0.25*(helper(a-100,b-0)+helper(a-75,b-25)+helper(a-50,b-50)+helper(a-25,b-75));
        mp.put(key,res);
        return res;
    }
}