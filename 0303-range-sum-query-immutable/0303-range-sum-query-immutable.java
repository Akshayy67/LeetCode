class NumArray {
    int[] pre;
    public NumArray(int[] nums) {
        pre= new int[nums.length+1];
        for(int i=0;i<nums.length;i++) pre[i+1]=nums[i]+pre[i];
    }
    
    public int sumRange(int left, int right) {
        return pre[right+1]-pre[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */