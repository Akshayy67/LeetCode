class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left= new PriorityQueue<>(Collections.reverseOrder());
        right= new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size()>0 && num>left.peek()){
            right.add(num);
        }
        else right.add(num);
        if(right.size()-left.size()>0) left.add(right.poll());
        if(left.size()-right.size()==2) right.add(left.poll());
    }
    
    public double findMedian() {
        if(left.size()>right.size()) return left.peek();
        return (left.peek()+right.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */