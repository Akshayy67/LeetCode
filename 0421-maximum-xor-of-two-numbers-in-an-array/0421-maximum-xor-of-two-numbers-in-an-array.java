class TNode{
    TNode[] child= new TNode[2];
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
    int findMax(int[] nums){
        int max=0;
        insert(nums[0]);
        for(int i=1;i<nums.length;i++){
            max=Math.max(max,query(nums[i]));
            insert(nums[i]);
        }
        return max;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie= new Trie();
        return trie.findMax(nums);
    }
}