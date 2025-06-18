class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum=0;
        for(int i=0;i<nums.size();i++){
            if(hasKSets(i,k)){
                sum+=nums.get(i);
            }
        }
        return sum;
    }
    public boolean hasKSets(int num,int k){
        int count=0;
        while(num>0){
            if((num&1)==1) count++;
            num>>=1;
        }
        return k==count;
    }
}