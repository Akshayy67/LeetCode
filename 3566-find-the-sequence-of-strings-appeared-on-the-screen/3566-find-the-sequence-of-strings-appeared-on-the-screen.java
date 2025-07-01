class Solution {
    public List<String> stringSequence(String target) {
        List<String> result= new ArrayList<>();
        StringBuilder path = new StringBuilder();
        for(int i=0;i<target.length();i++){
            char c='a';
            while(c<=target.charAt(i)){
                path.append(c);
                c++;
                result.add(path.toString());
                path.setLength(path.length()-1);
            }
            path.append((char)(c-1));
        }
        return result;
    }
}