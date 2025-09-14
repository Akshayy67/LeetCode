class LNode{
    int key,value;
    LNode prev,next;
    public LNode(int key,int value){
        this.key=key;
        this.value=value;
    }
}
class CDLLNode{
    LNode head;
    Map<Integer,LNode> mp;
    int capacity;
    public CDLLNode(int capacity){
        this.capacity=capacity;
        mp= new HashMap<>();
    }
    public void insert(int key,int val){
        if(mp.containsKey(key)){
            delete(key);
        }
        if(mp.size()==capacity){
            delete(head.prev.key);
        }
        LNode nn = new LNode(key,val);
        mp.put(key,nn);
        if(head==null){
            nn.next=nn;
            nn.prev=nn;
            head=nn;
            return;
        }
        nn.next=head;
        nn.prev=head.prev;
        head.prev.next=nn;
        head.prev=nn;
        head=nn;
    }
    public void delete(int key){
        LNode node=mp.get(key);
        if(node==null) return;
        if(node.next==node){
            head=null;
            mp.remove(key);
            return;
        }
        node.next.prev=node.prev;
        node.prev.next=node.next;
        if(head==node) head=node.next;
        mp.remove(key);
    }
    public int get(int key){
        if(!mp.containsKey(key)) return -1;
        int val=mp.get(key).value;
        delete(key);
        insert(key,val);
        return val;
    }
}
class LRUCache {
    CDLLNode lru;
    public LRUCache(int capacity) {
        lru= new CDLLNode(capacity);
    }
    
    public int get(int key) {
        return lru.get(key);
    }
    
    public void put(int key, int value) {
        lru.insert(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */