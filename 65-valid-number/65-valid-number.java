class Solution {
    public boolean isNumber(String s) {
     if(s.contains("f") || s.contains("D")) return false;
        boolean d = true;
        try{
            Integer.parseInt(s);
        }catch(Exception e){
            d = false;
        }	try {
			Float.parseFloat(s);
			d = true;
		} catch (Exception e) {
			d = false;
		}
		return d;
        
    }
}