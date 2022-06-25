class Solution {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        boolean changed = false;
        int pre = Integer.MIN_VALUE;
        for(int i=1; i<len; i++){
            if(nums[i]>=nums[i-1])
                pre = nums[i-1];
            else{
                if(changed) return false;
                if(nums[i]<pre)// means we have to change ith num
                    nums[i] = nums[i-1];
                changed = true;
            }
        }
        return true;
    }
}