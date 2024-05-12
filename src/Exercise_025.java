public class Exercise_025 {
    public static void main(String[] args){


        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        ListNode res = new Exercise_025().reverseKGroup(list1,3);
        System.out.println();

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode origin = head;
        while (head != null){
            len ++;
            head = head.next;
        }
        if (len < k){
            return origin;
        }
        ListNode dummy = new ListNode(0); // 使用哑节点简化代码，避免空指针问题
        ListNode current = dummy;
        while (len >= k){
            ListNode pre = null;
            ListNode cur = origin;
            for (int i = 0; i < k; i++){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            current.next = pre;
            current = origin;
            origin = cur;
            len -= k;
        }
        current.next = origin;
        return dummy.next;
    }
}
