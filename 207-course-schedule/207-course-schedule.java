class Solution {
    public boolean canFinish(int num, int[][] pre) {
     List<List<Integer> > adj = new ArrayList<>();
        for(int i=0;i<num;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++) {
          int from = pre[i][1];
            int to = pre[i][0];
            adj.get(from).add(to);
        }
        return isCyclic(adj); 
    }
    public boolean  isCyclic (List<List<Integer>>adj){
        boolean vis[] = new boolean[adj.size()];
        int indg[]= new int [adj.size()];
        for(int i=0;i<adj.size();i++){
            for(Integer it : adj.get(i)) indg[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i< indg.length;i++){
            if(indg[i] ==0) q.offer(i);
        }
        int cnt=0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(Integer it : adj.get(node)){
                indg[it]--;
                if(indg[it] ==0)q.offer(it);
            }
        }
        if(cnt == adj.size()) return true;
        return false;
    }
}