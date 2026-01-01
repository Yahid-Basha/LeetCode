class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if(n != t.length()) return false;
        int[] posOfS = new int[256];
        int[] posOfT = new int[256];

        // Arrays.fill(posOfS, -1);
        // Arrays.fill(posOfT, -1);

        for(int i = 0; i < n; i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(posOfS[sChar]-1 != posOfT[tChar]-1) return false;
            posOfS[sChar] = i+1;
            posOfT[tChar] = i+1;
        }
        return true;
    }
}