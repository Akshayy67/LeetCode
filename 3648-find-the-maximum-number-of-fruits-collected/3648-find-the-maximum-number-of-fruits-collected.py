class Solution:
    def maxCollectedFruits(self, fruits: List[List[int]]) -> int:
        n=len(fruits)
        ans=0 
        for i in range(n):
            ans+=fruits[i][i]
        def calculate():
            prev=[0]*n
            prev[n-1]=fruits[0][n-1]
            for i in range(1,n-1):
                temp=[0]*n
                for j in range(max(n-i-1,i+1),n):
                    mx=prev[j]
                    if j-1>=0:
                        mx=max(mx,prev[j-1])
                    if j+1<n:
                        mx=max(mx,prev[j+1])
                    temp[j]=mx+fruits[i][j]
                prev,temp=temp,prev
            return prev[n-1]
        ans+=calculate()
        for i in range(n):
            for j in range(i):
                fruits[i][j],fruits[j][i]=fruits[j][i],fruits[i][j]
        ans+=calculate()
        return ans