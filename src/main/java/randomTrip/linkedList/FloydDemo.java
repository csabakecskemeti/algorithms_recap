package randomTrip.linkedList;

/**
 * Created by kecso on 1/9/18.
 */

class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
        this.value = value;
    }
}
public class FloydDemo {
    public static void main(String[] args) {
        System.out.println("Floyd algo demo");
        // create straight linked list
        ListNode head = new ListNode(33);
        ListNode node2 = new ListNode(34);
        head.next = node2;
        ListNode node3 = new ListNode(35);
        node2.next = node3;

        // create circular linked list
        ListNode chead = new ListNode(33);
        ListNode cnode2 = new ListNode(34);
        chead.next = cnode2;
        ListNode cnode3 = new ListNode(35);
        cnode2.next = cnode3;
        ListNode cnode4 = new ListNode(36);
        cnode3.next = cnode4;
        cnode4.next = cnode2;

        printLinkedList(head);

        System.out.println(isCircularLinkedlist(head));
        System.out.println(isCircularLinkedlist(chead));

        System.out.println(findLoopStart(chead));
    }

    public static Integer findLoopStart(ListNode head) {
        // Floyd's algo
        ListNode hare = head;
        ListNode tortois = head;
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            tortois = tortois.next;
            if (hare == tortois) {
                hare = head;
                while(hare != tortois) {
                    hare = hare.next;
                    tortois = tortois.next;
                }
                return hare.value;
            }
        }

        return null;
    }

    public static boolean isCircularLinkedlist(ListNode head) {
        // Floyd's algo
        ListNode hare = head;
        ListNode tortois = head;
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            tortois = tortois.next;
            if (hare == tortois) {
                return true;
            }
        }
        return false;
    }


    public static void printLinkedList(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        while (head.next != null) {
            head = head.next;
            System.out.println(head.value);
        }
    }
}
