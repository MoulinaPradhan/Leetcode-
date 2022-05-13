class Solution {
    public String countAndSay(int n) {
     if(n == 1) return "1";

StringBuilder res = new StringBuilder();

// recursively call for (n-1) th number, "0" is only for the edge case at the end of the loop with `s.charAt(i+1)`
String s = countAndSay(n-1); 

for(int i=0, c=1; i < s.length(); i++, c++){
	// if next digit is different, then append the count so far `c` and the digit itself, then set count `c` to zero
	//Added condition to see if it's the last character to terminate and count the freq so far
             if(i==s.length()-1 || s.charAt(i+1) != s.charAt(i)){
		res.append(c).append(s.charAt(i));
		c = 0;  
	}
}

return res.toString();
    }
}