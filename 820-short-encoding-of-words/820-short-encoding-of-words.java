class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> distinct = new HashSet<>();
        Collections.addAll(distinct, words);

        for (String word : words) {
            if (distinct.contains(word))
                for (int i = 1; i < word.length(); i++)
                    distinct.remove(word.substring(i));
        }

        int result = 0;
        for (String word : distinct) {
            result += word.length() + 1;
        }

        return result;
    }
}