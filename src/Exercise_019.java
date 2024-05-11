public class Exercise_019 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = new Exercise_019().removeNthFromEnd(head, 2);
        System.out.println();

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode origin = head;
        while (head != null){
            len ++;
            head = head.next;
        }
        if (len == 1 && n == 1){
            return null;
        }
        if (len == n){
            return origin.next;
        }
        ListNode beforeDel = origin;
        for (int i = 0; i < len - n - 1; i++){
            beforeDel = beforeDel.next;
        }
        if (beforeDel.next != null){
            beforeDel.next = beforeDel.next.next;
        }else {
            beforeDel.next = null;
        }
        return origin;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

