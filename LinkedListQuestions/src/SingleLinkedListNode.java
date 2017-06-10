
public class SingleLinkedListNode {
	private SingleLinkedListNode next;
	private int size;
	private String data;
	
	public SingleLinkedListNode(String s){
		this.next = null;
		this.size = 1;
		this.data = s;
	}
	
	public SingleLinkedListNode getNext(){
		return this.next;
	}
	public String getData(){
		return this.data;
	}
	public int getSize(){
		return this.size;
	}
	public void setNext(SingleLinkedListNode n){
		this.next = n;
	}
	public boolean append(SingleLinkedListNode n){
		if(this.next!=null){
			return false;
		}else{
			this.next = n;
			return true;
		}
	}
	public boolean append(String s){
		if(this.next!=null){
			return false;
		}else{
			SingleLinkedListNode slln = new SingleLinkedListNode(s);
			this.size+=1;
			this.next = slln;
			return true;
		}
	}
	public void printNodeValues(){
		SingleLinkedListNode slln = this;
		while(slln!=null){
			System.out.println(slln.getData());
			slln = slln.getNext();
		}
	}
}
