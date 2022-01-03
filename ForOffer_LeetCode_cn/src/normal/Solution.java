package normal;

import java.util.Stack;

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

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

}
