package model;

public class LinkList<T> {

	private int size = 0;

	private ListNode<T> head = new ListNode<T>();

	public LinkList(int[] array) {
		ListNode cur = head;
		for (int s : array) {
			ListNode node = new ListNode(s);
			cur.next = node;
			cur = node;
			size++;
		}
	}

	public int getSize() {
		return size;
	}

	public ListNode<T> getHead() {
		return head;
	}

	public void add(ListNode node) {
		head.next = node;
		size++;
	}

}
