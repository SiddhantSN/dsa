package basics.linkedlist;

import java.util.LinkedList;

public class LinkedList1 {

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}
		return prev;
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				tail.next = list1;
				list1 = list1.next;
			} else {
				tail.next = list2;
				list2 = list2.next;
			}
			tail = tail.next;
		}

		if (list1 != null) {
			tail.next = list1;
		} else {
			tail.next = list2;
		}

		return dummy.next;
	}
}
