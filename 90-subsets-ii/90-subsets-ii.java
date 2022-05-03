class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
      fn(nums,0,new ArrayList<>());
        return res;
    }
    public void fn(int[] nums, int idx, List<Integer> curr){
          if(!res.contains(new ArrayList<>(curr)))
        res.add(new ArrayList<>(curr));
        for(int i=idx;i<nums.length;i++){
            curr.add(nums[i]);
            fn(nums,i+1,curr);
            curr.remove(curr.size()-1);
        }
    }
}