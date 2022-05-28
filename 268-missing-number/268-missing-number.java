class Solution {
    public int missingNumber(int[] nums) {
           Arrays.sort(nums);
      int a=0;
      for(int i=0;i<nums.length;i++){
          if(nums[i] != i+1){
              a=i+1;
          }
      }
        return a;
    }
}