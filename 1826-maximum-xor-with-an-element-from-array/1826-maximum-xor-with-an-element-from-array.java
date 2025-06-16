class TNode{
    TNode child[] = new TNode[2];
}
class Trie{
    TNode root= new TNode();
    void insert(int num){
        TNode cur= root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(cur.child[bit]==null) cur.child[bit]= new TNode();
            cur=cur.child[bit];
        }
    }
    int query(int num){
        TNode cur= root;
        int max=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            int opp=1-bit;
            if(cur.child[opp]!=null){
                max|=(1<<i);
                cur=cur.child[opp];
            }
            else{
                cur=cur.child[bit];
            }
        }
        return max;
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] quer) {
        Trie trie= new Trie();
        int[] result= new int[quer.length];
        Arrays.sort(nums);
        int[][] queries= new int[quer.length][3];
        for(int i=0;i<quer.length;i++){
            queries[i][0]=quer[i][0];
            queries[i][1]=quer[i][1];
            queries[i][2]=i;
        }
        int i=0,j=0;
        Arrays.sort(queries,(a,b)-> a[1]-b[1]);
        for(int[] q:queries){
            while(i<nums.length && nums[i]<=q[1]){
                trie.insert(nums[i++]);
            }
            if(i==0){
                result[q[2]]=-1;
            }
            else{
                result[q[2]]=trie.query(q[0]);
            }
        }
        return result;
    }
}