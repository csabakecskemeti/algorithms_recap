package randomTrip.linkedList;

/**
 * Created by kecso on 10/2/17.
 */
public class ListDemo {
    public static void main(String[] args) {
        System.out.println("Linked list demo");
        LinkedList linkedList = new LinkedList();
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.printLinkedList();
        System.out.println();
        linkedList.reverse();
        linkedList.printLinkedList();
    }
}

class LinkedList {
    public Node head;

    public Node add(Integer value) {
        if (value != null) {
            Node previousHead = head;
            head = new Node(value);
            head.next = previousHead;
        }
        return head;
    }

    public void printLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void reverse() {
        if (head != null && head.next != null) {
            reverse(head);
        }
    }

    public void reverse(Node current) {
        if (current.next.next != null) {
            reverse(current.next);
            current.next.next = current;
            current.next = null;
        } else {
            head = current.next;
            current.next.next = current;
            current.next = null;
        }
    }
}

class Node {
    public Integer value;
    public Node next;

    public Node(Integer value) {
        this.value = value;
    }
}