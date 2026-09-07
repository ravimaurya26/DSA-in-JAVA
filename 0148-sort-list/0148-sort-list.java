/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode merge2(ListNode t1 , ListNode t2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(t1!=null && t2!=null){
            if(t1.val<t2.val){
            temp.next = t1;
            temp = t1;
            t1=t1.next;
            }
            else{
            temp.next = t2;
            temp = t2;
            t2=t2.next;
            }
        }
        if(t1!=null)
        temp.next=t1;
        else 
        temp.next=t2;

        return dummy.next;

    }
    private ListNode findmiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
      ListNode middle = findmiddle(head);
      ListNode lefthead = head;
      ListNode righthead = middle.next;
      middle.next=null;

      lefthead = sortList(lefthead);
      righthead = sortList(righthead);

      return merge2(lefthead,righthead);

    }

}