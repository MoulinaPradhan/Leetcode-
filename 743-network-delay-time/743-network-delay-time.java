//Bellman Ford
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[] = new int [n+1];
            Arrays.fill(dist,(int)1e9);
        dist[k] =0;
        for(int i=0;i<n-1;i++){
        for(int t[]:times){
            int u=t[0];
            int v = t[1];
            int w = t[2];
            if(dist[u] +w < dist[v]){
                dist[v]= dist[u]+w;
            }
        }
            
        }
        int max =0;
       for(int i=1;i<dist.length;i++){
           if(dist[i] == (int) 1e9) return -1;
           max = Math.max(max,dist[i]);
       }
        return max;
    }
}