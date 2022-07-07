class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;

    boolean[] optimal = new boolean[s2.length() + 1];   
    optimal[0] = true;
    for (int j = 0; j < s2.length(); j++) {
        if (optimal[j] && s2.charAt(j) == s3.charAt(j)) optimal[j + 1] = true;
    }

    for (int i = 0; i < s1.length(); i++) { 
        if (optimal[0] && s1.charAt(i) == s3.charAt(i)) optimal[0] = true;    
        else optimal[0] = false;
        for (int j = 0; j < s2.length(); j++) { 
            if ((s1.charAt(i) == s3.charAt(i + j + 1) && optimal[j + 1]) ||
                    s2.charAt(j) == s3.charAt(i + j + 1) && optimal[j]) {
                optimal[j + 1] = true;
            } else optimal[j + 1] = false;
        }
    }
    return optimal[s2.length()];
    }
}