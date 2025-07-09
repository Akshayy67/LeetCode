class Solution:
    def maxFreeTime(self, eventTime: int, k: int, start: List[int], end: List[int]) -> int:
        g=[]
        g.append(start[0])
        for i in range(1,len(start)):
            g.append(start[i]-end[i-1])
        g.append(eventTime-end[len(end)-1])
        s=result=sum(g[:k+1])
        for i in range(k+1,len(g)):
            s+=g[i]-g[i-k-1]
            result=max(result,s)
        return result