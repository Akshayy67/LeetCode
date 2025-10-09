class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mp= new HashMap<>();
        for(char c:t.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        int count=mp.size();
        int start_idx=-1,end_idx=-1,size=0;
        int i=0,j=0;
        while(i<s.length()){
            char c=s.charAt(i);
            mp.put(c,mp.getOrDefault(c,0)-1);
            if(mp.get(c)==0) count--;
            while(count==0){
                if(start_idx==-1){
                    start_idx=j;end_idx=i;
                    size=i-j+1;
                }
                else if(i-j+1<size){
                    size=i-j+1;
                    start_idx=j;end_idx=i;
                }
                char r=s.charAt(j);
                mp.put(r,mp.get(r)+1);
                if(mp.get(r)==1) count++;
                j++;
            }
            i++;
        }
        if(start_idx==-1) return "";
        return s.substring(start_idx,end_idx+1);
    }
}