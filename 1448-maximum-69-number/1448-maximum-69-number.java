class Solution {
    public int maximum69Number (int num) {
        List<Integer> list= new ArrayList<>();
        while(num>0){
            list.add(0,num%10);
            num=num/10;
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i)==6){
                list.set(i,9);
                break;
            }
        }
        for(int n:list){
            num=num*10+n;
        }
        return num;
    }
}