class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int result=0;
        int max=0;
        for(int[] dim:dimensions){
            int d=dim[0]*dim[0] + dim[1]*dim[1];
            int area=dim[0]*dim[1];
            if(d>max){
                result=area;
                max=d;
                System.out.println(d+" "+result);
            }else if(d==max){
                result=Math.max(result,area);
            }
        }
        return result;
    }
}