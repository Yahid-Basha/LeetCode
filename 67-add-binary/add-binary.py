class Solution:
    def addBinary(self, a: str, b: str) -> str:
        result = []
        carry = 0
        i, j = len(a) - 1, len(b) - 1

        while i >= 0 or j >= 0 or carry:
            # Convert char to int, or use 0 if pointer is out of bounds
            digit_a = int(a[i]) if i >= 0 else 0
            digit_b = int(b[j]) if j >= 0 else 0
            
            # Calculate sum and carry
            total = digit_a + digit_b + carry
            result.append(str(total % 2))
            carry = total // 2
            
            # Move pointers left
            i -= 1
            j -= 1
            
        return "".join(result[::-1])