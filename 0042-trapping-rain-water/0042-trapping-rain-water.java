class Solution {
    public int trap(int[] height) {
        int result=0,leftmax=0,rightmax=0;
        int i=0,j=height.length-1;
        while(i<j){
            if(height[i]<height[j]){
                if(height[i]<leftmax){
                    result+=leftmax-height[i];
                }
                leftmax=Math.max(leftmax,height[i]);
                i++;
            }
            else if(height[j]<height[i]){
                if(height[j]<rightmax){
                    result+=rightmax-height[j];
                }
                rightmax=Math.max(rightmax,height[j]);
                j--;
            }
            else{
                leftmax=Math.max(leftmax,height[i]);
                i++;
            }
        }
        return result;
    }
}