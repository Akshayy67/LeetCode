class LLNode{
    int k,v;
    LLNode next,prev;
    public LLNode(int k,int v){
        this.v=v;
        this.k=k;
    }
}

class CDLL{
    LLNode head=null;
    int cap;
    Map<Integer,LLNode> mp = new HashMap<>();
    CDLL(int cap){
        this.cap=cap;
    }

    void insert(int key,int val){
       LLNode nn ;
       if(mp.containsKey(key)){
            nn=mp.get(key);
            nn.v=val;
            head=moveBegin(nn);
       }
       else{
            nn=new LLNode(key,val);
            mp.put(key,nn);
            head= insertBegin(nn);
            if(mp.size()>cap) delete();
       }
    }

    void delete(){
        mp.remove(head.prev.k);
        head.prev=head.prev.prev;
        head.prev.next=head;
    }

    LLNode insertBegin(LLNode node){
        if(head==null){
            node.next=node;
            node.prev=node;
            return node;
        }
        node.next=head;
        node.prev=head.prev;
        head.prev.next=node;
        head.prev=node;
        return node;
    }

    LLNode moveBegin(LLNode node){
        if(node==head) return node;
        node.prev.next=node.next;
        node.next.prev= node.prev;
        return insertBegin(node);
    }

    int get(int key){
        if(mp.containsKey(key)){
            head=moveBegin(mp.get(key));
            return mp.get(key).v;
        }
        return -1;
    }


}

class LRUCache {
    CDLL obj ;
    public LRUCache(int capacity) {
        obj= new CDLL(capacity);
    }
    
    public int get(int key) {
        return obj.get(key);
    }
    
    public void put(int key, int value) {
        obj.insert(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */