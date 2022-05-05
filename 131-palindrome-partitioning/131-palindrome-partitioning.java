class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        fn(s,0, new ArrayList<>());
        return res;
        
        }
    public void fn(String s, int idx, List<String> curr){
        if(idx == s.length()){
            res.add(new ArrayList<>(curr));
            return ;
        }
        for(int i=idx;i<s.length();i++){
            if(pali(s, idx, i)){
                curr.add(s.substring(idx,i+1));
                fn(s, i+1, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean pali(String s , int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)) return  false;
            
        }
        return true;
    }
}