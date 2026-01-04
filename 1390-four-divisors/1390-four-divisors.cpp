#include <cmath>
class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        int result=0;
        for(int num:nums){
            unordered_set<int> st;
            bool flag=true;
            for(int i=1;i<=sqrt(num);i++){
                if(num%i==0){
                    st.insert(i);
                    st.insert(num/i);
                }
                if(st.size()>4){
                    flag=false;
                    break;
                }
            }
            if(flag==true && st.size()==4){
                for(int temp:st) result+=temp;
            }
        }
        return result;
    }
};