class Solution {
    public int[] searchRange(int[] nums, int target) {
       int[] res = new int[2];
        int foundStart = -1;
        int foundEnd = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                foundStart = i;
                break;
            }
        }
        if(foundStart > -1) {
            for (int i = nums.length-1; i > -1; i--) {
                if(nums[i] == target) {
                    foundEnd = i;
                    break;
                }
            }
        }
        res[0] = foundStart;
        res[1] = foundEnd;
        return res;
    }
}