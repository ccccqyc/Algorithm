package find_peak_element;

/**
 * Created by q on 17-7-27.
 */
public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int i = 1;
        int j = A.length-2;
        for(;i <= j;i++,j--){
            if(A[i]>A[i+1])
                return i;
            else if(A[j]>A[j-1])
                return j;
        }
        return 0;
    }
}
