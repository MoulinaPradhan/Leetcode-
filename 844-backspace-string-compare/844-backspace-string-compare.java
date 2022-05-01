class Solution {
    public boolean backspaceCompare(String s, String t) {
        String ms = fn("",s);
        String mt = fn("",t);
        return ms.equals(mt);
        
    }
   
        public String fn(String ans ,String og ){
            if(og.isEmpty()) return ans;
            char ch = og.charAt(0);
            if(ch == '#' && ans.length() >0){
                return fn(ans.substring(0,ans.length()-1), og.substring(1));
            }
            else if(ch == '#' && ans.length() ==0)
             return fn(ans, og.substring(1));
            else
                return fn(ans+ch,og.substring(1));
        }
    
    
}