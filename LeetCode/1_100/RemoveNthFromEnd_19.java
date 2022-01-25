
public class RemoveNthFromEnd_19 {

	/**
	 * ���� һ��
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode temp1 = head,temp2 = head;
		for(int i =0;i<n;i++) {
			temp2 = temp2.next;
		}
		while(temp2.next!=null) {
			temp1 =temp1.next;
			temp2 =temp2.next;
		}
		temp1.next = temp1.next.next;
		return temp1;
	}

	/**
	 * ���������� T(n) = O(n)
	 * 
	 * @param head
	 *            ͷָ��
	 * @param n
	 *            ɾ��
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode temp = head;
		int index = count(head) - n;
		// �ƶ�ͷָ��
		if (index == 0) {
			head = head.next;
			return head;
		}

		// ���ƶ�ͷָ��
		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}

		temp.next = temp.next.next;

		return head;
	}

	// ����
	public static int count(ListNode head) {
		int count = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}