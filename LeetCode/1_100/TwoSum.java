import java.util.HashMap;

class TwoSum {
    /**
     * 常规解法, 就是遍历
     * T(n) = O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_1(int[] nums, int target) {
        int index0 = 0, index1 = 1;
        C:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    index0 = i;
                    index1 = j;
                    break C;
                }
            }
        }

        return new int[]{index0, index1};
    }

    public int[] twosum_2(int[] nums, int target) {
        int[] arr = new int[2];
        int length = nums.length;
        HashMap hashMap = new HashMap();
        int temp;
        for (int i = 0; i < length; i++) {
            temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                arr[0] = (int) hashMap.get(temp);
                arr[1] = i;
                break;
            }
            hashMap.put(nums[i], i);
        }

        return arr;
    }
}