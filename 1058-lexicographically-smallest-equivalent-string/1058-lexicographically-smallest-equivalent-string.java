class UFDS{
    int[] parent;
    public UFDS(){
        parent= new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
    }
    public int findParent(int i){
        if(parent[i]!=i) parent[i]=findParent(parent[i]);
        return parent[i];
    }
    public void union(int u,int v){
        int p1=findParent(u);
        int p2=findParent(v);
        if(p1!=p2){
            int temp=Math.max(p1,p2);
            p1=Math.min(p1,p2);
            p2=temp;
            parent[p2]=p1;
        }
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UFDS obj = new UFDS();
        for(int i=0;i<s1.length();i++){
            int n1=s1.charAt(i)-'a';
            int n2=s2.charAt(i)-'a';
            int p1=obj.findParent(n1);
            int p2=obj.findParent(n2);
            if(p1!=p2){
                obj.union(p1,p2);
            }
        }
        StringBuilder result= new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            char c=(char)(obj.findParent(baseStr.charAt(i)-'a')+'a');
            result.append(c);
        }
        return result.toString();
    }
}