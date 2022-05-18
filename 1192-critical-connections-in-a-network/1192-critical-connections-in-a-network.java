class Solution {
    private List<Integer>[] buildAdjacencylistFromUnDirectedEdgeList(int vertices, List<List<Integer>> edgeLists) {
        List<Integer>[] adjacencyList = new ArrayList[vertices];
        
        for(List<Integer> edge: edgeLists) { 
            if(adjacencyList[edge.get(0)] == null)
                adjacencyList[edge.get(0)] = new ArrayList<Integer>();
            
            if(adjacencyList[edge.get(1)] == null)
                adjacencyList[edge.get(1)] = new ArrayList<Integer>();
            
            
             adjacencyList[edge.get(0)].add(edge.get(1));
             adjacencyList[edge.get(1)].add(edge.get(0));
        }
         
        return adjacencyList;
    }
    

    private int criticalConnectionsDFS(int currentNode, int parentNode, int currentNodeRank, int[] nodeRanks, List<Integer>[] adjacencyList, List<List<Integer>> result) {
        
        nodeRanks[currentNode] = currentNodeRank; 
        int neighbourRank = 0;
        
        for(int neighbourNode :  adjacencyList[currentNode]) {
            if(neighbourNode == parentNode) 
                continue;

            neighbourRank = nodeRanks[neighbourNode];
            
            if( neighbourRank == 0)
                neighbourRank = criticalConnectionsDFS(neighbourNode, currentNode, currentNodeRank + 1, nodeRanks, adjacencyList, result);

            if(neighbourRank > currentNodeRank) { 
                result.add(Arrays.asList(currentNode, neighbourNode));
            } else {
                nodeRanks[currentNode] = Math.min(nodeRanks[currentNode], neighbourRank);
            }
        }
        
        return nodeRanks[currentNode];
    }
    
    
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] adjacencyList = buildAdjacencylistFromUnDirectedEdgeList(n, connections);
        List<List<Integer>> result = new ArrayList<>();
        int[] nodeRanks = new int[n];
       
        criticalConnectionsDFS(0, -1, 1, nodeRanks, adjacencyList, result);
        
        return result;
        
    }
}