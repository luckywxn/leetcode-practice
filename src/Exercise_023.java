import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Exercise_023 {
    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);


        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);


        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode res = new Exercise_023().mergeKLists(new ListNode[]{list1, list2, list3});

        System.out.println();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0); // 使用哑节点简化代码，避免空指针问题
        ListNode current = dummy;
        while (true){
            ListNode currentMin = Arrays.stream(lists).filter(node -> node != null).min(Comparator.comparingInt(node -> node.val)).orElse(null);
            if (currentMin == null){
                break;
            }
            current.next = currentMin;
            CopyOnWriteArrayList<ListNode> nodeList = new CopyOnWriteArrayList<>(Arrays.asList(lists));
            nodeList.remove(currentMin);
            currentMin = currentMin.next;
            if (currentMin != null){
                nodeList.add(currentMin);
            }
            lists = nodeList.toArray(new ListNode[0]);
            current = current.next;
        }
        return dummy.next;
    }
}
