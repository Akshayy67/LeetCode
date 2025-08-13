class Pair{
    String s;
    int count;
    public Pair(String s,int count){
        this.s=s;
        this.count=count;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q= new LinkedList<>();
        Set<String> st= new HashSet<>();
        for(String str:wordList) st.add(str);
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair pair=q.poll();
            String cur=pair.s;
            char[] chars=cur.toCharArray();
            for(int i=0;i<chars.length;i++){
                char original=chars[i];
                for(char c='a';c<='z';c++){
                    if(c==original) continue;
                    chars[i]=c;
                    String temp= new String(chars);
                    if(st.contains(temp)){
                        if(temp.equals(endWord)) return pair.count+1;
                        q.add(new Pair(temp,pair.count+1));
                        st.remove(temp); 
                    }
                }
                chars[i]=original;
            } 
        }
        return 0;
    }
}