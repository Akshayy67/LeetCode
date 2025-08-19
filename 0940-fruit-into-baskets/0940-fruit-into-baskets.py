class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        i,j=0,0
        result=0
        mp={}
        while(i<len(fruits)):
            mp[fruits[i]]=mp.get(fruits[i],0)+1
            while(len(mp)==3):
                mp[fruits[j]]=mp.get(fruits[j])-1
                if(mp[fruits[j]]==0):
                    mp.pop(fruits[j])
                j+=1
            result=max(result,i-j+1)
            i+=1
        return result