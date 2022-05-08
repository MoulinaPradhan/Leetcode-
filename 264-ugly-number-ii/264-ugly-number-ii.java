class Solution {
    public int nthUglyNumber(int n) {
       int[] primes = new int[]{2, 3, 5};
        
        int[] uglyNumber = new int[n];
        
        //as given. 
        uglyNumber[0] = 1;
        
        //primeIndex[i]  signyfy that for this prime number, 
        //which already created ugly we have to select for creating this current ugly number 
        int[] primeIndex = new int[primes.length];

       
        for (int i = 1; i < n; i++) {
            //create current ugly number
            uglyNumber[i] = Integer.MAX_VALUE;
            
            for (int j = 0; j < primes.length; j++){
                uglyNumber[i] = Math.min(uglyNumber[i], primes[j] * uglyNumber[primeIndex[j]]);
            }

            //increment prime indexes
            for (int j = 0; j < primes.length; j++) {
                if(uglyNumber[i] % primes[j] == 0) {
                    primeIndex[j]++;
                }
            }
        }

        return uglyNumber[n - 1];
    }
}