class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch)){
                st.push(ch);
            }
            else{
                if(st.isEmpty() || map.get(ch) !=st.peek()) return false;  
                st.pop();
            }
           
        }
        return st.isEmpty();
    }
}