
// TODO: Auto-generated Javadoc
/**
 * The Class linkList.
 */
public class linkList {

	/** The head. */
	private static Node head;

	/** The tail. */
	private static Node tail;

	/** The size. */
	private static int size;

	/**
	 * Display.
	 */
	public static void display() {
		Node travel = head;
		while (travel != null) {
			System.out.println(travel.n);
			travel = travel.next;
		}
	}

	/**
	 * Adds the node.
	 *
	 * @param n the number in the node
	 */
	public static void addNode(int n) {
		Node temp = new Node(n);
		// If list is empty
		if (head == null && tail == null) {
			head = temp;
			tail = temp;
		}
		// add Node to front
		else if (temp.n <= head.n) {
			temp.next = head;
			head = temp;
		}
		// add Node to back
		else if (temp.n >= tail.n) {
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

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public static int getSize() {
		Node temp = head; 
        size = 0; 
        while (temp != null) 
        { 
            size++; 
            temp = temp.next; 
        } 
        return size; 
	}

	/**
	 * Gets the head.
	 *
	 * @return the head
	 */
	public static Node getHead() {
		return head;
	}
}
