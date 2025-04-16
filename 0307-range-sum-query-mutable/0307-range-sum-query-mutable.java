class NumArray {
    int[] segTree;
    int[] numbers;
    public NumArray(int[] nums) {
       segTree=new int[nums.length*4];
       numbers= new int[nums.length];
       for(int i=0;i<nums.length;i++) numbers[i]=nums[i];
       build(nums,0,nums.length-1,0); 
    //    for(int num:segTree) System.out.print(num+" ");
    //    System.out.println();
    }
    public void build(int[] nums,int l,int r,int idx){
        if(l==r){
            segTree[idx]=nums[l];
            return;
        }
        int mid=(l+r)/2;
        build(nums,l,mid,idx*2+1);
        build(nums,mid+1,r,idx*2+2);
        segTree[idx]=segTree[idx*2+1]+segTree[2*idx+2];
    }
    public void update(int index, int val) {
        updateHelper(index,0,numbers.length-1, val,0);
    //    for(int num:segTree) System.out.print(num+" ");
    }
    public void updateHelper(int idx,int l,int r,int val,int segIdx){
        if(l==r){
            segTree[segIdx]=val;
            numbers[idx]=val;
            return;
        }
        int mid=(l+r)/2;
        if(idx>mid) updateHelper(idx,mid+1,r,val,segIdx*2+2);
        else updateHelper(idx,l,mid,val,segIdx*2+1);
        segTree[segIdx]=segTree[segIdx*2+1]+segTree[segIdx*2+2];
    }
    
    public int sumRange(int left, int right) {
        return sumHelper(left,right,0,numbers.length-1,0);
    }
    public int sumHelper(int l,int r,int cur_l,int cur_r,int idx){
        if(cur_r<l || cur_l>r) return 0;
        if(cur_l>=l && cur_r<=r) return segTree[idx];
        int mid=(cur_l+cur_r)/2;
        return sumHelper(l,r,cur_l,mid,idx*2+1)+sumHelper(l,r,mid+1,cur_r,idx*2+2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */