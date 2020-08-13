public class Queue {
	ListNode head;
	ListNode tail;
	public Queue() {
		head=tail=null;
	}
	public Integer poll(){
		if(head==null) {
			return null;
		}
		ListNode res=head;
		head=head.next;
		//if its a null listnode,remember to make the tail points to null as well!!
		if(head==null) {
			tail=null;
		}
		res.next=null;//whenever you take out a ListNode from a LinkedList,remember to make it links tp null
		return res.value;
	}
	public void offer(int ele) {
		ListNode node=new ListNode(ele);
		if(head==null) {
			tail=node;
			head=tail;
		}else {
			tail.next=node;
			tail=tail.next;
		}
	}
	public Integer peek() {
		if(head==null) {
			return null;
		}
		return head.value;
	}
	
	public static void main(String[] args) {
		Queue q=new Queue();
		q.offer(1);
		q.offer(2);
		
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
		q.offer(4);
		System.out.println(q.peek());
		q.offer(5);
		q.offer(6);
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		
	}
	

}
