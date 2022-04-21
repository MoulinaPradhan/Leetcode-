class Solution {
    public int reverse(int x) {
        int sign = x >= 0? 1: -1;
        x *= sign;
        int y = 0;
        while(x > 0) {
            if(y > Integer.MAX_VALUE / 10) {
                return 0;
            }
            y *= 10;
            y += x % 10;
            x /= 10;
        }
        return sign * y; 
    }
}