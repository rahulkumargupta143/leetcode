/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    
    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }
    
    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                // Recursively flatten the child subtree
                flatten(curr.child);
                
                // Temporarily store the next pointer
                Node temp = curr.next;
                
                // Attach child to current
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                
                // Find the tail of the now-flattened child chain
                Node childTail = curr.next;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }
                
                // Attach the original next to the child tail
                childTail.next = temp;
                if (temp != null) {
                    temp.prev = childTail;
                }
                
                // Move curr to the child tail to continue traversal after the inserted chain
                curr = childTail;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
