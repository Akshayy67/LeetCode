class Solution {
    public int minMutation(String startGene, String endGene, String[] b) {
        Queue<String> q= new LinkedList<>();
        Set<String> bank = new HashSet<>();
        for(String s:b) bank.add(s);
        if(!bank.contains(endGene)) return -1;
        q.add(startGene);
        // st.add(startGene);
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String cur=q.poll();
                char[] chars= cur.toCharArray();
                for(int i=0;i<8;i++){
                    char org=chars[i];
                    for(char c:"ACGT".toCharArray()){
                        if(chars[i]==c) continue;
                        chars[i]=c;
                        String next=new String(chars);
                        if(bank.contains(next)){
                            if(next.equals(endGene)) return steps+1;
                            // if(!st.contains(next)){
                                // st.add(next);
                                q.add(next);
                            // }
                        }
                        bank.remove(next);
                    }
                    chars[i]=org;
                }
            }
            steps++;
        }
            return -1;
    }
}