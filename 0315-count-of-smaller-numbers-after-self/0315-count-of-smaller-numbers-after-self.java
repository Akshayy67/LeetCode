class Pair{
    int num,index,count;
    Pair(int num,int index){
        this.num=num;
        this.index=index;
        count=0;
    }
}
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Pair[] list= new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            list[i]= new Pair(nums[i],i);
        }
        mergeSort(list,0,nums.length-1);
        List<Integer> result= new ArrayList<>();
        Arrays.sort(list,(a,b)->a.index-b.index);
        for(int i=0;i<nums.length;i++){
            result.add(list[i].count);
            System.out.println(list[i].num+" "+list[i].count);
        }
        return result;
    }
    public void mergeSort(Pair[] list,int l,int r){
        if(l<r){
            int mid=(r-l)/2+l;
            mergeSort(list,l,mid);
            mergeSort(list,mid+1,r);
            merge(list,l,mid,r);
        }
    }
    public void merge(Pair[] list,int l,int mid,int r){
        Pair[] temp= new Pair[r-l+1];
        int i=l,j=mid+1,k=0;
        while(i<=mid && j<=r){
            if(list[i].num<=list[j].num){
                temp[k++]=list[j++];
            }
            else{
                list[i].count+=(r-j+1);
                temp[k++]=list[i++];
            }
        }
        while(i<=mid) temp[k++]=list[i++];
        while(j<=r) temp[k++]=list[j++];
        k=0;i=l;
        while(i<=r){
            list[i++]=temp[k++];
        }
    }
}