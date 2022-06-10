class Solution {
    
    static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr){
         this.src = src;
         this.nbr = nbr;
      }
   }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        int vtces = n;
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for(int i = 0; i < vtces; i++){
         graph[i] = new ArrayList<>();
      }

      
      for(int i = 0; i < edges.length; i++){
         int v1 = edges[i][0];
         int v2 = edges[i][1];
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = source;
      int dest = destination;
        
        boolean[] visited = new boolean[vtces];
      boolean ans = hasPath(graph, src, dest, visited);
      return ans;
    }
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited)
   {
       if(src==dest)
       return true;
       
       visited[src]=true;
       
      for(Edge edge:graph[src])
      {
          int nbr = edge.nbr;
          if(!visited[nbr])
          {
              boolean hasPathNbr = hasPath(graph, nbr, dest, visited);
              if(hasPathNbr==true)
              return true;
               
          }
      }
        
       return false;
   }
}
