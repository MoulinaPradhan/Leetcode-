class Solution {
    public int maxProduct(String[] words) {
     int n = words.length, mask[] = new int[n], res = 0;
        
        for(int i=0 ; i<n ; i++)
            for(char ch : words[i].toCharArray())
                mask[i] |= (1<<(ch-'a'));
        
        for(int i=0 ; i<n ;i++)
            for(int j=i ; j<n ; j++)
                if( (mask[i] & mask[j]) == 0 )
                     res = Math.max( res, words[i].length()*words[j].length() );
            
        return res;   
    }
}