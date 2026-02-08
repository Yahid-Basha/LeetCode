class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        subsets = []
        total = 2**len(nums)
        for mask in range(0, total):
            subset = []
            for i in range(0, len(nums)):
                if(mask & 1<<i):
                    subset.append(nums[i])
            subsets.append(subset)
        return subsets