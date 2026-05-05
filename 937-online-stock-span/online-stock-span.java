class StockSpanner {
    Stack<int[]> stocks;
    int size;
    public StockSpanner() {
        stocks = new Stack<>();
        size = 0;
    }
    
    public int next(int price) {
        size++;

        while(!stocks.isEmpty() && stocks.peek()[0] <= price){
            stocks.pop();
        }
        int ans;
        if(stocks.isEmpty()) {
            ans = size;
        }else{
            ans = size-stocks.peek()[1];
        }
        
        stocks.push(new int[]{price, size});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */