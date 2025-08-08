class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        int wordCount=words.length;
        int wordLength=words[0].length();
        int totLength=wordCount*words[0].length();
        if(s.length()<totLength) return result;
        Map<String,Integer> target= new HashMap<>();
        for(String str:words) target.put(str,target.getOrDefault(str,0)+1);
        for(int i=0;i<wordLength;i++){
            int left=i,right=i,count=0;
            Map<String,Integer> cur= new HashMap<>();
            while(right+wordLength<=s.length()){
                String sub=s.substring(right,right+wordLength);
                right+=wordLength;
                if(target.containsKey(sub)){
                    cur.put(sub,cur.getOrDefault(sub,0)+1);
                    count++;
                    while(cur.get(sub)>target.get(sub)){
                        String toRemove= s.substring(left,left+wordLength);
                        cur.put(toRemove,cur.get(toRemove)-1);
                        left+=wordLength;
                        count--;
                    }
                    if(count==wordCount){
                        result.add(left);
                    }
                }
                else{
                    count=0;
                    cur.clear();
                    left=right;
                }
            }
        }
        return result;
    }
}