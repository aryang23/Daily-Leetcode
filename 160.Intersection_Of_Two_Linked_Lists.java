/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int s1 = getSize(headA);
        int s2 = getSize(headB);
        
        int diff = Math.max(s1,s2)-Math.min(s1,s2);
        if(s1>s2)
        {
            while(diff-->0)
            {
                headA = headA.next;
            }
        }
        else
        {
            while(diff-->0)
            {
                headB = headB.next;
            }
        }
        while(headA!=null)
        {
            if(headA==headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
        
    }
    public int getSize(ListNode head)
    {
        int size = 0;
        while(head!=null)
        {
            size++;
            head = head.next;
        }
        return size;
    }
}








//M-2
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int s1 = getSize(headA);
        int s2 = getSize(headB);
        
        int diff = Math.max(s1,s2)-Math.min(s1,s2);
        if(s1>s2)
        {
            while(diff-->0)
            {
                headA = headA.next;
            }
        }
        else
        {
            while(diff-->0)
            {
                headB = headB.next;
            }
        }
        while(headA!=null)
        {
            if(headA==headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
        
    }
    public int getSize(ListNode head)
    {
        int size = 0;
        while(head!=null)
        {
            size++;
            head = head.next;
        }
        return size;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA==null || headB==null)
            return null;
        
        ListNode tail = headA;
        while(tail.next!=null)
        {
            tail = tail.next;
        }
        
        tail.next = headB;
        ListNode ans = detectCycle(headA);
        
        tail.next = null;
        
        return ans;
    }
    
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode cycleNode = null;
        while(fast!=null && fast.next!=null)
        {
            
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
            {
                cycleNode = slow;
                break;
            }
        }
        if(cycleNode==null)
            return null;
        slow = head;
        //CycleNode is at intersection now, so ab wo (m-1) cycles ke baad whi starting point pe aajauega
        //same for A also as eqn is A = C + (B+C)(m-1), so ab (m-1) cycles + C dist travel krke whi starting point pe aajayega wo
        while(slow!=cycleNode)
        {
            slow = slow.next;
            cycleNode = cycleNode.next;
        }
        return cycleNode;
    }
}
