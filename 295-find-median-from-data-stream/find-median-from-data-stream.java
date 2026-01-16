class MedianFinder {
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;
    boolean even = true;
    public MedianFinder() {
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        leftHeap.offer(num);
        rightHeap.offer(leftHeap.poll());

        if(leftHeap.size() < rightHeap.size()){
            leftHeap.offer(rightHeap.poll());
        }
    }
    
    public double findMedian() {
        if(leftHeap.size() > rightHeap.size()) return leftHeap.peek();
        return (double)(leftHeap.peek()+rightHeap.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */