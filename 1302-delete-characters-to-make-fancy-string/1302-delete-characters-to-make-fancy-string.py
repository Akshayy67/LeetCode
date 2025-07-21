class Solution:
    def makeFancyString(self, s: str) -> str:
        result=""
        for c in s:
            if(len(result)>=2  and result[-1]==result[-2]==c):
                continue
            result+=c
        return result