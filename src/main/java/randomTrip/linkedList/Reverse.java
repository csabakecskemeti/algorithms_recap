package randomTrip.linkedList;

/**
 * Created by kecso on 1/9/18.
 */

class LN {
    int value;
    LN next;
    public LN(int value) {
        this.value = value;
    }
}

class LL {
    public LN head;
    public LN tail;
    public LL(int value) {
        this.head = new LN(value);
        this.tail = head;
    }

    public void addNode(int value) {
        LN tmp = new LN(value);
        tail.next = tmp;
        tail = tmp;
    }

    public void printList() {
        LN tmp = head;
        while(tmp != null) {
            System.out.print(tmp.value + " -> ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void reverseList(LN node) {
        if (node.next == null) {
            this.head = node;
            return;
        }
        reverseList(node.next);
        node.next.next = node;
        node.next = null;
        tail = node;
    }

    public void reverseListIter() {
        LN prevNode = null;
        LN current = this.head;
        LN nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        LN tmp = tail;
        tail = head;
        head = tmp;
    }
}

public class Reverse {
    public static void main(String[] args) {
        System.out.println("Reverse linked list");
        LL myList = new LL(1);
        for (int i = 2; i < 10; i++) {
//            System.out.println(i);
            myList.addNode(i);
        }
        myList.printList();

        myList.reverseList(myList.head);
        myList.printList();

        myList.reverseListIter();
        myList.printList();
    }



}
