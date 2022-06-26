class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum =0;
    int left [] = new int [k+1];
    int right[] = new int [k+1];
    
    left[0] = right[0] =0;
  

for(int i=1;i<=k;i++){
 left[i] = left[i-1] + cardPoints[i-1];

    }
    for(int i=1;i<=k;i++){
        right[i] = right[i-1] + cardPoints[cardPoints.length-i];
    }

    for(int i=0;i<=k;i++){
       sum = Math.max(sum, left[i]+ right[k-i]);
    }

    return sum;
    
    }
}