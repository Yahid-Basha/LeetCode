class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char sa[] = s.toCharArray();
        int count[] = new int[26];
        for(char c: sa){
            count[c-'a']++;
        }
        char ta[] = t.toCharArray();
        for (char d: ta){
            if(count[d-'a']==0){
                return false;
            }
            count[d-'a']--;
        }
        return true;
    }
}