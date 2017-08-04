import java.util.HashMap;
import java.util.Map;

/**
 * Created by q on 17-7-27.
 */
public class P535 {
    private Map<Integer, String> map = new HashMap<>();

    private String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    private String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}