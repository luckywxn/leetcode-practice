public class Exercise_021 {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);


        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result = new Exercise_021().mergeTwoLists(list1, list2);
        System.out.println();
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }else if(list1 == null){
            return list2;
        }if(list2 == null){
            return list1;
        }
        ListNode result = null;
        if (list1.val <= list2.val){
            result = list1;
            list1 = list1.next;
        }else if (list1.val > list2.val){
            result = list2;
            list2 = list2.next;
        }

        ListNode cur = result.next;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                cur = list1;
                list1 = list1.next;
                cur = cur.next;
            }else if (list1.val > list2.val){
                cur = list2;
                list2 = list2.next;
                cur = cur.next;
            }
            result.next = cur;
        }
        return result;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0); // 使用哑节点简化代码，避免空指针问题
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        // 任一链表若还有剩余，则直接连接到结果链表的末尾
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;
        return dummy.next;
    }
}
