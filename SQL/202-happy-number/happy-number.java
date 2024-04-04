class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            if(fast == 1){
                return true;
            }
            slow = square(slow);
            fast = square(square(fast));
        } while(slow!= fast);
        if(slow != 1) return false;
        return true;
    }
    public int square(int n){
        int sum = 0;
        while(n!=0){
            int r = n%10;
            sum = sum + (r*r);
            n/=10;
        }
        
        return sum;
    }
}