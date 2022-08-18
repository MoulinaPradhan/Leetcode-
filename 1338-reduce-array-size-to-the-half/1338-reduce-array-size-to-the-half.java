class Solution {
    public int minSetSize(int[] arr) {
        int len = arr.length/2;
        int count=0;
        
        Map<Integer,Integer>map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        if(map.size() ==1) return 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(map.size(),Collections.reverseOrder());
        
        for(Integer i :map.values()){
            pq.offer(i);
        }
        
        while(!pq.isEmpty() && len>0){
            len-=pq.poll();
            count++;
        }
        
        return count;
    }
}