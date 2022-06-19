class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
           List<List<String>> list = new ArrayList<>();
        
        Arrays.sort(products,String.CASE_INSENSITIVE_ORDER);
        
        for(int i=0;i<searchWord.length();i++){
            String search = searchWord.substring(0,i+1);
            List<String> res = new ArrayList<>();
            for(String e: products){
            if(e.startsWith(search) && res.size()<3 ){
             res.add(e);   
           }
        } 
            list.add(res);
        }
       
        return list;
    }
}