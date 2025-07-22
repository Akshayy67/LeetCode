class Solution {
    public int maximum69Number (int num) {
        char[] list= Integer.toString(num).toCharArray();
        for(int i=0;i<list.length;i++){
            if(list[i]=='6'){
                list[i]='9';
                break;
            }
        }
        return Integer.parseInt(new String(list));
    }
}