class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] parents= new int[nums.length];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]>maxDiff) parents[i]=i;
            else parents[i]=parents[i-1];
        }
        boolean[] result= new boolean[queries.length];
        int i=0;
        for(int[] q:queries){
            if(parents[q[0]] == parents[q[1]]) result[i++]=true;
            else result[i++]=false;
        }
        return result;
    }
}