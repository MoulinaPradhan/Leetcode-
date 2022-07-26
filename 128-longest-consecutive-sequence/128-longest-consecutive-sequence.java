class Solution {
    public int longestConsecutive(int[] nums) {
      Set<Integer> set = new HashSet<>();
int max = 0;
for(int i : nums) set.add(i);
for(int i : nums) {
    int count = 1;
    if(!set.contains(i-1)) {
        while(set.contains(i+count)) count++;
        max = Math.max(max, count);
    }
}
return max;  
    }
}