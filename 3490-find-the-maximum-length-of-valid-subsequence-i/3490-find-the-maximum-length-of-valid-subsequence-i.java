class Solution {
    public int maximumLength(int[] nums) {
        int odd=0,even=0,oddseq=0,evnseq=0;
        for(int num:nums){
            if(num%2==0){
                even++;
                if(evnseq%2==0) evnseq++;
                if(oddseq%2==1) oddseq++;
            }
            else{
                odd++;
                if(evnseq%2==1) evnseq++;
                if(oddseq%2==0) oddseq++;
            }
        }
        return Math.max(Math.max(even,odd),Math.max(evnseq,oddseq));
    }
}