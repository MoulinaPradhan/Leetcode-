class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> l = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        permuteUnique(nums, l, new ArrayList<Integer>(), freq);
        return l;
    }
    
    
    private void permuteUnique(int[] nums, List<List<Integer>> l, 
                               ArrayList<Integer> al, boolean[] freq){
        if(al.size() == nums.length){
            l.add(new ArrayList<Integer>(al));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !freq[i-1]) continue;
            if(freq[i]) continue;
            al.add(nums[i]);
            freq[i] = true;
            permuteUnique(nums, l, al, freq);
            al.remove(al.size() - 1);
            freq[i] = false;
        }   
    }
    
}