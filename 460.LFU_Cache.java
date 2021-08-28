class LFUCache {
    final int capacity;
    int currSize;
    int minFrequency;
    HashMap<Integer, DLLNode> cache;
    HashMap<Integer, DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFrequency = 0;
        
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        DLLNode currNode = cache.get(key);
        if(currNode == null)
            return -1;
        updateNode(currNode);
        return currNode.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0)
            return;
        
        if(cache.containsKey(key))
        {
            DLLNode currNode = cache.get(key);
            currNode.val = value;
            updateNode(currNode);
        }
        else
        {
            currSize++;
            if(currSize > capacity)
            {
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }
            
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);
            
            DoubleLinkedList currList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            currList.addNode(newNode);
            frequencyMap.put(1, currList);
            cache.put(key, newNode);
        }
    }
    
    public void updateNode(DLLNode currNode)
    {
        int currFreq = currNode.frequency;
        DoubleLinkedList currList = frequencyMap.get(currFreq);
        currList.removeNode(currNode);
        
        if(currFreq == minFrequency && currList.listSize==0)
            minFrequency++;
        
        currNode.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(currNode.frequency, new DoubleLinkedList());
        newList.addNode(currNode);
        frequencyMap.put(currNode.frequency, newList);
    }
}

class DLLNode {
    int key;
    int val;
    int frequency;
    DLLNode prev;
    DLLNode next;
    
    public DLLNode(int key, int val)
    {
        this.key = key;
        this.val = val;
        this.frequency = 1;
    }
}

class DoubleLinkedList{
    int listSize;
    DLLNode head;
    DLLNode tail;
    
    public DoubleLinkedList(){
        this.head = new DLLNode(0,0);
        this.tail = new DLLNode(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void addNode(DLLNode currNode)
    {
        DLLNode nextNode = head.next;
        currNode.next = nextNode;
        currNode.prev = head;
        head.next = currNode;
        nextNode.prev = currNode;
        listSize++;
    }
    
    public void removeNode(DLLNode currNode)
    {
        DLLNode prevNode = currNode.prev;
        DLLNode nextNode = currNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        listSize--;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
