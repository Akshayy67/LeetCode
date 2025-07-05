//     Time is: O(n!⋅n⋅L)

// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         if(!wordList.contains(endWord)) return 0;
//         int level=1;
//         Queue<String> q= new LinkedList<>();
//         Set<String> st= new HashSet<>(wordList);
//         st.remove(beginWord);
//         q.add(beginWord);
//         while(!q.isEmpty()){
//             int size=q.size();
//             while(size-->0){
//                 String cur=q.poll();
//                 for(String temp:new HashSet<>(st)){
//                     if(dif(cur,temp)){
//                         if(temp.equals(endWord)) return level+1;
//                         st.remove(temp);
//                         q.add(temp);
//                     }
//                 }
//             }
//             level++;
//         }
//         return 0;
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


     //Time is  O(N × M × N)

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

//  Time is: O(N × M × 26) = O(NM)

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
        Set<String> st= new HashSet<>();
        for(String str:wordList){
            st.add(str);
        }
        // If endWord is not in wordList, transformation is impossible
        if(!st.contains(endWord)) return 0;
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair cur=q.poll();
            String word=cur.s;
            char[] chars=word.toCharArray(); 
            for(int i=0;i<word.length();i++){
                char original=chars[i];
                //generate all the next words
                for(char c='a';c<='z';c++){
                    if(c==original) continue;
                    chars[i]=c;
                    String next=new String(chars);
                    // if generated word is in set then add to queue
                    if(st.contains(next)){
                        if(next.equals(endWord)) return cur.count+1;
                        q.add(new Pair(next,cur.count+1));
                        st.remove(next);
                    }
                }
                chars[i]=original;
            }
        }
        return 0;
    }
}