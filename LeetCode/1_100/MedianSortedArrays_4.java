/**
 * 大佬的解法 leetcode 用户 : Wait想念
 * 
 * 精妙: 1.两数组找中位数 奇偶解法同型 
 * 奇数:(m+n+1) / 2 == (m+n+2) / 2 
 * 偶数:(m+n+1) / 2 ,(m+n+2) /2 
 * 找到上述两个数字求其平均数即可
 * 
 * 题目变成了 寻找两有序数组 合并后(实际未合并) 特定位置的数字值 ,题目要求O(logn) 很明显需要二分查找
 * 
 * findKth运用剪枝
 * 精妙2 : todo
 * 
 * @author charQ
 *
 */
public class MedianSortedArrays_4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int left = (m + n + 1) / 2;
		int right = (m + n + 2) / 2;

		return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
	}

	/**
	 * 两顺序数组中找到 第k个数
	 * 
	 * @param nums1
	 * @param i
	 *            nums1起始位置
	 * @param nums2
	 * @param j
	 *            nums2起始位置
	 * @param k
	 *            第几个数
	 * @return
	 */
	public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
		if (i >= nums1.length)
			return nums2[j + k - 1]; // nums1为空
		if (j >= nums2.length)
			return nums1[i + k - 1]; // nums2为空
		if (k == 1)
			return Math.min(nums1[i], nums2[j]);
		/**
		 * 赋予最大值的意思只是说如果第一个数组的K/2不存在，则说明这个数组的长度小于K/2，那么另外一个数组的前K/2个我们是肯定不要的。
		 * 给你举个例子，加入第一个数组长度是2，第二个数组长度是12，则K为7，K/2为3，
		 * 因为第一个数组长度小于3，则无法判断中位数是否在其中，而第二个数组的前3个肯定不是中位数！
		 * 故当K/2不存在时，将其置为整数型最大值，这样就可以继续下一次循环。
		 */
		int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
		int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
		if (midVal1 < midVal2) {
			return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
		} else {
			return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
		}

	}

	public static void main(String[] args) {
		MedianSortedArrays_4 m = new MedianSortedArrays_4();
		int[] nums1 = { 1, 3, 5, 7, 9 };
		int[] nums2 = { 2, 4, 6, 8, 10, 12 };
		System.out.println(m.findMedianSortedArrays(nums1, nums2));
	}
}
