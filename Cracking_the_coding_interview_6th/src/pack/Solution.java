package pack;

import java.util.Arrays;

/**
 * @author ccccqyc
 * @date : 2022/01/04/12:45
 */
public class Solution {
    /**
     * 面试题 01.01. 判定字符是否唯一
     * T(n) = O(n)
     * S(n) = O(n)
     * <p>
     * 先排序,再位运算
     */
    public boolean isUnique(String astr) {
        char[] cs = astr.toCharArray();
        Arrays.sort(cs);
        for (int i = 1; i < cs.length; i++) {
            if ((cs[i - 1] ^ cs[i]) == 0) {
                return false;
            }
        }
        return true;
    }
}
