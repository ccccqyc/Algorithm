package P400_500;

import java.util.HashMap;
import java.util.Map;

/**
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * <p>
 * TinyURL is a URL shortening service where you enter a URL
 * such as https://leetcode.com/problems/design-tinyurl
 * and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure
 * that a URL can be encoded to a tiny URL
 * and the tiny URL can be decoded to the original URL.
 * Created by q on 17-7-27.
 */
public class P535 {
    Map<Integer, String> map = new HashMap<>();
    private String encode(String longUrl) {
        map.put(longUrl.hashCode(),longUrl);
        return "http://tinyurl.com/"+longUrl.hashCode();
    }
    private String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}