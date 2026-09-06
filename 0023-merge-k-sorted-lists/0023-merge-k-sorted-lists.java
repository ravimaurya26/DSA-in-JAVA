class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

     
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {

      
            ListNode node = pq.poll(); // take smallest

            temp.next = node;
            temp = temp.next;

            if (node.next != null) {  // idhar smallest node gya uske aage  
                pq.add(node.next);     //ka node add kra h
            }
        }

        return dummy.next;
    }
}