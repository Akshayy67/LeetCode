class Solution(object):
    def containsDuplicate(self, nums):
        st=set()
        for num in nums:
            if num in st:
                return True
            st.add(num)
        return False

        