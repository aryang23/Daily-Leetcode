class Solution {
    private int K;
    public int[][] highFive(int[][] items) {
        this.K = 5;
        Arrays.sort(items, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b)
            {
                if(a[0] != b[0])
                    return a[0]-b[0];
                return b[1]-a[1];
            }
        });
        List<int[]> solution = new ArrayList<>();
        int n = items.length;
        int i = 0;
        while(i < n)
        {
            int id = items[i][0];
            int sum = 0;
            
            for(int k=i;k<i+this.K;++k)
                sum += items[k][1];
            
            while(i < n && items[i][0] == id)
                i++;
            solution.add(new int[] {id, sum/this.K});
        }
        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray);
    }
}
