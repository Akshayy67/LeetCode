class Pair{
    int v;
    int min;
    Pair(int v,int min){
        this.v=v;
        this.min=min;
    }
}
class MinStack {
    Stack<Pair> stk;
    public MinStack() {
        stk= new Stack<>();
    }
    
    public void push(int val) {
        int min=val;
        if(!stk.isEmpty()) min=Math.min(min,stk.peek().min);
        stk.push(new Pair(val,min));
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek().v;
    }
    
    public int getMin() {
        return stk.peek().min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */