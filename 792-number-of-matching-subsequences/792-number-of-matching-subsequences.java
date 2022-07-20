class Solution {
    public int numMatchingSubseq(String s, String[] words) {
  if(s.length()==0) return 1;
    if(words.length==0) return 0;
    
    int count = 0;
    HashMap<String,Boolean> hm = new HashMap<>();
    
    
    for(int i=0;i<words.length;i++)
    {
        if(hm.containsKey(words[i]))
        {
            boolean flag = hm.get(words[i]);
            if(flag==true) count++;
        }
        
        else
        {
            if(IsSubsequence(s,words[i]))
            {
                hm.put(words[i],true);
                count++;
            }
            else
            {
                hm.put(words[i],false);
            }
        }
        
    }
    
    return count;
    
}

public static boolean IsSubsequence(String t,String s)
{
    if (t.length()==0) return false;
    if(s.length()==0) return true;
    
    if(s.length()>t.length()) return false;
    
    int sidx = 0 , tidx = 0;
    
    for(int i=tidx;i<t.length() && sidx<s.length();i++)
    {
        
        if(t.charAt(i)==s.charAt(sidx)) sidx++ ;
    }
    
    if(sidx==s.length()) return true;
    
    return false;
    }
}