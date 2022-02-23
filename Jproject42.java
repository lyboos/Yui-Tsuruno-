import java.util.*;

public class reverseNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);

        head = reverse(head);

        while (head != null){
            System.out.println(head.value+" ");
            head = head.next;
        }
    }

    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value=data;
        }
    }

        public static Node reverse(Node head) {
            //在这里实现
            if(head.next==null)return head;
            Node newHead=reverse(head.next);
            Node next=head.next;
            next.next=head;
            head.next=null;
            return newHead;
        }
}
