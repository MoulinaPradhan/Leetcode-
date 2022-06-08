class Solution {
    public int removePalindromeSub(String s) {
        if(s.isEmpty())return 0;
        if(isPali(s)) return 1;
        return 2;
    }
    public boolean isPali(String s){
        int st=0,e=s.length()-1;
        while(st<=e){
            if(s.charAt(st++) != s.charAt(e--)) return false;
        }
        return true;
    } 
}