package normal;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringJoiner;

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
     * T(n) = O(logN)
     * S(n) = O(1)
     */
    public char firstUniqChar(String s) {
        char c = ' ';


        return c;
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