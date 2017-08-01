import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by q on 17-8-1.
 */
public class P1042 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        bufferedReader.close();

        s = s.toLowerCase();
        Map<Character, Integer> maps = pross(s);

        int max = 0;
        Character character = 'a';
        for (Character i = 'a'; i < 'z'; i++) {
            if (maps.containsKey(i)) {
                if (max < maps.get(i)) {
                    max = maps.get(i);
                    character = i;
                } else if (max == maps.get(i)) {
                    character = (character.compareTo(i) < 0) ? character : i;
                }
            }
        }
        System.out.println(character + " " + max);
    }

    private static Map<Character, Integer> pross(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        char c;

        for (char aChar : chars) {
            c = aChar;
            if (c <= 122 && c >= 97) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
        }
        return map;
    }


}
