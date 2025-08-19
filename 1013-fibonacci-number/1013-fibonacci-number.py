class Solution:
    dp=[-1 for i in range(31)]
    def fib(self, n: int) -> int:
        if(n==0):
            return 0
        if(n==1):
            return 1
        if(self.dp[n]!=-1):
            return self.dp[n]
        self.dp[n]=self.fib(n-1)+self.fib(n-2)
        return self.dp[n]