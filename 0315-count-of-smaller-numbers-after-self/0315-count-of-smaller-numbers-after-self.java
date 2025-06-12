class Pair{
    int num,count,idx;
    public Pair(int num,int idx){
        this.num=num;
        this.idx=idx;
        count=0;
    }
}
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Pair[] p= new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            p[i]= new Pair(nums[i],i);
        }
        mergeSort(p,0,p.length-1);
        Arrays.sort(p,(a,b)->a.idx-b.idx);
        List<Integer> result= new ArrayList<>();
        for(int i=0;i<p.length;i++){
            result.add(p[i].count);
        }
        return result;
    }
    public void mergeSort(Pair[] list,int low,int high){
        if(low<high){
            int mid=(high-low)/2+low;
            mergeSort(list,low,mid);
            mergeSort(list,mid+1,high);
            merge(list,low,mid,high);
        }
    }
    public void merge(Pair[] list,int low,int mid,int high){
        Pair[] temp= new Pair[high-low+1];
        int i=low,j=mid+1,k=0;
        while(i<=mid && j<=high){
            if(list[i].num <=list[j].num){
                temp[k++]=list[j++];
            }
            else{
                list[i].count+=(high-j+1);
                temp[k++]=list[i++];
            }
        }
        while(i<=mid){
            temp[k++]=list[i++];
        }
        while(j<=high){
            temp[k++]=list[j++];
        }
        for(i=low;i<=high;i++){
            list[i]=temp[i-low];
        }
    }
}