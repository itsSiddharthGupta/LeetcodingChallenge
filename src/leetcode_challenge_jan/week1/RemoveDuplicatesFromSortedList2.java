package leetcode_challenge_jan.week1;

public class RemoveDuplicatesFromSortedList2 {
	public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode sol = temp;
        while(head!=null){
            if(head.next!=null && head.val==head.next.val){
                while(head.next!=null && head.val==head.next.val)
                    head = head.next;
            }
            else{
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }
            head = head.next;
        }
        return sol.next;
    }
}
