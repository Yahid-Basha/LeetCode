class Solution {
    public int numOfWays(int n) {
        long aba = 6;
        long abc = 6;
        long mod = 1_000_000_007;

        for(int i = 2; i <= n; i++){
            long prevAba = aba;
            long prevAbc = abc;

            aba = (prevAba * 3 + prevAbc * 2) % mod;
            abc = (prevAba * 2 + prevAbc * 2) % mod;
        }

        return (int) ((aba + abc) % mod);
    }
}