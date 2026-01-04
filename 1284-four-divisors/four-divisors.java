class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for(int num : nums){
            int currSum = 0;
            int count = 0;

            for(int i = 1; i * i <= num; i++){
                if(num%i == 0){
                    if(i*i == num){
                        count++;
                        currSum += i;
                    }else{
                        count += 2;
                        currSum = currSum + i + (num/i);
                    }
                }
                if(count > 4) break;
            }

            if(count == 4){
                totalSum += currSum;
            }
        }
        return totalSum;
    }
}