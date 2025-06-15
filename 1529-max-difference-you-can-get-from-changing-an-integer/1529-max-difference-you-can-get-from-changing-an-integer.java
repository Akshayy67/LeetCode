class Solution {
    public int maxDiff(int num) {
        Set<Character> st= new HashSet<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        String number= String.valueOf(num);
        for(int i=0;i<number.length();i++){
            number= String.valueOf(num);
            if(st.contains(number.charAt(i))) continue;
            st.add(number.charAt(i));
            if(i!=0){
                number=number.replace(number.charAt(i),'0');
                try{
                    int cur=Integer.parseInt(number);
                    max=Math.max(max,cur);
                    min=Math.min(min,cur);
                }
                catch(Exception e){

                }
            }
            for(char j='1';j<='9';j++){
                number=String.valueOf(num);
                number=number.replace(number.charAt(i),j);
                try{
                    int cur=Integer.parseInt(number);
                    max=Math.max(max,cur);
                    min=Math.min(min,cur);
                }
                catch(Exception e){

                }
            }
        }
        return max-min;
    }
}