class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int dist[] = new int [n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] =0;
        for(int i=0;i<=k;i++){
            int temp [] = Arrays.copyOf(dist,n);
            for(int [] f : flights){
                int u=f[0];
                int v = f[1];
                int w = f[2];
              if (dist[u] == Integer.MAX_VALUE) continue;
                if(dist[u]+w< temp[v]){
                    temp[v] = w+dist[u];
                }
            }
            dist=temp;
        }
       
        return dist[dst]== Integer.MAX_VALUE ? -1 : dist[dst];
    }
}