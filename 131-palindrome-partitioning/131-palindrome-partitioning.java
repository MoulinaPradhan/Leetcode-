class Solution {
    List<List<String>>res = new ArrayList<>();
    public List<List<String>> partition(String s) {
     helper(s,0,new ArrayList<>());
        return res;
    }
    public void helper(String s, int index, List<String>path){
        if(index == s.length()){
            res.add(new ArrayList<>(path));
        }
        for(int i=index;i<s.length();i++){
            if(isPali(s,index,i)){
                path.add(s.substring(index,i+1));
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPali(String s, int start, int end){
       while(start<=end){
           if(s.charAt(start++) != s.charAt(end--)) return false;
       }
        return true;
    }
}