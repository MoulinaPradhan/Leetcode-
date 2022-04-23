public class Codec {

    // Encodes a URL to a shortened URL.
    public Map<String,String> map = new HashMap<>();
    int i=0;
    public String encode(String longUrl) {
       String s = "http://tinyurl.com/";
        s+= String.valueOf(i);
        map.put(s,longUrl);
        i++;
        return s;
        
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));