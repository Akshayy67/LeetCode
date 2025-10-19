class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        TreeSet<String> visited= new TreeSet<>();
        visited.add(s);
        Queue<String> q= new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            String cur=q.poll();
            char[] chars= cur.toCharArray();
            String rotated=rotate(chars,b);
            if(!visited.contains(rotated)){
                q.offer(rotated);
                visited.add(rotated);
            }
            String added=add(chars,a);
            if(!visited.contains(added)){
                q.offer(added);
                visited.add(added);
            }
        }
        return visited.first();
    }
    public String rotate(char[] chars,int i){
        StringBuilder str= new StringBuilder();
        i=i%chars.length;
        int start=i;
        str.append(chars[i]);
        i++;i%=chars.length;
        while(i!=start){
            str.append(chars[i]);
            i++;
            i%=chars.length;
        }
        return str.toString();
    }
    public String add(char[] chars,int a){
        for(int i=1;i<chars.length;i+=2){
            chars[i]=(char)('0'+((chars[i]-'0'+a)%10));
        }
        return new String(chars);
    }
}