class Solution {
    public static class UnionFind{
        int parent[];
        int count[];
        public UnionFind(int n){
          this.parent= new int [n];
            this.count = new int [n];
            for(int i=0;i<n;i++){
                parent[i] =i;
                count[i] =1;
            }
        }
        int find (int node){
            if(parent[node] == node) return node;
            return parent[node] = find(parent[node]);
        }
        void union(int a, int b){
            int u=find(a);
            int v = find(b);
            if(u!=v){
                parent[v] = u;
               count[u]+=count[v];
            }
        }
    }
    public int max =0;
    public int largestIsland(int[][] grid) {
       int n = grid.length;
        int m= grid[0].length;
            UnionFind uf = new UnionFind(m*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            if(grid[i][j] ==1){
                unionAround(uf,grid,i,j);
            }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (grid[i][j] == 0) {
                    int[][] neighbors = new int[][]{
                        { i - 1, j }, { i + 1, j }, { i, j - 1 }, { i, j + 1 }
                    };
                    int connect =0;
                    Set<Integer> set = new HashSet<>();
                    for(int [] neighbor : neighbors){
                        int ni=neighbor[0];
                        int nj = neighbor[1];
                        if(valid(n,m,ni,nj) && grid[ni][nj] == 1){
                            set.add(uf.find(n*ni+nj));
                    }
                    
                }
                for(int node : set) connect+= uf.count[node];
                max = Math.max(max,connect+1);
            }
        }
    }
    return max;
}
public void unionAround(UnionFind uf, int [][] grid,int i, int j){
    int m = grid.length;
    int n = grid[0].length;
     int[][] neighbors = new int[][]{
            { i - 1, j }, { i + 1, j }, { i, j - 1 }, { i, j + 1 }
        };
        for (int[] neighbor : neighbors) {
            int ni = neighbor[0];
            int nj = neighbor[1];
            if (valid(m, n, ni, nj) && grid[ni][nj] == 1) {
                uf.union(m * i + j, m * ni + nj);
            }
        }
        max = Math.max(max, uf.count[uf.find(i * m + j)]);
}
private boolean valid(int m , int n, int i, int j){
    return i>=0 && i<m && j>=0 && j<n;
}
}