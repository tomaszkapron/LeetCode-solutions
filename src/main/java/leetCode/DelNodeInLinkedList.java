package leetCode;

public class DelNodeInLinkedList {

    public static void main(String[] args) {
        var List1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        List1.printList();

        System.out.println("Deleting second node: ");
        deleteNode(List1.next);
        List1.printList();

    }


    static public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
