class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result= new ArrayList<>();
        result.add(folder[0]);
        for(int i=1;i<folder.length;i++){
           String[] prev=result.get(result.size()-1).split("/");
           String[] cur=folder[i].split("/");
           int j=0,k=0;
           while(j<prev.length && k<cur.length){
            if(!prev[j].equals(cur[k])) break;
            j++;k++;
           }
           if(j==prev.length && k<=cur.length) continue;
           result.add(folder[i]);
        }
        return result;
    }
}