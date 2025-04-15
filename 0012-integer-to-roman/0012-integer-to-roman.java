class pair{
    int num;
    String s;
    pair(int num,String s){
        this.num=num;
        this.s=s;
    }
}
class Solution {
    public String intToRoman(int num) {
        List<pair> list= new ArrayList<>();
        list.add(new pair(1000,"M")); 
        list.add(new pair(900,"CM")); 
        list.add(new pair(500,"D")); 
        list.add(new pair(400,"CD"));
        list.add(new pair(100,"C")); 
        list.add(new pair(90,"XC")); 
        list.add(new pair(50,"L")); 
        list.add(new pair(40,"XL")); 
        list.add(new pair(10,"X")); 
        list.add(new pair(9,"IX"));
        list.add(new pair(5,"V"));
        list.add(new pair(4,"IV"));
        list.add(new pair(1,"I"));
        StringBuilder str= new StringBuilder();
        for(pair p:list){
            while(num>=p.num){
                num-=p.num;
                str.append(p.s);
            }
        }
        return str.toString();
    }
}