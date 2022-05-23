class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int [nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int n: nums2){
           
            while(!stack.isEmpty() && stack.peek() < n){
                map.put(stack.pop(),n);
            }
            stack.push(n);
        }
        for(int i=0;i<ans.length;i++){
            if(map.containsKey(nums1[i])){
                ans[i] = map.get(nums1[i]);
            }else{
                ans[i] =-1;
            }
        }
        return ans;
    }
}