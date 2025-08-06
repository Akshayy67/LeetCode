class Solution {
    int[] segTree;
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        segTree= new int[n*4+1];
        Arrays.fill(segTree,Integer.MIN_VALUE);
        build(baskets,0,0,n-1);
        int result=0;
        for(int i=0;i<n;i++){
            int l=0,r=n-1;
            int res=-1;
            while(l<=r){
                int mid=(l+r)/2;
                if(query(0,0,n-1,0,mid)>=fruits[i]){
                    res=mid;
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            if(res!=-1 && baskets[res]>=fruits[i]){
                baskets[res]=0;
                update(0,0,n-1,res,0);
            }
            else result++;
        }
        return result;
    }
    public void build(int[] baskets,int idx,int l,int r){
        if(l==r){
            segTree[idx]=baskets[l];
            return;
        }
        int mid=(l+r)>>1;
        build(baskets,(idx<<1)+1,l,mid);
        build(baskets,(idx<<1)+2,mid+1,r);
        segTree[idx]=Math.max(segTree[(idx<<1)+1],segTree[(idx<<1)+2]);
    }
    public int query(int idx,int l,int r,int ql,int qr){
        if(ql>r || qr<l) return Integer.MIN_VALUE;
        if(ql<=l && r<=qr) return segTree[idx];
        int mid=(l+r)>>1;
        return Math.max(query((idx<<1)+1,l,mid,ql,qr),query((idx<<1)+2,mid+1,r,ql,qr));
    }
    public void update(int idx,int l, int r,int pos,int v){
        if(l==r){
            segTree[idx]=v;
            return;
        }
        int mid=(l+r)/2;
        if(pos<=mid){
            update(idx*2+1,l,mid,pos,v);
        }
        else{
            update(idx*2+2,mid+1,r,pos,v);
        }
        segTree[idx]=Math.max(segTree[(idx<<1)+1],segTree[(idx<<1)+2]);
    }
}