/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        
        while(!(l1 == null && l2 == null)){
            
            if(l1 == null)
                stack1.push(0);
            else{
                stack1.push(l1.val);
                l1 = l1.next;
            }
            
            if(l2 == null)
                stack2.push(0);
            else{
                stack2.push(l2.val);
                l2 = l2.next;
            }    
        }
        
        int carry = 0;
        ListNode l =new ListNode(0);
        ListNode head = l;
        Queue<Integer> q = new LinkedList();
       // ListNode head = l;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            Integer a = stack1.pop();
            Integer b = stack2.pop();
            
            Integer sum = a + b + carry;
            
            Integer unit = sum %10;
            carry = sum/10;
            
           q.add(unit);
        }
        
        if(carry != 0)
            q.add(carry);
        
        while(!q.isEmpty()){
            l.next = new ListNode(q.poll());
            l = l.next;
        }
        
       // System.out.print(q);
        
        return head.next;
    }
}