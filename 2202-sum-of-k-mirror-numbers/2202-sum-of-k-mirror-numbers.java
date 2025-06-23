class Solution {
    public long kMirror(int k, int n) {
        long sum=0;
        for(long len=1;n>0;len*=10){
            for(long i=len;n>0 && i<len*10;i++){
                long pal=createPalin(i,true);
                if(isKPalin(pal,k)){
                    sum+=pal;
                    n--;
                }
            }
            for(long i=len;n>0 && i<len*10;i++){
                long pal=createPalin(i,false);
                if(isKPalin(pal,k)){
                    sum+=pal;
                    n--;
                }
            }
        }
        return sum;
    }
    public long createPalin(long num,boolean odd){
        long temp=num;
        if(odd) temp/=10;
        while(temp>0){
            num=num*10+temp%10;
            temp/=10;
        }
        return num;
    }
    public boolean isKPalin(long num,int k){
        StringBuilder str= new StringBuilder();
        while(num>0){
            str.append(num%k);
            num/=k;
        }
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i++)!=str.charAt(j--)) return false;
        }
        return true;
    }
}