class Solution {
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] vis = new int[N];
        Arrays.fill(vis, -1);
        
        boolean isBipartite = true;
        for(int i=0;i<N;i++)
        {
            if(vis[i]==-1)
            {
                isBipartite = isBipartite && isBipartite(graph, i, vis);
            }
        }
        return isBipartite;
    }
    
    public boolean isBipartite(int[][] graph, int src, int[] vis)
    {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        int color = 0;
        boolean cycle = false, isBipartite = true;
        
        while(q.size()!=0)
        {
            int size = q.size();
            while(size-->0)
            {
                int remVtx = q.remove();
                if(vis[remVtx]!=-1)
                {
                    //Cycle here
                    if(vis[remVtx]!=color)
                    {
                        //Conflict here
                        // System.out.println(false);
                        // System.out.println(vis[remVtx]+",,"+color);
                        isBipartite = false;
                        break;
                    }
                    //Means No Conflict, all going well
                    continue;
                }
                
                vis[remVtx]=color;
                // System.out.println(remVtx+" has color "+color);
                
                for(int e:graph[remVtx])
                {
                    if(vis[e]==-1)
                    {
                        q.add(e);
                        // System.out.println(e);
                    }
                }
                
                
                // System.out.println("color"+color);
            }
            color = (color+1)%2;
            if(isBipartite==false)
                break;
        }
        return isBipartite;
    }
}
