
public class Stack {
	public static void main(String[] args) {
		Stack s1=new Stack();
		s1.push(1);
		s1.push(2);
		System.out.println(s1.peek());
		System.out.println(s1.pop());
		s1.push(3);
		s1.push(4);
		s1.push(5);
		System.out.println(s1.pop());
		System.out.println(s1.peek());
		
	}

	private ListNode head;
	public void push(int ele) {
		ListNode node=new ListNode(ele);
		node.next=head;
		head=node;
	
	}
	public Integer pop() {
		if(head==null) {
			return null;
		}
		ListNode res=head;
		head=head.next;
		res.next=null;
		return res.value;
		
	}
	public Integer peek() {
		if(head==null) {
			return null;
		}
		return head.value;
	}
}
