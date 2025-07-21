import heapq
class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        pq=[]
        result=0
        i=0
        fuel=startFuel
        while fuel<target:
            while i<len(stations) and fuel>=stations[i][0]:
                heapq.heappush(pq,-stations[i][1])
                i+=1
            if len(pq)==0:
                return -1
            result+=1
            fuel+=-heapq.heappop(pq)
        return result

        