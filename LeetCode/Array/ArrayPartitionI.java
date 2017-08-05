import java.util.Arrays;

/**
 * Created by q on 17-8-4.
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i+=2) {
            result += nums[i];
        }
        return result;
    }
}
