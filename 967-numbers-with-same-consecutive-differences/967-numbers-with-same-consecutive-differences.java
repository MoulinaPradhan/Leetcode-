class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
     Queue<Integer> q = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        while (N-- > 1) {
            for (int sz = q.size(); sz > 0; --sz) {
                int num = q.poll();
                int digit1 = num % 10 - K, digit2 = num % 10 + K;
                if (digit1 >= 0) { 
                    q.offer(num * 10 + digit1); 
                }
                if (digit2 < 10 && digit1 != digit2) { 
                    q.offer(num * 10 + digit2); 
                }
            }
        }
        return q.stream().mapToInt(i -> i).toArray();   
    }
}