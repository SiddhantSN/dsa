package basics.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode cur = dummy;

		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int v1 = (l1 != null) ? l1.val : 0;
			int v2 = (l2 != null) ? l2.val : 0;

			int val = v1 + v2 + carry;
			carry = val / 10;
			val = val % 10;
			cur.next = new ListNode(val);

			cur = cur.next;
			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;
		}

		return dummy.next;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		ListNode left = dummy;
		ListNode right = head;

		while (n > 0) {
			right = right.next;
			n--;
		}

		while (right != null) {
			left = left.next;
			right = right.next;
		}

		left.next = left.next.next;
		return dummy.next;
	}
	
    public void reorderList(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head.next;
    	
    	while(fast!=null && fast.next !=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	// reverse the second list
    	ListNode secondListHead = slow.next;
    	// update the slow.next to null to end the first list 
    	slow.next = null;
    	ListNode prev = null;
    	ListNode tempNextForSecondList = secondListHead.next;
    	secondListHead.next = prev;
    	prev = secondListHead;
    	secondListHead = tempNextForSecondList;
    	
    	//merge two lists
    	//head of second list after reversal
    	ListNode second = prev;
    	ListNode first = head;
    	
    	while(second.next !=null) {
    		ListNode tmp1 = first.next;
    		ListNode tmp2 = second.next;
    		first.next = second;
    		second.next = tmp1;
    		first = tmp1;
    		second = tmp2;
    	}
    }
    
    public int findDuplicate(int[] nums) {
    	HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
			if(!set.add(i)) {
				return i;
			}
		}
		return -1;
    }
    
 public boolean hasCycle2(ListNode head) {
     boolean hasCycle = false;   
	 
     ListNode slow = head;
     ListNode fast = head;
     
     while(fast != null && fast.next != null) {
    	 slow = slow.next;
    	 fast = fast.next;
    	 if(slow==fast) {
    		 return true;
    	 }
     }
	return hasCycle;
    }
}
