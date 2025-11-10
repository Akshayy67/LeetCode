class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stk= new Stack<>();
        int result=0;
        int i=0,j=nums.length-1;
        for(i=0;i<nums.length;i++) if(nums[i]>0) break;
        for(;j>=0;j--) if(nums[j]>0) break;
        for(;i<=j;i++){
            int num=nums[i];
            if(stk.isEmpty()){
                if(num==0) continue; 
                stk.push(num);
            }
            else{
                while(!stk.isEmpty() && stk.peek()>num){
                    result++;
                    stk.pop();
                }
                if(!stk.isEmpty() && stk.peek()==num) stk.pop();
                if(num!=0)stk.push(num); 
            }
        }
        return result+stk.size();
    }
}