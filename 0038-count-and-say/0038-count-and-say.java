class Solution {
    public String countAndSay(int n) {
        StringBuilder result=rec(new StringBuilder().append(1),n-1);
        return result.toString();
    }
    public StringBuilder rec(StringBuilder path,int n){
        if(n==0) return path;
        StringBuilder temp= new StringBuilder();
        int i=1,count=1;
        while(i<path.length()){
            if(path.charAt(i)!=path.charAt(i-1)){
                temp.append(count);
                temp.append(path.charAt(i-1));
                count=1;
                i++;
            }
            else{
                i++;
                count++;
            }
        }
        temp.append(count);
        temp.append(path.charAt(path.length()-1));
        return rec(temp,n-1);
    }
}