/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        Node current = head;
        Map<Node, Node> map = new HashMap<>();
        Node prev = null;
        while(current != null){
            Node newNode = new Node(current.val);
            map.put(current, newNode);
            if(prev != null){
                map.get(prev).next = newNode;
            }
            prev = current;
            current = current.next;
        }
        current = head;
        while(current != null){
            if(current.random != null)
                map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
}
