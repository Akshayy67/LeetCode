class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder str= new StringBuilder(s);
        boolean changes=true;
        int score=0;
        char first=x>y?'b':'a';
        int firstscore=x>y?x:y;
        int secondscore=x>y?y:x;
        char second=first=='a'?'b':'a';
        boolean totalchanges=true;
        // while(totalchanges){
        //     totalchanges=false;
            changes=true;
            while(changes && str.length()>=2){
                changes=false;
                StringBuilder temp= new StringBuilder();
                temp.append(str.charAt(0));
                for(int i=1;i<str.length();i++){
                    if(str.charAt(i)==first){
                        if(!temp.isEmpty() && temp.charAt(temp.length()-1)==second){
                            temp.deleteCharAt(temp.length()-1);
                            score+=firstscore;
                            changes=true;
                            totalchanges=true;
                            continue;
                        }
                    }
                    temp.append(str.charAt(i));
                }
                str=temp;
            }
            changes=true;
            while(changes && str.length()>=2){
                changes=false;
                StringBuilder temp= new StringBuilder();
                temp.append(str.charAt(0));
                for(int i=1;i<str.length();i++){
                    if(str.charAt(i)==second){
                        if(!temp.isEmpty() && temp.charAt(temp.length()-1)==first){
                            temp.deleteCharAt(temp.length()-1);
                            score+=secondscore;
                            changes=true;
                            totalchanges=true;
                            continue;
                        }
                    }
                    temp.append(str.charAt(i));
                }
                str=temp;
            }
        // }
        return score;
    }
}