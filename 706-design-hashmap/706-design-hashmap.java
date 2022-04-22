class MyHashMap {
    Node root;
    
    private class Node {
        Node[] arr;
        int val;
        
        Node() {
            this.arr = new Node[10];
            this.val = -1;
        }
    }

    public MyHashMap() {
        this.root = new Node();
    }
    
    public void put(int key, int value) {
        Node curr = this.root;
        while (key > 0) {
            int idx = key % 10;
            key /= 10;
            if (curr.arr[idx] == null) curr.arr[idx] = new Node();
            curr = curr.arr[idx];
        }
        curr.val = value;
        return;
    }
    
    public int get(int key) {
        Node curr = this.root;
        while (key > 0) {
            int idx = key % 10;
            key /= 10;
            if (curr.arr[idx] == null) return -1;
            curr = curr.arr[idx];
        }
        return curr.val;
    }
    
    public void remove(int key) {
        Node curr = this.root;
        while (key > 0) {
            int idx = key % 10;
            key /= 10;
            if (curr.arr[idx] == null) return;
            curr = curr.arr[idx];
        }
        curr.val = -1;
        return;
    }
}