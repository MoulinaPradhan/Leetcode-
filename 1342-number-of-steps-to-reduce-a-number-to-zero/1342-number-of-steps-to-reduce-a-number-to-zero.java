class Solution {
    public int numberOfSteps(int num) {
      return cfn(num,0);  
    }
    public int cfn(int n,int c ){
        if(n ==0) return c;
        if(n %2 == 0) return cfn(n/2,c+1);
      
        return  cfn(n-1,c+1);
    }
}