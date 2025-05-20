class Solution {
    List<String> result;
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        helper(s,0,0,new StringBuilder());
        return result;
    }
    public void helper(String s,int idx, int count,StringBuilder path){
        if(count==4){
            if(idx==s.length()) result.add(path.toString());
            return;
        }
        if(idx>=s.length()) return;
        if(s.charAt(idx)=='0') {
            if(count>0)path.append(".0");
            else path.append("0");
            helper(s,idx+1,count+1,path);
            path.setLength(path.length()- (count>0?2:1));
        }
        else{
            for(int i=1;i<=3;i++){
                if(idx+i> s.length()) break;
                String sub=s.substring(idx,idx+i);
                int temp=Integer.parseInt(sub);
                if(temp>255) break;
                if(count>0)path.append(".");
                path.append(sub);
                helper(s,idx+i,count+1,path);
                path.setLength(path.length()-sub.length()-(count>0?1:0));
            }
        }
    }
}