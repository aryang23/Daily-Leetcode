class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            map.computeIfAbsent(arr[i], o -> new ArrayList<>()).add(i);

        Queue<Integer> queue = new ArrayDeque<>(List.of(0));
        // Set<Integer> seen = new HashSet<>();
        int ans = 0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            while(--sz >= 0){
                int cur = queue.poll(), tmp = arr[cur];
                if (!ok(arr, cur)) continue;
                if (cur == arr.length - 1) return ans;
                arr[cur] = Integer.MAX_VALUE;
                if (ok(arr, cur - 1)) queue.offer(cur - 1);
                if (ok(arr, cur + 1)) queue.offer(cur + 1);
                // if (seen.contains(tmp)) continue;
                for (int next : map.getOrDefault(tmp, Collections.emptyList()))
                    if (ok(arr, next))
                        queue.offer(next);
                map.get(tmp).clear();
                // seen.add(tmp);
            }

            ans++;
        }

        return ans;
    }

    private boolean ok(int[] arr, int idx){
        return idx >= 0 && idx < arr.length && arr[idx] != Integer.MAX_VALUE;
    }
}
