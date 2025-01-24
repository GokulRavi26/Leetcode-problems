class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] safe = new int[n];
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(safe[i]==0)dfs(graph, safe, i);
            if(safe[i]==2)ans.add(i);
        }
        return ans;
    }
    void dfs(int[][] graph, int[] safe, int i){
        if(safe[i]!=0)return;
        safe[i]=1;
        for(int ne:graph[i]){
            dfs(graph, safe, ne);
            if(safe[ne]==1)return;
        }
        safe[i]=2;
    }
}