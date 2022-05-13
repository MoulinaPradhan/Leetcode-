class Solution {
    public int compareVersion(String version1, String version2) {
        String rev1[] = version1.split("\\.");
        String rev2[] = version2.split("\\.");
        
        for(int i = 0; i < Math.max(rev1.length, rev2.length); i++){
            int v1 = 0, v2 = 0;
            if(i < rev1.length)    
                v1 = Integer.parseInt(rev1[i]);
            
            if(i < rev2.length)
                v2 = Integer.parseInt(rev2[i]);
    
            
            if(v1 != v2)
                return v1 > v2 ? 1 : -1;
        }
        
        return 0;
    }
}