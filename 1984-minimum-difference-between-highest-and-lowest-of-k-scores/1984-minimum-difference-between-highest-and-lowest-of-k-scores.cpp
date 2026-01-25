class Solution {
public:
    int minimumDifference(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());
        int min=nums.at(nums.size()-1)-nums.at(nums.size()-k);
        for(int i=k-1;i<nums.size();i++)
            min=std::min(min,nums.at(i)-nums.at(i-k+1));
        return min;
    }
};