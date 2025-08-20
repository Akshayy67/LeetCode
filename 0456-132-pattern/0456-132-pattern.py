class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        stack=[]
        second=float('-inf')
        for i in range(len(nums)-1,-1,-1):
            num=nums[i]
            if(num<second):
                return True
            while(len(stack)>0 and num>stack[-1]):
                second=stack.pop()
            stack.append(num)
        return False

            


