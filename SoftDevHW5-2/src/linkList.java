
public class linkList {
	private static Node head;
	private static Node tail;
	private static int size = 0;

	public static void display() {
		Node travel = head;
		while (travel != null) {
			System.out.println(travel.n);
			travel = travel.next;
		}
	}

	public static void addNode(int n) {
		Node temp = new Node(n);
		// If list is empty
		if (head == null && tail == null) {
			size++;
			head = temp;
			tail = temp;
		}
		// add Node to front
		else if (temp.n <= head.n) {
			size++;
			temp.next = head;
			head = temp;
		}
		// add Node to back
		else if (temp.n >= tail.n) {
			size++;
			tail.next = temp;
			tail = temp;
		}
		// USE BEFORE AND AFTER REFERENCES
		// find the correct spot to place Node
		else {
			Node before = head;
			Node after = head.next;
			while (after != null) {
				if (before.n <= temp.n && after.n >= temp.n) {
					break;
				}
				before = after;
				after = after.next;
			}
			// attach the node in the spot
			before.next = temp;
			temp.next = after;
		}
	}

	public static int getSize() {
		return size;
	}

	public static Node getHead() {
		return head;
	}
}
