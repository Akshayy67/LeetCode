class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || numRows>=s.length()) return s;
        List<List<Character>> list= new ArrayList<>();
        for(int i=0;i<numRows;i++) list.add(new ArrayList<>());
        int d=0,row=0,i=0;
        while(i<s.length()){
            list.get(row).add(s.charAt(i++));
            if(row==0) d=1;
            if(row==numRows-1) d=-1;
            row+=d;
        }
        StringBuilder str= new StringBuilder();
        for(List<Character> l:list){
            for(Character c:l) str.append(c); 
        }
        return str.toString();
    }
}