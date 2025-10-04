class Solution {
    public int trap(int[] height) {
        int lmax=0,rmax=0,result=0;
        int i=0,j=height.length-1;
        while(i<j){
            if(height[i]>height[j]){
                if(rmax>height[j]){
                    result+=rmax-height[j];
                }
                rmax=Math.max(rmax,height[j]);
                j--;
            }
            else{
                if(lmax>height[i]){
                    result+=lmax-height[i];
                }
                lmax=Math.max(lmax,height[i]);
                i++;
            }
        }
        return result;
    }
}