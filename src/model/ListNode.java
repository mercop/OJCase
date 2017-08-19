package model;


public class ListNode<T> {

  public T val;
  public ListNode<T> next;

  public ListNode(){}

  public ListNode(T data) {
    this.val = data;
  }

  public T getData() {
    return val;
  }

  public void setData(T data) {
    this.val = data;
  }
  

  public ListNode<T> getNext() {
    return next;
  }

  public void setNext(ListNode<T> next) {
    this.next = next;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ListNode)) return false;

    @SuppressWarnings("unchecked")
	ListNode<T> listNode = (ListNode<T>) o;

    if (!val.equals(listNode.val)) return false;

    return true;
  }

  @Override public int hashCode() {
    return val.hashCode();
  }

  @Override public String toString() {
    //return "ListNode{" + "data=" + data + ", next=" + next + '}';
/*	  if(next ==null){
		  return val.toString();
	  }*/
	  return val +" -> " +next;
  }
}