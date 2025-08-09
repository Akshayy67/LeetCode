class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    double curmed=0;
    public MedianFinder() {
        left= new PriorityQueue<>(Collections.reverseOrder());
        right= new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(curmed>num){
            if(left.size()>right.size()) right.add(left.poll());
            left.add(num);
        }
        else{
            if(right.size()>left.size()) left.add(right.poll());
            right.add(num);
        }
        if(left.size()==right.size()) curmed=(left.peek()+right.peek())/2.0;
        else if(left.size()>right.size()) curmed=left.peek();
        else curmed=right.peek();
    }
    
    public double findMedian() {
        return curmed;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */