package normal;

import java.util.HashMap;
import java.util.Map;
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
