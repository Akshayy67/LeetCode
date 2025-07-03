class Solution {
    public char kthCharacter(int k) {
        StringBuilder str= new StringBuilder();
        str.append('a');
        while(str.length()<=k){
            str.append(helper(str));
        }
        return str.charAt(k-1);
    }
    public StringBuilder helper(StringBuilder str){
        StringBuilder temp= new StringBuilder();
        for(char c:str.toString().toCharArray()){
            char cur=c;
            if(c=='z') cur='z';
            else cur=(char)(cur+1); 
            temp.append(cur);
        }
        return temp;
    }
}