import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sum_3 {
    public static void main(String[] args) {
        System.out.println(new Sum_3().threeSum(new int[0]));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums.length == 0 || nums.length == 1) {
            return lists;
        }

        int[] numscopy = new int[nums.length];
        Arrays.fill(numscopy, 0);


        return new LinkedList<>();
    }

}

