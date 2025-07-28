class Solution {
    List<String> list;
    public String getPermutation(int n, int k) {
        list= new ArrayList<>();
        helper(n,0,new StringBuilder());
        return list.get(k-1);
    }
    public void helper(int n,int mask,StringBuilder str){
        if(mask==((1<<n)-1)){
            list.add(str.toString());
            return;
        }
        for(int i=1;i<=n;i++){
            if(((mask>>(i-1))&1)==0){
                mask|=(1<<(i-1));
                str.append(i);
                helper(n,mask,str);
                str.setLength(str.length()-1);
                mask&=~(1<<(i-1));
            }
        }
    }
}