class Solution {
    public int vowelConsonantScore(String s) {
        int v = 0;
        int c = 0;
        
        // Define vowels for O(1) lookup
        // Using a string checks is cleaner than multiple OR conditions
        String vowels = "aeiou";

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) { // Ignore spaces and digits
                if (vowels.indexOf(ch) != -1) {
                    v++;
                } else {
                    c++;
                }
            }
        }
        
        // Avoid division by zero
        if (c == 0) return 0;
        
        return v / c; // Integer division acts as floor() automatically
    }
}