class StockSpanner {
    List<Integer> stocks;
    int size;
    public StockSpanner() {
        stocks = new ArrayList<>();
        size = 0;
    }
    
    public int next(int price) {
        int r = size-1;
        int count = 1;
        while(r >= 0 && stocks.get(r) <= price){
            count++;
            r--;
        }
        stocks.add(price);
        size++;
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */