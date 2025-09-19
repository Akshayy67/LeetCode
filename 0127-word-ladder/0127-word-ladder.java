class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q= new LinkedList<>();
        Set<String> list= new HashSet<>();
        for(String s:wordList) list.add(s);
        if(!list.contains(endWord)) return 0;
        int steps=1;
        q.add(beginWord);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String cur=q.poll();
                char[] chars= cur.toCharArray();
                for(int i=0;i<chars.length;i++){
                    char org=chars[i];
                    for(char c='a';c<='z';c++){
                        chars[i]=c;
                        String next= new String(chars);
                        if(next.equals(endWord)) return steps+1;
                        if(list.contains(next)){
                            q.add(next);
                        }
                        list.remove(next);
                    }
                    chars[i]=org;
                } 
            }
            steps++;
        }
        return 0;
    }
}