class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        c=Counter(nums)
        mx=max(c.values())
        result=0
        for i in c.values():
            if i==mx:
                result+=i
        return result