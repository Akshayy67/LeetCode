class Solution:
    def divisorSubstrings(self, num: int, k: int) -> int:
        s=str(num)
        count=0
        for i in range(0,len(s)-k+1):
            number=int(s[i:i+k:1])
            if(number!=0 and num%number==0):
                count+=1
        return count