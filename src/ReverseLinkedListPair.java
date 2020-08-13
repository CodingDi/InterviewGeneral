
public class ReverseLinkedListPair {

	public ReverseLinkedListPair() {
		// TODO Auto-generated constructor stub
	}
	public  ListNode reverseInPairs(ListNode head) {
		/*
		 * idea:recursive way(method 1)
		 * 
		 */
		if(head==null||head.next==null) {
			return head;
		}
		ListNode newHead=head.next;
		head.next=reverseInPairs(head.next.next);
		newHead.next=head;
		return newHead;
	}
	
	static class ListNode {
		 public int value;
		 public ListNode next;
		 public ListNode(int value) {
		 this.value = value;
		 	next = null;
		 	}
		 }

}
