class Solution {
    public int longestStrChain(String[] words) {
           Arrays.sort(words, (a, b)->a.length() - b.length());

        Map<String, Integer> dp = new HashMap<>();

        int ans = 0;

        for (String word : words) {

            int longestChain = 0;

            for (int i = 0; i < word.length(); i++) { 
          
                String predecessor = word.substring(0, i) + word.substring(i + 1, word.length());

                longestChain = Math.max(longestChain, dp.getOrDefault(predecessor, 0) + 1);

            }

            dp.put(word, longestChain);

            ans = Math.max(ans, longestChain);
        }
        return ans;
    }
}