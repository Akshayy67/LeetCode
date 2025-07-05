class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        int level=1;
        Queue<String> q= new LinkedList<>();
        Set<String> st= new HashSet<>(wordList);
        st.remove(beginWord);
        q.add(beginWord);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String cur=q.poll();
                for(String temp:new HashSet<>(st)){
                    if(dif(cur,temp)){
                        if(temp.equals(endWord)) return level+1;
                        st.remove(temp);
                        q.add(temp);
                    }
                }
            }
            level++;
        }
        return 0;
    }
    private boolean dif(String s1,String s2){
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) count++;
            if(count>1) return false;
        }
        return count==1;
    }
}
// class Solution {
//     int result=Integer.MAX_VALUE;
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> st= new HashSet<>();
//         st.add(beginWord);
//         helper(beginWord,endWord,wordList,st);
//         return result==Integer.MAX_VALUE?0:result;
//     }
//     public void helper(String bw,String ew,List<String> words,Set<String> st){
//         if(bw.equals(ew)){
//             result=Math.min(result,st.size());
//             return;
//         }
//         if(st.size()>=result) return;
//         for(String s:words){
//             if(!st.contains(s)){
//                 if(dif(bw,s)){
//                     st.add(s);
//                     helper(s,ew,words,st);
//                     st.remove(s);
//                 }
//             }
//         }
//     }
//     private boolean dif(String s1,String s2){
//         int count=0;
//         for(int i=0;i<s1.length();i++){
//             if(s1.charAt(i)!=s2.charAt(i)) count++;
//             if(count>1) return false;
//         }
//         return count==1;
//     }
// }