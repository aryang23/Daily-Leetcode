class Solution {
    public int leastInterval(char[] tasks, int n) {
        int numberOfTasks = tasks.length;
        if(n == 0) return numberOfTasks;
        Map<Character, Integer> taskMap = new HashMap<>();
        for(char ch : tasks) {
            taskMap.put(ch, taskMap.getOrDefault(ch, 0) + 1);
        }
        List<Integer> sortedList = new ArrayList<>(taskMap.values());
        sortedList.sort((a,b) -> b - a);
        int maxFreq = sortedList.get(0);
        int idleTime = (maxFreq - 1) * n;
        for(int i=1; i< sortedList.size(); i++) {
           idleTime -= Math.min(maxFreq - 1, sortedList.get(i));
        }
        idleTime = Math.max(0, idleTime);
        return numberOfTasks + idleTime;
    }
}