
public class BoundedQueue {
	public int head,tail;
	public Integer[] nums;
	int size;
	public BoundedQueue(int cap) {
		nums=new Integer[cap];
		size=0;
		head=0;
		tail=0;
	}
	//offer to the tail and poll from the head
	public Integer poll() {
		if(size==0) {
			return null;
		}
		int res=nums[head];
		head=head+1==nums.length?0:head+1;
		size--;
		return res;
	}
	public boolean offer(int ele) {
		if(size==nums.length) {
			return false;
		}
		nums[tail]=ele;
		tail=tail+1==nums.length?0:tail+1;
		size++;
		return true;
		
	}
	public Integer peek() {
		if(size==0) {
			return null;
		}
		return nums[head];
	}
	public boolean isEmpty() {
		return size==0;
	}
	public boolean isFull() {
		return size==nums.length;
	}
	
	public static void main(String[] args) {
		BoundedQueue bq=new BoundedQueue(5);
		bq.offer(1);
		bq.offer(2);
		bq.offer(3);
		System.out.println(bq.peek());
		bq.offer(4);
		bq.offer(5);
		System.out.println(bq.offer(6));
		System.out.println(bq.peek());
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		bq.offer(8);
		System.out.println(bq.isEmpty());
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		System.out.println(bq.poll());
	}
	

}
