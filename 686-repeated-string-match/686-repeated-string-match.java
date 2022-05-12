class Solution {
    public int repeatedStringMatch(String A, String B) {
  int c=0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < B.length()){
            sb.append(A);
            c++;
        }
        if(sb.toString().contains(B)) return c;
        if(sb.append(A).toString().contains(B) ) return ++c;
        return -1;
            
    }
}