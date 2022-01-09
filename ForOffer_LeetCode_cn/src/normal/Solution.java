package normal;

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
     * 剑指 Offer 10- II. 青蛙跳台阶问 题
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

}
