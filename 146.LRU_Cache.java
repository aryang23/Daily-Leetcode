class LRUCache {
    private class Node {
            int key, value;
            Node prev, next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.prev = null;
                this.next = null;
            }
        }

    private HashMap<Integer, Node> map = new HashMap<>();
    private int maxSize = 0;
    private int size = 0;
    private Node head = null, tail = null;


    public LRUCache(int capacity) 
    {
            this.maxSize = capacity;
    }

    public void makeRecent(Node node) 
    {
            if(node == this.tail) return;

            remove(node);
            addLast(node);
    }
    
    public void addLast(Node node) 
    {
        if (head == null)
            head = tail = node;
        else 
        {
            tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
        this.size++;
    }


    public void remove(Node node) 
    {
        Node forw = node.next, prev = node.prev;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else if (node == this.tail) {
            prev.next = node.prev = null;
            this.tail = prev;
        } else if (node == this.head) {
            node.next = forw.prev = null;
            this.head = forw;
        } else {
            prev.next = forw;
            forw.prev = prev;
            node.prev = node.next = null;
        }
        this.size--;
    }

    
    
    public int get(int appName) {
            if (!map.containsKey(appName))
                return -1;

            Node node = map.get(appName);
            makeRecent(node);
            return node.value;
        }
    
    public void put(int appName, int state) 
    {
        if (map.containsKey(appName)) {
            Node node = map.get(appName);
            node.value = state;
            makeRecent(node);
        } 
        else 
        {
            Node node = new Node(appName, state);
            if (this.size == this.maxSize) {
                map.remove(this.head.key);
                remove(this.head);
            }

            addLast(node);
            map.put(appName, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
