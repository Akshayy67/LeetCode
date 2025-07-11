class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        free=[i for i in range(0,n)]
        busy=[]
        c=[0]*n
        meetings.sort()
        for s,e in meetings:
            while busy and busy[0][0]<=s:
                _,r=heapq.heappop(busy)
                heapq.heappush(free,r)
            if free:
                r=heapq.heappop(free)
                heapq.heappush(busy,(e,r))
            else:
                et,r=heapq.heappop(busy)
                heapq.heappush(busy,(et+e-s,r))
            c[r]+=1
        return c.index(max(c))