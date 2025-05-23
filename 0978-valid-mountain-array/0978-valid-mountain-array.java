class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3) return false;
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                int j=i-1,k=i+1;
                while(j>=0 && arr[j]<arr[j+1]) j--;
                while(k<arr.length && arr[k]<arr[k-1]) k++;
                if(j==-1 && k==arr.length) return true;
                return false;
            }
        }
        return false;
    }
}