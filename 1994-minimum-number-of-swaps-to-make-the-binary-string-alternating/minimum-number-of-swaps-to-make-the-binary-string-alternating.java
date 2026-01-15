class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        int count0 = 0;
        for(char c: s.toCharArray()) if(c == '0') count0++; 
        int count1 = n - count0;

        if(Math.abs(count1 - count0) > 1) return -1;

        int miss0 = 0;
        for(int i = 0; i < n; i++){
            char expected = i%2 == 0 ? '0' : '1';
            if(s.charAt(i) != expected){
                miss0++;
            }
        }

        int res = Integer.MAX_VALUE;
        if(miss0%2 == 0 && (count0 == (n+1)/2)){
            res = Math.min(res, miss0/2);
        }

        int miss1 = n-miss0;
        if(miss1%2 == 0 && (count1 == (n+1)/2)){
            res = Math.min(res, miss1/2);
        }

        System.out.print(res == Integer.MAX_VALUE);

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}