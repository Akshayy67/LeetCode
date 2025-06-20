class Solution {
    public int maxDistance(String s, int k) {
        int result=0,x=0,y=0,i=1;
        for(char c:s.toCharArray()){
            if(c=='N') y++;
            if(c=='S') y--;
            if(c=='E') x++;
            if(c=='W') x--;
            int dis=Math.abs(x)+Math.abs(y);
            int ans=dis+Math.min(2*k,i-dis);
            result=Math.max(result,ans);
            i++;
        }
        return result;
    }
}