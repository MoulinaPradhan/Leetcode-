class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans [] = new int [k];
        for(int t : nums){
            map.put(t,map.getOrDefault(t,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> map.get(b) - map.get(a));
        for(int i: map.keySet())pq.add(i);
        for(int i=0;i<k;i++){
            ans[i] = pq.remove();
        }
        return ans;
    }
}