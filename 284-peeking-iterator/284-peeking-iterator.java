class PeekingIterator implements Iterator<Integer> {
    Deque<Integer> save;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.save = new ArrayDeque<>();
        while (iterator.hasNext()){
            save.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return save.peekFirst();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return save.removeFirst();
    }

    @Override
    public boolean hasNext() {
        return !save.isEmpty();
    }
}