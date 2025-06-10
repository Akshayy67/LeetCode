class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] result= new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int q=queries[i];
            int sum=0,count=0;
            for(int num:nums){
                sum+=num;
                if(sum>q) break;
                count++;
            }
            result[i]=count;
        }
        return result;
    }
}