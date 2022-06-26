class Node{
    int u;
    int v;
    double w;
    Node(int u1, int v1, double w1){
        u=u1;
        v=v1;
        w=w1;
    }
    int getU(){return u;}
    int getV(){return v;}
    double getW(){return w;}
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<Node>adj= new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            adj.add(new Node(edges[i][0],edges[i][1],succProb[i]));
        }
       double dist[] =new double [n];
  
        dist[start] =1;
  
        for(int i=0;i<n-1;i++){
              boolean flag = false;
            for(Node nde :adj){
           if(dist[nde.getU()] * nde.getW() > dist[nde.getV()]){
               dist[nde.getV()] = dist[nde.getU()] * nde.getW();
               flag =true;
           }
                 if(dist[nde.getV()] * nde.getW() > dist[nde.getU()]){
               dist[nde.getU()] = dist[nde.getV()] * nde.getW();
                      flag =true;
           }  
            }
            if(!flag)
                break;
            
        }
     
        return dist[end];
    }
}