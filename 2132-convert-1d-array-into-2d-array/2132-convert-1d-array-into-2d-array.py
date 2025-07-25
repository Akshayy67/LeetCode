class Solution:
    def construct2DArray(self, original: List[int], m: int, n: int) -> List[List[int]]:
        if m*n != len(original):
            return []
        lst=[[0]*n for i in range(m)]
        for x in range(len(original)):
            lst[x//n][x%n]=original[x]
        return lst
