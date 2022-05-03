class Solution {
       List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candi, int target) {
        Arrays.sort(candi);
    if(candi.length ==0) return res;
        sum(0,0,candi,target,new ArrayList<>());
        return res;
    }
    public void sum(int index,int sum,int[] candi, int target,List<Integer> curr){
           if (sum > target) return;
        if(sum == target && !res.contains(new ArrayList<>(curr))){

            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<candi.length;i++){
     if (i >index && candi[i] ==candi[i - 1])
              continue;
                curr.add(candi[i]);
                sum(i+1,sum+candi[i],candi,target,curr);
                curr.remove(curr.size()-1);
            
        }
 
    }
}