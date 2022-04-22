class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candi, int target) {
      if(candi.length ==0) return res;
        sum(0,0,candi,target,new ArrayList<>());
        return res;
    }
    public void sum(int index,int sum,int[] candi, int target,List<Integer> curr){
        if(sum == target){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<candi.length;i++){
            if(sum +candi[i] <=target){
                curr.add(candi[i]);
                sum(i,sum+candi[i],candi,target,curr);
                curr.remove(curr.size()-1);
            }
        }
 
    }
}