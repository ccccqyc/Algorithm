package normal;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.*;

/**
 * @author ccccqyc
 * @date : 2022/01/03/14:50
 */
public class Solution {
    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * <p>
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int[] rets;
        while (head != null) {
            stack.push(head.val);
            count++;
            head = head.next;
        }
        rets = new int[count];
        while (!stack.empty()) {
            rets[rets.length - count--] = stack.pop();
        }
        return rets;
    }

    /**
     * 剑指 Offer 24. 反转链表
     * <p>
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode temp;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = res;
            res = temp;
        }
        return res;
    }

    /**
     * 剑指 Offer 35. 复杂链表的复制
     * T(n) = O(n^2)
     * S(n) = O(n)
     *
     * <p>
     * Definition for a Node.
     * class Node {
     * int val;
     * Node next;
     * Node random;
     * <p>
     * public Node(int val) {
     * this.val = val;
     * this.next = null;
     * this.random = null;
     * }
     * }
     */
    public Node copyRandomList(Node head) {
        int length = 0;
        Node temp = head;
        // length
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        Node[] nodes = new Node[length];

        // create nodes
        temp = head;
        while (temp != null) {
            nodes[nodes.length - length--] = new Node(temp.val);
            temp = temp.next;
        }

        // next rondom
        Node temp2, temp3 = head;
        int index = 0, count = 0;
        while (temp3 != null) {
            temp2 = temp3.random;
            temp = head;
            count = 0;
            // random
            if (temp2 == null) {
                nodes[index].random = null;
            } else {
                while (temp != temp2) {
                    temp = temp.next;
                    count++;
                }
                nodes[index].random = nodes[count];
            }
            // next
            if (index < nodes.length - 1) {
                nodes[index].next = nodes[index + 1];
            } else {
                nodes[index].next = null;
            }

            index++;
            temp3 = temp3.next;
        }
        return (head == null) ? null : nodes[0];
    }

    /**
     * 剑指 Offer 35. 复杂链表的复制
     * 解法 2
     * T(n) = O(n)
     * S(n) = O(n)
     *
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            map.get(cur).random = map.get(cur.random);
            map.get(cur).next = map.get(cur.next);
        }
        return (head == null) ? null : map.get(head);
    }

    /**
     * 剑指 Offer 05. 替换空格
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    /**
     * 剑指 Offer 58 - II. 左旋转字符串
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder str = new StringBuilder(s.substring(n));
        str.append(s, 0, n);
        return str.toString();
    }

    /**
     * 剑指 Offer 03. 数组中重复的数字
     * 解法一
     * <p>
     * T(n) = O(n)
     * S(n) = O(n)
     * <p>
     */
    public int findRepeatNumber(int[] nums) {
        int temp = -1, length = nums.length;
        int[] ints = new int[nums.length];
        for (int i = 0; i < length; i++) {
            ints[nums[i]]++;
            if (ints[nums[i]] > 1) {
                temp = nums[i];
                break;
            }
        }
        return temp;
    }

    /**
     * 剑指 Offer 03. 数组中重复的数字
     * 解法二
     * <p>
     * T(n) = O(n)
     * S(n) = O(1)
     * <p>
     */
    public int findRepeatNumber2(int[] nums) {
        int ret = -1, temp = 0, length = nums.length;
        for (int i = 0; i < length; i++) {
            temp = nums[nums[i]];
            if (temp == nums[i]) {
                ret = temp;
                break;
            }
            nums[nums[i]] = nums[i];
            nums[i] = temp;
        }
        return ret;
    }

    /**
     * 剑指 Offer 53 - I. 在排序数组中查找数字 I
     * <p>
     * 二分查找
     * T(n) = O(logN)
     * S(n) = O(1)
     */
    public int search(int[] nums, int target) {
        int low = 0, mid = 0, hight = nums.length - 1;
        while (low < hight) {
            mid = (low + hight) / 2;
            if (nums[mid] >= target) {
                hight = mid;
            } else {
                low = mid + 1;
            }
        }
        int count = 0;
        while (low < nums.length && nums[low++] == target) {
            count++;
        }
        return count;
    }

    /**
     * 剑指 Offer 53 - II. 0～n-1中缺失的数字
     * 解法1
     * T(n) = O(N)
     * S(n) = O(1)
     */
    public int missingNumber(int[] nums) {
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                break;
            }
        }
        return i;
    }

    /**
     * 剑指 Offer 53 - II. 0～n-1中缺失的数字
     * 解法2 有序先想到二分查找
     * T(n) = O(logN)
     * S(n) = O(1)
     */
    public int missingNumber2(int[] nums) {
        int i = 0;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low < high) {
            mid = (high + low) / 2;
            if (mid < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return i;
    }

    /**
     * 剑指 Offer 04. 二维数组中的查找
     * T(n) = O(N^2)
     * S(n) = O(1)
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean ret = false;
        if (matrix.length == 0) {
            return ret;
        }
        int row = matrix.length, clo = matrix[0].length;
        c:
        for (int i = clo - 1; i >= 0; i--) {
            for (int j = 0; j < row; j++) {
                if (target > matrix[j][i]) {
                    continue;
                } else if (target < matrix[j][i]) {
                    break;
                } else {
                    ret = true;
                    break c;
                }

            }
        }
        return ret;
    }

    /**
     * 剑指 Offer 50. 第一个只出现一次的字符
     * T(n) = O(n)
     * S(n) = O(n)
     */
    public char firstUniqChar(String s) {
        char ret = ' ', tempc = ' ';
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            tempc = s.charAt(i);
            map.put(tempc, map.getOrDefault(tempc, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            tempc = s.charAt(i);
            if (map.get(tempc) == 1) {
                ret = tempc;
                break;
            }
        }
        return ret;
    }

    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * T(n) = O(n)
     * S(n) = O(1)
     */
    public int minArray(int[] numbers) {
        int ret = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                ret = numbers[i + 1];
                break;
            }
        }
        return ret;
    }

    /**
     * 剑指 Offer 32 - I. 从上到下打印二叉树
     * <p>
     * T(n) = O(n)
     * S(n) = O(1)
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> integerList = new ArrayList<>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            integerList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return integerList.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II
     * T(n) = O(n)
     * S(n) = O(1)
     */
    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> retlist = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        List<Integer> tempList;
        int count;
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            tempList = new LinkedList<>();
            count = queue.size();
            while (count != 0) {
                node = queue.poll();
                tempList.add(node.val);
                count--;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            retlist.add(tempList);
        }
        return retlist;
    }

    /**
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     * T(n) = O(n)
     * S(n) = O(1)
     */
    public List<List<Integer>> levelOrderIII(TreeNode root) {
        List<List<Integer>> retlist = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        List<Integer> tempList;
        int count, row = 0;

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            tempList = new LinkedList<>();
            count = queue.size();
            row ^= 1;
            while (count != 0) {
                node = queue.poll();
                tempList.add(node.val);
                count--;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (row == 0) {
                Collections.reverse(tempList);
            }
            retlist.add(tempList);
        }
        return retlist;
    }

    /**
     * 剑指 Offer 26. 树的子结构
     * 前序递归
     * <p>
     * T(n) = O(n*m)
     * S(n) = O(1)
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }

    /**
     * 剑指 Offer 27. 二叉树的镜像
     * <p>
     * 递归
     * T(n) = O(n)
     * S(n) = O(1)
     */
    public TreeNode mirrorTree(TreeNode root) {
        mirror(root);
        return root;
    }

    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        } else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        mirror(root.left);
        mirror(root.right);
    }

    /**
     * 剑指 Offer 27. 二叉树的镜像II
     * <p>
     * 递归
     * T(n) = O(n)
     * S(n) = O(1)
     */
    public TreeNode mirrorTreeII(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp, node;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            node = temp.left;
            temp.left = temp.right;
            temp.right = node;
            if (temp.right != null) {
                queue.add(temp.right);
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
        }
        return root;
    }

    /**
     * 剑指 Offer 28. 对称的二叉树
     * <p>
     * 非递归
     * T(n) = O(n^2)
     * S(n) = O(n)
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean ret = true;
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> treeNodeList = new ArrayList<>();
        TreeNode node, temp1, temp2;
        int count = 0, length = 0;
        queue.add(root);
        c:
        while (!queue.isEmpty()) {
            count = queue.size();
            while (count != 0) {
                node = queue.poll();
                treeNodeList.add(node);
                count--;
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            length = treeNodeList.size();
            for (int i = 0; i < length / 2; i++) {
                temp1 = treeNodeList.get(i);
                temp2 = treeNodeList.get(length - 1 - i);
                if (temp1 == null || temp2 == null) {
                    if (temp1 != temp2) {
                        ret = false;
                        break c;
                    }
                    continue;
                }
                if (temp1.val != temp2.val) {
                    ret = false;
                    break c;
                }
            }
            treeNodeList.clear();
        }
        return ret;
    }

    /**
     * 剑指 Offer 28. 对称的二叉树
     * <p>
     * 递归
     * T(n) = O(n^2)
     * S(n) = O(n)
     */
    public boolean isSymmetricII(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmerichelp(root.left, root.right);
    }

    public boolean isSymmerichelp(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }
        return node1.val == node2.val && isSymmerichelp(node1.left, node2.right) && isSymmerichelp(node1.right, node2.left);
    }

    /**
     * 剑指 Offer 63. 股票的最大利润
     * T(n) = O(n)
     * S(n) = O(1)
     *
     * @since 2022-01-09 19:51:28
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1 || prices == null) {
            return 0;
        }

        int indexMax = 0, indexMin = 0, res = 0, min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                res = Math.max(res, prices[i] - min);
            }
        }
        return res;
    }

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * T(n) = O(n)
     * S(n) = O(1)
     *
     * @since 2022-01-09 20:19:33
     */
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] ints = new int[n + 1];
        ints[0] = 1;
        ints[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            ints[i] = (ints[i - 1] + ints[i - 2]) % 1000000007;
        }
        return ints[n];
    }

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     * T(n) = O(n)
     * S(n) = O(1)
     *
     * @since 2022-01-09 20:54:31
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int[] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 0; i < n + 1; i++) {
            ints[i] = (ints[i - 1] + ints[i - 2]) % 1000000007;
        }
        return ints[n];
    }

    /**
     * 剑指 Offer 42. 连续子数组的最大和
     * 动态规划.
     * <p>
     * 先计算子问题,再由子问题计算父问题
     * 重叠子问题,最优子结构,刻画最优的结构
     * <p>
     * T(n) = O(n)
     * S(n) = O(1)
     *
     * @since 2022-01-10 08:30:29
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int max = dp[0];

        // dp[i] i子序列最优解
        // max_i 子序列最优解

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 剑指 Offer 47. 礼物的最大价值
     * 动态规划
     * <p>
     * T(n) = O(n)
     * S(n) = O(n)
     *
     * @since 2022-01-10 10:22:01
     */
    public int maxValue(int[][] grid) {
        int rowlength = grid.length, clomnlength = grid[0].length;
        int[] dp = new int[clomnlength + 1];
        for (int i = 1; i <= rowlength; i++) {
            for (int j = 1; j <= clomnlength; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[rowlength];
    }

    /**
     * 剑指 Offer 46. 把数字翻译成字符串
     * 青蛙跳抽象版.
     * <p>
     * T(n) = O(n)
     * S(n) = O(n)
     *
     * @since 2022-01-11 19:06:51
     */
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }

        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length() + 1];
        dp[0] = dp[1] = 1;
        String strtemp;

        for (int i = 2; i < dp.length; i++) {
            strtemp = numStr.substring(i - 2, i);
            if (Integer.valueOf(strtemp) < 26 && Integer.valueOf(strtemp) >= 10) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }

    /**
     * 剑指 Offer 48. 最长不含重复字符的子字符串
     * 动态规划.
     * <p>
     * T(n) = O(n^2)
     * S(n) = O(n)
     *
     * @since 2022-01-11 20:36:29
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        } else if (s.length() <= 1) {
            return s.length();
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        int max = 1, index = 0;
        String strtemp;
        char chartemp;
        for (int i = 1; i < s.length(); i++) {
            strtemp = s.substring(i - dp[i - 1], i);
            chartemp = s.charAt(i);
            index = strtemp.indexOf(chartemp);
            if (index == -1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1] - index;
            }
            max = (max < dp[i]) ? dp[i] : max;
        }

        return max;
    }

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     * 双指针
     * <p>
     * T(n) = O(n)
     * S(n) = O(1)
     *
     * @since 2022-01-12 08:27:25
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int count = 0;
        ListNode index1 = head, index2 = head;
        while (index1 != null) {
            count++;
            index1 = index1.next;
        }
        index1 = head;
        if (k > count) {
            return null;
        }

        for (int i = 1; i < k; i++) {
            index2 = index2.next;
        }
        while (index2.next != null) {
            index1 = index1.next;
            index2 = index2.next;
        }

        return index1;
    }

    /**
     * 剑指 Offer 18. 删除链表的节点
     * 双指针
     * <p>
     * T(n) = O(n)
     * S(n) = O(1)
     *
     * @since 2022-01-12 08:50:06
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode temp1 = head, temp2 = head.next;
        while (temp2 != null) {
            if (temp2.val == val) {
                temp1.next = temp2.next;
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return head;
    }

    /**
     * 剑指 Offer 25. 合并两个排序的链表
     * T(n) = O(n+m)
     * S(n) = O(1)
     *
     * @since 2022-01-13 19:09:11
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        ListNode temp;
        if (l2 != null && l1.val > l2.val) {
            temp = l2;
            l2 = l1;
            l1 = temp;
        }
        ListNode ret = l1;

        while (l2 != null) {
            if (l1.val <= l2.val) {
                if (l1.next == null) {
                    l1.next = l2;
                    break;
                }
                if (l1.next.val <= l2.val) {
                    l1 = l1.next;
                } else {
                    temp = l1.next;
                    l1.next = l2;
                    l2 = l2.next;
                    l1.next.next = temp;
                }
            } else {
                temp = l2;
                l2 = l1;
                l1 = temp;
            }
        }
        return ret;
    }

    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点
     * <p>
     * T(n) = O(max(m,n))
     * S(n) = O(1)
     *
     * @since 2022-01-13 20:14:21
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int countA = 0, countB = 0;
        ListNode temp = headA;
        while (temp != null) {
            countA++;
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            countB++;
            temp = temp.next;
        }
        int c = 0;
        if (countA < countB) {
            c = countA;
            countA = countB;
            countB = c;

            temp = headA;
            headA = headB;
            headB = temp;
        }
        c = countA - countB;
        while (c != 0) {
            c--;
            headA = headA.next;
        }
        temp = null;
        while (headA != null) {
            if (headB == headA) {
                temp = headA;
                break;
            } else {
                headB = headB.next;
                headA = headA.next;
            }
        }

        return temp;
    }

    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点
     * <p>
     * 解法二
     * <p>
     * T(n) = O(max(m,n))
     * S(n) = O(1)
     *
     * @since 2022-01-13 20:38:48
     */
    public ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode n1 = headA, n2 = headB;
        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }

        return n1;
    }

    /**
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
     * <p>
     * 双指针
     * T(n) = O(n)
     * S(n) = O(1)
     *
     * @since 2022-01-14 09:07:38
     */
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1, temp;
        while (left < right) {
            if (nums[left] % 2 == 1) {
                left++;
            } else if (nums[right] % 2 == 0) {
                right--;
            } else {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }

    /**
     * 剑指 Offer 57. 和为s的两个数字
     * 使用双指针特点,数组有序,求和
     *
     * <p>
     * T(n) = O(n)
     * S(n) = O(1)
     *
     * @since 2022-01-14 09:32:39
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[]{};
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ret = new int[]{nums[left], nums[right]};
                break;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return ret;
    }

    /**
     * 剑指 Offer 58 - I. 翻转单词顺序
     * <p>
     * T(n) = O(n)
     * S(n) = O(1)
     *
     * @since 2022-01-14 12:03:58
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] strings = s.split(" ");
        StringBuilder stringJoiner = new StringBuilder();
        String temp;
        for (int i = strings.length - 1; i >= 0; i--) {
            temp = strings[i].trim();
            if (!temp.equals("")) {
                stringJoiner.append(temp).append(" ");
            }
        }
        return stringJoiner.toString().trim();
    }

    /**
     * 剑指 Offer 12. 矩阵中的路径
     * 回溯
     * todo
     * <p>
     * T(n) = O(m*n)
     * S(n) = O(1)
     *
     * @since 2022-01-15 10:06:16
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || word.equals("")) {
            return false;
        }
        int row = board.length, colmn = board[0].length, index = 0;
        boolean[][] visit = new boolean[row][colmn];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colmn; j++) {
                index = 0;
                if (board[i][j] == word.charAt(0)) {
                    if (existJudge(word, index, i, j, board, visit)) {
                        return true;
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public boolean existJudge(String s, int index, int row, int col, char[][] board, boolean[][] visit) {
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || index >= s.length()
                || s.charAt(index) != board[row][col]
                || visit[row][col]) {
            return false;
        }
        if (index == s.length() - 1 && s.charAt(index) == board[row][col]) {
            return true;
        }
        visit[row][col] = true;
        index++;
        boolean ret = existJudge(s, index, row - 1, col, board, visit)
                || existJudge(s, index, row, col - 1, board, visit)
                || existJudge(s, index, row + 1, col, board, visit)
                || existJudge(s, index, row, col + 1, board, visit);
        visit[row][col] = false;
        return ret;
    }

    /**
     * 剑指 Offer 13. 机器人的运动范围
     * 回溯,深度优先算法
     * 深度优先 - 递归实现
     * <p>
     * T(n) = O(n*m)
     * S(n) = O(m*n)
     *
     * @since 2022-01-15 10:56:55
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        return DFSmovingCount(m, n, 0, 0, k, visit);
    }

    /**
     * 递归实现.
     */
    public int DFSmovingCount(int m, int n, int i, int j, int k, boolean[][] visit) {
        if (i >= m || j >= n || visit[i][j] || (i % 10 + i / 10 + j % 10 + j / 10) > k) {
            return 0;
        }
        visit[i][j] = true;
        return 1 + DFSmovingCount(m, n, i, j + 1, k, visit) + DFSmovingCount(m, n, i + 1, j, k, visit);
    }

    /**
     * 剑指 Offer 34. 二叉树中和为某一值的路径
     * todo
     * <p>
     * T(n) = O(n)
     * S(n) = O(1)
     *
     * @since 2022-01-16 21:21:48
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> list = new LinkedList<>();
        pathSumhelper(root, target, list, new ArrayList<>());
        return list;
    }

    public void pathSumhelper(TreeNode root, int target, List<List<Integer>> res, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            pathSumhelper(root.right, target, res, list);
        }
        list.remove(list.size() - 1);
    }

    /**
     * 剑指 Offer 54. 二叉搜索树的第k大节点
     * 二叉搜索树 中序为递增数列
     * <p>
     * T(n) = O(K)
     * S(n) = O(1)
     *
     * @since 2022-01-16 20:48:00
     */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthLargestList(root, list);
        return list.get(list.size() - k);
    }

    public void kthLargestList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            kthLargestList(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            kthLargestList(root.right, list);
        }

    }

    /**
     * 剑指 Offer 36. 二叉搜索树与双向链表
     * 二叉搜索树,构造双向链表
     * <p>
     * T(n) = O(K)
     * S(n) = O(1)
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        treeToDoublyListHelper(root, stack);
        TreeNode head = stack.poll(), temp = head;
        while (!stack.isEmpty()) {
            temp.right = stack.poll();
            temp.right.left = temp;
            temp = temp.right;
        }
        temp.right = head;
        head.left = temp;
        return head;
    }

    /**
     * 中序
     */
    public void treeToDoublyListHelper(TreeNode root, Queue<TreeNode> stack) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            treeToDoublyListHelper(root.left, stack);
        }
        stack.add(root);
        if (root.right != null) {
            treeToDoublyListHelper(root.right, stack);
        }
    }

    /**
     * 剑指 Offer 45. 把数组排成最小的数
     * <p>
     * T(n) = O(K)
     * S(n) = O(1)
     *
     * @since 2022-01-17 18:54:16
     */
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        minNumberquickSort(strings, 0, strings.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings
        ) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    /**
     * 快排
     */
    public void minNumberquickSort(String[] strs, int l, int r) {
        if (l > r) {
            return;
        }
        int i = l, j = r;
        String temp = strs[l];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[i] + strs[l]) >= 0 && i < j) {
                j--;
            }
            while ((strs[i] + strs[l]).compareTo(strs[j] + strs[l]) <= 0 && i < j) {
                i++;
            }
            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }
        strs[i] = strs[l];
        strs[l] = temp;

        minNumberquickSort(strs, l, i - 1);
        minNumberquickSort(strs, i + 1, r);

    }

    /**
     * 剑指 Offer 61. 扑克牌中的顺子
     * <p>
     * T(n) = O(K)
     * S(n) = O(1)
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zerocnt = 0, diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zerocnt++;
            } else {
                if (nums[i] == nums[i + 1]) {
                    return false;
                }
                if (nums[i] + 1 != nums[i + 1]) {
                    diff += nums[i + 1] - nums[i] - 1;
                }
            }
        }
        return zerocnt >= diff;
    }

    /**
     * 剑指 Offer 40. 最小的k个数
     * <p>
     * T(n) = O(K)
     * S(n) = O(1)
     *
     * @since 2022-01-18 08:39:48
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || k > arr.length) {
            return new int[]{};
        }
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }


    /**
     * 剑指 Offer 55 - I. 二叉树的深度
     * T(n) = O(K)
     * S(n) = O(1)
     *
     * @since 2022-01-19 08:38:15
     */
    public int maxDepth(TreeNode root) {
        int count = 0, countTemp = 0;
        if (root == null) {
            return count;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.add(temp);
        while (!queue.isEmpty()) {
            count++;
            countTemp = queue.size();
            while (countTemp > 0) {
                temp = queue.poll();
                countTemp--;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return count;
    }

    /**
     * 剑指 Offer 55 - II. 平衡二叉树
     * 回溯,剪枝
     * <p>
     * T(n) = O(K)
     * S(n) = O(1)
     *
     * @since 2022-01-19 11:20:05
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(isBalancedDFSI(root.left) - isBalancedDFSI(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    public int isBalancedDFSI(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(isBalancedDFSI(node.left), isBalancedDFSI(node.right)) + 1;
    }

    public int isBalancedDFS(TreeNode root) {
        int count = 0, countTemp = 0;
        if (root == null) {
            return count;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.add(temp);
        while (!queue.isEmpty()) {
            count++;
            countTemp = queue.size();
            while (countTemp > 0) {
                temp = queue.poll();
                countTemp--;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return count;
    }

    /**
     * 剑指 Offer 64. 求1+2+…+n
     *
     * <p>
     * T(n) = O(K)
     * S(n) = O(1)
     *
     * @since 2022-01-20 11:22:13
     */
    public int sumNums(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }

    /**
     * 剑指 Offer 64. 求1+2+…+n
     *
     * <p>
     * T(n) = O(K)
     * S(n) = O(1)
     *
     * @since 2022-01-20 11:22:13
     */
    public int sumNumsI(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    /**
     * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
     * <p>
     * T(n) = O(K)
     * S(n) = O(1)
     *
     * @since 2022-01-20 21:00:18
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    /**
     * 剑指 Offer 68 - II. 二叉树的最近公共祖先
     *
     * @since 2022-01-20 22:06:28
     */
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestorII(root.left, p, q);
        TreeNode right = lowestCommonAncestorII(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null && right == null) {
            return left;
        } else if (right != null && left == null) {
            return right;
        } else {
            return null;
        }
    }

    /**
     * 剑指 Offer 07. 重建二叉树
     * <p>
     * 前序+中序 -> 二叉树
     * T(n) = O(K)
     * S(n) = O(1)
     *
     * @since 2022-01-21 08:53:59
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }
        TreeNode left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        TreeNode right = buildTree(Arrays.copyOfRange(preorder, 1 + index, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        root.left = left;
        root.right = right;
        return root;
    }

    /**
     * 剑指 Offer 16. 数值的整数次方
     * 快速幂法
     * <p>
     * T(n) = O(K)
     * S(n) = O(1)
     * todo 快速幂
     *
     * @since 2022-01-21 20:57:25
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double ret = 1.0;
        if (n < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                ret *= x;
            }
            x *= x;
            b >>= 1;
        }

        return ret;
    }

    /**
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     * <p>
     * 空间换时间
     * <p>
     * T(n) = O(N)
     * S(n) = O(N^2)
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) {
            return true;
        }
        int index = postorder.length - 1;
        int index0 = 0, index1 = 0;
        while (postorder[index0] < postorder[index] && index0 < index) {
            index0++;
        }
        index1 = index0;
        while (postorder[index1] > postorder[index] && index1 < index) {
            index1++;
        }
        if (index1 != index) {
            return false;
        } else {
            return verifyPostorder(Arrays.copyOfRange(postorder, 0, index0)) &&
                    verifyPostorder(Arrays.copyOfRange(postorder, index0, index));
        }
    }

    /**
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     * 单调栈
     * todo
     */
    public boolean verifyPostorderI(int[] postorder) {
        return false;
    }

    /**
     * 剑指 Offer 15. 二进制中1的个数
     * 位运算
     * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
     * <p>
     * T(n) = O(N)
     * S(n) = O(1)
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;

    }

    /**
     * 剑指 Offer 15. 二进制中1的个数
     * 库方法
     */
    public int hammingWeightI(int n) {
        return Integer.bitCount(n);
    }

    /**
     * 剑指 Offer 65. 不用加减乘除做加法
     * ^ 亦或 ----相当于 无进位的求和， 想象10进制下的模拟情况：（如:19+1=20；无进位求和就是10，而非20；因为它不管进位情况）
     * <p>
     * & 与 ----相当于 求每位的进位数， 先看定义：1&1=1；1&0=0；0&0=0；即都为1的时候才为1，正好可以模拟进位数的情况,还是想象10进制下模拟情况：（9+1=10，如果是用&的思路来处理，则9+1得到的进位数为1，而不是10，所以要用<<1向左再移动一位，这样就变为10了）；
     * <p>
     * 这样公式就是：（a^b) ^ ((a&b)<<1) 即：每次无进位求 + 每次得到的进位数--------我们需要不断重复这个过程，直到进位数为0为止；
     * <p>
     * T(n) = O(N)
     * S(n) = O(1)
     */
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }

        return add(a ^ b, (a & b) << 1);
    }

    /**
     * 剑指 Offer 56 - I. 数组中数字出现的次数
     * 常规解法
     * T(n) = O(N)
     * S(n) = O(1)
     *
     * @since 2022-01-23 14:51:11
     */
    public int[] singleNumbers(int[] nums) {
        if (nums.length == 2) {
            return nums;
        }
        Arrays.sort(nums);
        int i = 1, count = 0;
        int[] ints = new int[2];
        if (nums[0] != nums[1]) {
            ints[count++] = nums[0];
        }
        while (count != 2) {
            if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                ints[count++] = nums[i];
            }
            i++;
            if (i == nums.length - 1) {
                break;
            }
        }
        if (i == nums.length - 1 && nums[i - 1] != nums[i]) {
            ints[1] = nums[i];
        }
        return ints;
    }

    /**
     * 剑指 Offer 56 - I. 数组中数字出现的次数
     * <p>
     * 异或解法
     * <p>
     * 交换律
     * 结合律（即(a^b)^c == a^(b^c)）
     * 对于任何数x，都有x^x=0，x^0=x
     * 自反性 A XOR B XOR B = A xor 0 = A ---> A XOR B = C 则 C XOR B = A
     * <p>
     * T(n) = O(N)
     * S(n) = O(1)
     *
     * @since 2022-01-23 15:22:44
     */
    public int[] singleNumbersI(int[] nums) {
        int x = 0;
        for (int temp : nums) {
            x ^= temp;
        }
        int flag = x & (-x);
        int ret = 0;
        for (int val : nums) {
            if ((flag & val) != 0) {
                ret ^= val;
            }
        }
        return new int[]{ret, ret ^ x};
    }

    /**
     * 剑指 Offer 56 - II. 数组中数字出现的次数 II
     * T(n) = O(N)
     * S(n) = O(1)
     */
    public int singleNumberII(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int a;
        for (int i = 0; i < nums.length; i++) {
            a = map.getOrDefault(nums[i], 0);
            map.put(nums[i], a++);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                return nums[i];
            }

        }
        return -1;
    }

    /**
     * 剑指 Offer 39. 数组中出现次数超过一半的数字
     * T(n) = O(N)
     * S(n) = O(1)
     *
     * @since 2022-01-24 16:59:21
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 剑指 Offer 66. 构建乘积数组
     * 数学 巧妙两次循环
     * <p>
     * T(n) = O(N)
     * S(n) = O(N)
     *
     * @since 2022-01-24 18:10:31
     */
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] ret = new int[n];
        for (int i = 0, temp = 1; i < n; temp *= a[i], i++) {
            ret[i] = temp;
        }
        for (int i = n - 1, temp = 1; i >= 0; temp *= a[i], i--) {
            ret[i] *= temp;
        }
        return ret;
    }

    /**
     * 剑指 Offer 14- I. 剪绳子
     * <p>
     * T(n) = O(N)
     * S(n) = O(1)
     *
     * @since 2022-01-25 08:53:26
     */
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 4;
        }
        int ret = 1, ncpy = n;
        for (int i = 1; i < n; i++) {
            if (ncpy > 4) {
                ret *= 3;
                ncpy -= 3;
            } else if (ncpy == 4) {
                ret *= 4;
                break;
            } else {
                ret *= ncpy;
                break;
            }
        }
        return ret;
    }

    /**
     * 剑指 Offer 57 - II. 和为s的连续正数序列
     * <p>
     * 利用数列求和公式
     * todo 注意 int[][] 返回的 list设置
     * <p>
     * T(n) = O(N)
     * S(n) = O(1)
     *
     * @since 2022-01-25 09:58:41
     */
    public int[][] findContinuousSequence(int target) {
        int n = (int) Math.floor(Math.sqrt(1 + 8 * target) / 2 - 0.5);
        List<int[]> list = new ArrayList<>();
        int[] temp;
        int dtarget, index;
        for (int i = n; i >= 2; i--) {
            dtarget = target / i;
            if (i % 2 == 0) {
                if ((dtarget * 2 + 1) * i / 2 == target) {
                    index = dtarget - i / 2 + 1;
                } else {
                    continue;
                }
            } else {
                if (dtarget * i == target) {
                    index = dtarget - i / 2;
                } else {
                    continue;
                }
            }
            temp = new int[i];
            for (int k = 0; k < i; k++) {
                temp[k] = index + k;
            }
            list.add(temp);
        }
        return list.toArray(new int[list.size()][]);
    }

    /**
     * 剑指 Offer 62. 圆圈中最后剩下的数字
     * https://blog.csdn.net/u011500062/article/details/72855826
     * 约瑟夫环问题
     * f(n,m) = (f(n-1,m) + m) % n
     * <p>
     * T(n) = O(N)
     * S(n) = O(1)
     *
     * @since 2022-01-26 12:46:58
     */
    public int lastRemaining(int n, int m) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            count = (count + m) % i;
        }

        return count;
    }

    /**
     * 剑指 Offer 29. 顺时针打印矩阵
     * <p>
     * T(n) = O(N)
     * S(n) = O(N)
     * todo 注意 设置row , column length & row == 1 时 返回 设置
     *
     * @since 2022-01-26 14:01:32
     */
    public int[] spiralOrder(int[][] matrix) {
        int rowlen = matrix.length;
        if (rowlen == 0) {
            return new int[0];
        }
        int columnlen = matrix[0].length, index = 0;
        int[] res = new int[rowlen * columnlen];
        int left = 0, top = 0, right = columnlen - 1, bottom = rowlen - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            bottom--;
            if (bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return res;
    }

    /**
     * 剑指 Offer 31. 栈的压入、弹出序列
     * <p>
     * T(n) = O(N)
     * S(n) = O(N)
     *
     * @since 2022-01-26 14:57:12
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        int j = 0;
        for (int temp : pushed) {
            deque.push(temp);
            while (j < popped.length && !deque.isEmpty() && deque.peek() == popped[j]) {
                j++;
                deque.pop();
            }
        }
        return j == popped.length;
    }

    /**
     * 剑指 Offer 20. 表示数值的字符串
     *
     * @since
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //去掉首位空格
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判定为数字，则标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
                //判定为.  需要没出现过.并且没出现过e
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                //判定为e，需要没出现过e，并且出过数字了
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                //其他情况，都是非法的
            } else {
                return false;
            }
        }
        return numFlag;
    }

    /**
     * 剑指 Offer 67. 把字符串转换成整数
     * <p>
     * T(n) = O(N)
     * S(n) = O(N)
     *
     * @since 2022-01-28 08:22:15
     */
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        boolean isMinus = false;
        char[] ch = str.toCharArray();
        if (ch[0] == '+' || ch[0] == '-' || Character.isDigit(ch[0])) {
            if (ch[0] == '+' || ch[0] == '-') {
                if (ch[0] == '-') {
                    isMinus = true;
                }
                ch = Arrays.copyOfRange(ch, 1, ch.length);
            }
            int index = 0;
            //结果可能超int范围，拿个long接一下
            //'-abc'这种情况返回的也是0，舒服，一箭双雕
            long res = 0;
            //短路与助您远离空指针喔，铁汁们，先后顺序关注一下
            while (index < ch.length && Character.isDigit(ch[index])) {
                //一位一位往上算
                res *= 10;
                res += ch[index] - '0';
                //及时止损，一看到res超int范围立马return
                //你要是想着最后一起算，那肯定会有超long范围的测试用例等着你，你就哭去吧
                if (res > Integer.MAX_VALUE) {
                    //正负号看是正数负数，返回最大值
                    return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                //别忘了往后走一位
                index++;
            }
            //long转int就是这么朴实无华
            return isMinus ? -(int) res : (int) res;
        }
        return 0;
    }

    /**
     * 剑指 Offer 59 - I. 滑动窗口的最大值
     * <p>
     * T(n) = O(N)
     * S(n) = O(N)
     *
     * @since 2022-01-28 09:41:22
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < k; i++) {
            priorityQueue1.add(nums[i]);
        }
        int len = nums.length;
        int[] ret = new int[len - k + 1];
        ret[0] = priorityQueue1.peek();
        for (int i = 0, j = i + k; j < len; i++, j++) {
            priorityQueue1.add(nums[j]);
            priorityQueue2.add(nums[i]);
            while (priorityQueue1.peek().equals(priorityQueue2.peek())) {
                priorityQueue1.poll();
                priorityQueue2.poll();
            }
            ret[i + 1] = priorityQueue1.peek();
        }
        return ret;
    }

    /**
     * 剑指 Offer 49. 丑数
     * <p>
     * T(n) = O(N)
     * S(n) = O(N)
     *
     * @since 2022-01-30 22:44:00
     */
    public int nthUglyNumber(int n) {
        if (n <= 0)
            return -1;
        int[] dp = new int[n];
        dp[0] = 1;
        int id2 = 0, id3 = 0, id5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[id2] * 2, Math.min(dp[id3] * 3, dp[id5] * 5));
            // 这里不用else if的原因是有可能id2(3) * 2 == id3(2) * 3
            // 这种情况两个指针都要后移
            if (dp[id2] * 2 == dp[i])
                id2 += 1;
            if (dp[id3] * 3 == dp[i])
                id3 += 1;
            if (dp[id5] * 5 == dp[i])
                id5 += 1;
        }
        return dp[n - 1];
    }

    /**
     * 剑指 Offer 17. 打印从1到最大的n位数
     * T(n) = O(N)
     * S(n) = O(N)
     *
     * @since 2022-01-31 08:30:19
     */
    public int[] printNumbers(int n) {
        StringBuilder stringBuilder = new StringBuilder("1");
        for (int i = 0; i < n; i++) {
            stringBuilder.append("0");
        }
        int[] ret = new int[Integer.parseInt(stringBuilder.toString()) - 1];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = i + 1;
        }

        return ret;
    }

    /**
     * 剑指 Offer 38. 字符串的排列
     * <p>
     * T(n) = O(N*N)
     * S(n) = O(N!)
     *
     * @since 2022-02-01 23:22:49
     */
    public String[] permutation(String s) {
        Set<String> strings = new HashSet<>();
        char[] arr = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] visited = new boolean[arr.length];
        reverseDFS(arr, "", visited, strings);
        return strings.toArray(new String[0]);
    }

    public void reverseDFS(char[] chars, String str, boolean[] visited, Set<String> list) {
        if (str.length() == chars.length) {
            list.add(str);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            reverseDFS(chars, str + String.valueOf(chars[i]), visited, list);
            visited[i] = false;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    class TreeNodeBalance {
        TreeNode node;
        int balance = -1;

        TreeNodeBalance() {
        }

        TreeNodeBalance(TreeNode node) {
            this.node = node;
            this.balance = -1;
        }

        TreeNodeBalance(TreeNode node, int balance) {
            this.node = node;
            this.balance = balance;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
