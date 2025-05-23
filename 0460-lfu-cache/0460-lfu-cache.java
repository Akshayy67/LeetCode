// class LLNode {
//     int k, v;
//     LLNode next, prev;

//     public LLNode(int k, int v) {
//         this.k = k;
//         this.v = v;
//     }
// }

// class CDLLNode {
//     int cap;
//     LLNode head;
//     Map<Integer, LLNode> mp = new HashMap<>();
//     Map<Integer, Integer> freq = new HashMap<>();

//     public CDLLNode(int cap) {
//         this.cap = cap;
//     }

//     public void insert(int key, int val) {
//         LLNode nn;
//         if (mp.containsKey(key)) {
//             mp.get(key).v = val;
//             freq.put(key, freq.get(key) + 1);
//             head = moveBegin(mp.get(key));
//         } else {
//             if (mp.size() == cap) {
//                 LLNode node = delete();
//                 mp.remove(node.k);
//                 freq.remove(node.k);
//             }
//             nn = new LLNode(key, val);
//             mp.put(key, nn);
//             freq.put(key, 1);
//             head = insertBegin(nn);
//         }
//     }

//     public LLNode delete() {
//         LLNode d = head;
//         int curFreq = freq.get(head.k);
//         LLNode cur = head.next;
//         while (cur != head) {
//             if (curFreq >= freq.get(cur.k)) {
//                 curFreq = freq.get(cur.k);
//                 d = cur;
//             }
//             cur = cur.next;
//         }
//         if (d == head) {
//             head.next.prev = head.prev;
//             head.prev.next = head.next;
//             head = head.next;
//         }
//         d.next.prev = d.prev;
//         d.prev.next = d.next;
//         return d;
//     }

//     public LLNode moveBegin(LLNode node) {
//         if (head == node)
//             return head;
//         node.next.prev = node.prev;
//         node.prev.next = node.next;
//         return insertBegin(node);
//     }

//     public LLNode insertBegin(LLNode node) {
//         if (head == null) {
//             node.next = node;
//             node.prev = node;
//             return node;
//         }
//         node.next = head;
//         node.prev = head.prev;
//         head.prev.next = node;
//         head.prev = node;
//         return node;
//     }

//     int get(int key) {
//         if (!mp.containsKey(key))
//             return -1;
//         head = moveBegin(mp.get(key));
//         freq.put(key, freq.get(key) + 1);
//         // print();
//         return mp.get(key).v;
//     }

//     // void print(){
//     //     LLNode temp= head.next;
//     //         System.out.print(head.k+" "+ head.v + " " + freq.get(head.k) + " ---->");
//     //     while(temp!=head){
//     //         System.out.print(temp.k+" "+ temp.v + " " + freq.get(temp.k)+" ---->");
//     //         temp=temp.next;
//     //     }
//     //     System.out.println();
//     // }
// }

//----------------------------------------------------------------------------------------------------//


class LLNode {
    int k,v;
    LLNode prev,next;
    public LLNode(int k,int v){
        this.k=k;
        this.v=v;
    }
}

class CDLL{
    LLNode head=null;
    int size=0;
    public LLNode insert(int k,int v){
        LLNode nn= new LLNode(k,v);
        size++;
        if(head==null){
            nn.next=nn;
            nn.prev=nn;
            head=nn;
        }
        else{
            head.prev.next=nn;
            nn.prev=head.prev;
            head.prev=nn;
            nn.next=head;
            head=nn;
        }
        return nn;
    }
    public void delete(LLNode node){
        size--;
        if(node.next==node) head=null;
        else{
            if(node==head) head=node.next;
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
    }

    public LLNode deleteAtEnd(){
        size--;
        LLNode last= head.prev;
        if(head.next==head) head=null;
        else{
            head.prev.prev.next=head;
            head.prev=head.prev.prev;
        }
        return last;
    }

}


class LFUCache {
    Map<Integer,Integer> freq= new HashMap<>();
    Map<Integer,LLNode> mp= new HashMap<>();
    Map<Integer,CDLL> lists= new HashMap<>();
    int cap,cur,min;
    public LFUCache(int capacity) {
        this.cap=capacity;
        cur=0;
        min=1;
    }

    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        LLNode node=mp.get(key);
            int f= freq.get(key);  
            lists.get(f).delete(node);
            if(f==min && lists.get(f).size==0) min++;
            freq.put(key,f+1);
            lists.putIfAbsent(f+1, new CDLL());
            LLNode n=lists.get(f+1).insert(node.k,node.v);
            mp.put(key,n);
            return node.v;
    }

    public void put(int key, int value) {
        if(freq.containsKey(key)){
           mp.get(key).v=value;
            get(key);
            return;
        }
        if(cur==cap){
            cur--;
            LLNode last=lists.get(min).deleteAtEnd();
            mp.remove(last.k);
            freq.remove(last.k);
        }
        freq.put(key,1);
        lists.putIfAbsent(freq.get(key),new CDLL());
        LLNode n=lists.get(freq.get(key)).insert(key,value);
        mp.put(key,n);
        min=1;
        cur++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */