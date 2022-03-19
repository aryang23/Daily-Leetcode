class FreqStack {
    Map<Integer, Integer> freqMap;
    Map<Integer, LinkedList<Integer>> groupFreqMap;
    int maxFreq = 0;

    public FreqStack() {
        freqMap = new HashMap<>();
        groupFreqMap = new HashMap<>();
    }

    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        if (freq > maxFreq) {
            maxFreq = freq;
        }

        groupFreqMap.putIfAbsent(freq, new LinkedList<>());
        groupFreqMap.get(freq).push(val);
    }

    public int pop() {
        int res = groupFreqMap.get(maxFreq).pop();
        freqMap.put(res, freqMap.get(res) - 1);
        if (groupFreqMap.get(maxFreq).isEmpty()) {
            groupFreqMap.remove(maxFreq);
            maxFreq--;
        }

        return res;
    }
}