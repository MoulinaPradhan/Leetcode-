class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st =new Stack<>();
        char paren[] = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) =='('){
                st.push(i);
            }else{
                if(!st.isEmpty()){
                    int k = st.pop();
                    paren[k] ='x';
                    paren[i]='x';
                }
            }
        }int max=0, count=0;
        for(char c: paren){
            if(c=='x'){
            count++;
            max = Math.max(max,count);
            }
            else
                count=0;
        }
        return max;
    }
}