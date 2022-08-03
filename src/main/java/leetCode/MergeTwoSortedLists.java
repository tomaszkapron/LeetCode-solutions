package leetCode;

class MergeTwoSortedLists {

    public static void main(String[] args) {
        var List1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        var List2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println("List1 :");
        List1.printList();
        System.out.println();

        System.out.println("List2 :");
        List2.printList();
        System.out.println();

        var List3 = mergeTwoLists(List1, List2);

        System.out.println("List3 :");
        List3.printList();
        System.out.println();

    }

    static public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));

        } else {
            return new ListNode(list2.val, mergeTwoLists(list2.next, list1));
        }
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void printList() {
        System.out.println(val + " ");
        if (next != null) {
            next.printList();
        }
    }

}
