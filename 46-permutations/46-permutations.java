class Solution {
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        fn(nums,0,new ArrayList<>());
        return res;
    }
    public void fn(int [] nums, int idx, List<Integer> curr){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
                if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            fn(nums, i,curr);
            curr.remove(curr.size() -1);
        }
    }
}