class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] cashBox = new int[21];
        for(int i = 0; i < bills.length; i++){
            int curr = bills[i];
            cashBox[curr]++;

            int change = curr-5;
            while(change > 0 && cashBox[10]+cashBox[5] > 0){
                if(change >= 10 && cashBox[10] > 0){
                    cashBox[10]--;
                    change-=10;
                }else if(cashBox[5] > 0){
                    cashBox[5]--;
                    change-=5;
                }else{
                    break;
                }
            }
            if(change != 0) return false;
        }
        return true;
    }
}