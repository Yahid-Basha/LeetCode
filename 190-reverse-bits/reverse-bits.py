class Solution:
    def reverseBits(self, n: int) -> int:
        x = format(n, '032b')[::-1]
        return int(x,2)