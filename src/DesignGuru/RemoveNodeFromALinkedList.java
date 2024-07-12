package DesignGuru;


import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
public class RemoveNodeFromALinkedList {

    public static ListNode removeNodes(ListNode head) {

        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;

        while(cur != null) {
            while(!stack.isEmpty() && stack.peek().val < cur.val){
                stack.pop();
            }

            if(!stack.isEmpty()){
                stack.peek().next = cur;
            }

            stack.push(cur);
            cur = cur.next;
        }

        return stack.isEmpty() ? null : stack.get(0);
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(7);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(2);
        head1.next.next.next.next.next = new ListNode(1);

        removeNodes(head1);
    }
}
