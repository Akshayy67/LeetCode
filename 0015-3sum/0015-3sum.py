class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result=set()
        for i in range(len(nums)-2):
            if i>0 and nums[i]==nums[i-1]:
                continue
            target=-1*nums[i]
            l,r=i+1,len(nums)-1
            while(l<r):
                if(nums[l]+nums[r]==target):
                    result.add((nums[i],nums[l],nums[r]))
                    l+=1
                    r-=1
                elif(nums[l]+nums[r]<target):
                    l+=1
                else:
                    r-=1
        return list(map(list,result))
 
       