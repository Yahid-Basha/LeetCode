class Solution:
    def singleNumber(self, nums: list[int]) -> int:
        ones = 0
        twos = 0
        
        for n in nums:
            # Add to 'twos' if it was already in 'ones'
            twos |= (ones & n)
            # XOR to 'ones' (same as Single Number I)
            ones ^= n
            
            # If a bit is in both ones and twos, it has appeared 3 times
            three_mask = ~(ones & twos)
            
            # Clear bits that appeared 3 times
            ones &= three_mask
            twos &= three_mask
            
        return ones