class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        min_repeat = -(-len(b) // len(a))

        s = a * min_repeat

        if b in s:
            return min_repeat
        
        s = s + a

        if b in s:
            return min_repeat+1
        
        return -1