class Solution {
    public String generateTag(String caption) {
       StringBuilder result= new StringBuilder();
       result.append('#');
       boolean flag=false;
       for(char c:caption.toCharArray()){
            if(c==' '){
                flag=true;
            }
            else if(flag && result.length()>1){
                result.append(Character.toUpperCase(c));
                flag=false;
            }
            else{
                result.append(Character.toLowerCase(c));
                flag=false;
            }
            if(result.length()==100) break;
       }
       return result.toString();
    }
}