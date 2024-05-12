public class Exercise_024 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);

        ListNode res = new Exercise_024().swapPairs(list1);
        System.out.println();
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0); // 使用哑节点简化代码，避免空指针问题
        ListNode current = dummy;
        while (head.next != null){
            ListNode temp = head.next;
            if (temp.next != null){
                current.next = temp;
                head.next = temp.next;
                temp.next = head;
                head = head.next;
            }else {
                current.next = temp;
                head.next = null;
                temp.next = head;
            }
            current = current.next.next;
        }
        return dummy.next;
    }
}
