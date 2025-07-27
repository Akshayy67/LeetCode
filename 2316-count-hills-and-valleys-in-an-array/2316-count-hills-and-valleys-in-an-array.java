class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> list= new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(list.get(list.size()-1)==nums[i]){
                continue;
            }
            list.add(nums[i]);
        }
        int result=0;
        for(int i=1;i<list.size()-1;i++){
            if(list.get(i)>list.get(i-1) && list.get(i)>list.get(i+1)){
                result++;
            }
            if(list.get(i)<list.get(i-1) && list.get(i)<list.get(i+1)){
                result++;
            }
        }
        return result;
    }
}