
public class ReverseLinkedList {
	public static void main(String args[]){
		SingleLinkedListNode slln = new SingleLinkedListNode("Should be tail");
		addRandomItemsToList(slln, 10);
		System.out.println("Before:");
		slln.printNodeValues();
		System.out.println("After:");
		SingleLinkedListNode reversedList = reverseLinkedList(slln);
		reversedList.printNodeValues();
		
	}
	public static SingleLinkedListNode reverseLinkedList(SingleLinkedListNode head){
		//null<-1<-2<-3 4->null
		//make 2 point to 1, reference 3
		//1<-2 3->4->null
		//1<-2<-3 4->null
		if(head.getNext()==null){
			return head;
		}
		//reference to head node in order to check for a repeating LL
		SingleLinkedListNode repeatChecker = head;
		
		//retrieve next two nodes in the order
		SingleLinkedListNode nextNode = head.getNext();
		SingleLinkedListNode temp = nextNode.getNext();
		//Set heads next node to be null
		head.setNext(null);
		
		while(temp!=null){
			nextNode.setNext(head);
			head = nextNode;
			nextNode = temp;
			temp = temp.getNext();
		}
		nextNode.setNext(head);
		head = nextNode;
		
		return head;
	}
	
	public static void addRandomItemsToList(SingleLinkedListNode l, int numItems){
		for(int i=0;i<numItems;i++){
			l.append(generateRandomStringCapitalLetters(10));
			l = l.getNext();
		}
	}
	public static String generateRandomStringCapitalLetters(int lengthOfString){
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<lengthOfString;i++){
			int currentChar = (int)(Math.ceil(25*Math.random() + 65));
			sb.append((char)currentChar);
		}
		return sb.toString();
	}
}
