/**
 * ���еĽⷨ leetcode �û� : Wait����
 * 
 * ����: 1.����������λ�� ��ż�ⷨͬ�� 
 * ����:(m+n+1) / 2 == (m+n+2) / 2 
 * ż��:(m+n+1) / 2 ,(m+n+2) /2 
 * �ҵ�����������������ƽ��������
 * 
 * ��Ŀ����� Ѱ������������ �ϲ���(ʵ��δ�ϲ�) �ض�λ�õ�����ֵ ,��ĿҪ��O(logn) ��������Ҫ���ֲ���
 * 
 * findKth���ü�֦
 * ����2 : todo
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
	 * ��˳���������ҵ� ��k����
	 * 
	 * @param nums1
	 * @param i
	 *            nums1��ʼλ��
	 * @param nums2
	 * @param j
	 *            nums2��ʼλ��
	 * @param k
	 *            �ڼ�����
	 * @return
	 */
	public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
		if (i >= nums1.length)
			return nums2[j + k - 1]; // nums1Ϊ��
		if (j >= nums2.length)
			return nums1[i + k - 1]; // nums2Ϊ��
		if (k == 1)
			return Math.min(nums1[i], nums2[j]);
		/**
		 * �������ֵ����˼ֻ��˵�����һ�������K/2�����ڣ���˵���������ĳ���С��K/2����ô����һ�������ǰK/2�������ǿ϶���Ҫ�ġ�
		 * ����ٸ����ӣ������һ�����鳤����2���ڶ������鳤����12����KΪ7��K/2Ϊ3��
		 * ��Ϊ��һ�����鳤��С��3�����޷��ж���λ���Ƿ������У����ڶ��������ǰ3���϶�������λ����
		 * �ʵ�K/2������ʱ��������Ϊ���������ֵ�������Ϳ��Լ�����һ��ѭ����
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
