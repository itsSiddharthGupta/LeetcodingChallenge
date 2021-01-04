package leetcode_challenge_jan.week1;

public class Merge2SortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode ans = new ListNode(0);
		ListNode sol = ans;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				ans.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				ans.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			ans = ans.next;
		}
		if (l1 != null) {
			ans.next = l1;
		}
		if (l2 != null) {
			ans.next = l2;
		}
		return sol.next;
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
