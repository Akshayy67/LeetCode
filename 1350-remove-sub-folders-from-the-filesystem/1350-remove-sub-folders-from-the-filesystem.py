class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        folder.sort()
        result=[folder[0]]
        for i in range(1,len(folder)):
            if folder[i].startswith(result[len(result)-1]+'/'):
                continue
            result.append(folder[i])
        return result