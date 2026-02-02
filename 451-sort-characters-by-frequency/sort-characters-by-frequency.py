class Solution:
    def frequencySort(self, s: str) -> str:
        freq_map = {}
        for char in s:
            freq_map[char] = freq_map.get(char, 0) + 1
                
        buckets = [[] for _ in range(len(s) + 1)]
        
        for char, count in freq_map.items():
            buckets[count].append(char)
            
        res = []
        for count in range(len(s), 0, -1):
            for char in buckets[count]:
                res.append(char * count)
                
        return "".join(res)
