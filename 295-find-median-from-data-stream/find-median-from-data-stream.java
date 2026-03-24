class MedianFinder {
    //Maxheap
    PriorityQueue<Integer> leftHeap;
    //MinHeap
    PriorityQueue<Integer> rightHeap;

    public MedianFinder() {
        leftHeap = new PriorityQueue<>((a,b)->(b-a));
        rightHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        leftHeap.offer(num);
        rightHeap.offer(leftHeap.poll());

        if(rightHeap.size()-leftHeap.size() >= 2){
            leftHeap.offer(rightHeap.poll());
        }
    }
    
    public double findMedian() {
        if(leftHeap.size() != rightHeap.size()) return rightHeap.peek();
        return (leftHeap.peek()+rightHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */