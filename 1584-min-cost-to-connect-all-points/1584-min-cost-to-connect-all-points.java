class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int[][] adj=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=i+1; i!=j && j<n;j++)
            {
                adj[i][j]=Math.abs(points[j][0]-points[i][0])+Math.abs(points[j][1]-points[i][1]);
                adj[j][i]=adj[i][j];
            }
        }
        int cost=prims(adj);
        return cost;
    }
    public int prims(int[][] adj)
    {
        int n=adj.length;
        boolean[] visited=new boolean[n];
        int[] weight=new int[n];
        weight[0]=0;
        for(int i=1;i<n;i++)
        {
            weight[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++)
        {
            int k=findMin(visited,weight);
            visited[k]=true;
            for(int j=0;j<n;j++)
            {
                if(!visited[j] && adj[k][j]>0)
                {
                    if(adj[k][j]<weight[j])
                        weight[j]=adj[k][j];
                }
            }
        }
        int cost=0;
        for(int i=1;i<n;i++)
        {
            cost+=weight[i];
        }
        return cost;
    }
    public int findMin(boolean[] visited,int[] weight)
    {
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i] && weight[i]<min)
            {
                index=i;
                // System.out.println("hhh"+i);
                min=weight[i];
            }
        }
        return index;
    }
}