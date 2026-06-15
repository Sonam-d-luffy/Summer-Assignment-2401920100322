class ListNode {
      int val;
     ListNode next;
    ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class DAY2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode ans = dummy;
        while (ptr1 != null || ptr2 != null) {
            if (ptr1 != null && ptr2 != null) {
                if (ptr1.val > ptr2.val) {
                    dummy.next = ptr2;
                    ptr2 = ptr2.next;
                } else {
                    dummy.next = ptr1;
                    ptr1 = ptr1.next;
                }
            } else {
                dummy.next = ptr1 == null ? ptr2 : ptr1;
                ptr1 = ptr1 == null ? null : ptr1.next;
                ptr2 = ptr2 == null ? null : ptr2.next;
            }
            dummy = dummy.next;
        }
        return ans.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode ptr = head;
        for(int i=0;i<n;i++) ptr=ptr.next;
        if(ptr==null) return head.next;
        ListNode curr = head;
        while(ptr.next!=null){
            curr=curr.next;
            ptr = ptr.next;
        }
        if(curr.next!=null)curr.next = curr.next.next;
        return head;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        if(fast!=null) slow = slow.next;
        ListNode head1 = rev(slow);
        ListNode ptr1 = head;
        ListNode ptr2 = head1;
        while(ptr1!=null && ptr2!=null){
            if(ptr1.val != ptr2.val) return false;
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return true;
    }
    public ListNode rev(ListNode head){
        ListNode prev = null;
        ListNode ptr = head;
        while(ptr!=null){
            ListNode temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = temp;
        }
        return prev;
    }
}