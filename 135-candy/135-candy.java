class Solution {
    public int candy(int[] ratings) {
        
        int dp[] = new int[ratings.length];
        Arrays.fill(dp,1);
        
        for(int i=1;i<dp.length;i++){
           if(ratings[i] > ratings[i-1]){
             
               dp[i]= dp[i-1]+1;
           }
         }
        
        for(int i=dp.length-2; i>=0;i--){
           if (ratings[i] > ratings[i + 1]) {
               dp[i] = Math.max(dp[i],dp[i+1]+1);
           }  
        }
        
        
        int sum = 0;
        for(int i=0;i<ratings.length;i++){
            sum+=dp[i];
            // System.out.println(dp[i]);
        }
        return sum;
    }
}