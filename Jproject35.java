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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          if(l1==null) return l2;
          if(l2==null) return l1;
          ListNode k1=l1;
          if(k1==null) return l2;
          ListNode k2=l2;
          if(k2==null) return l1;
          ListNode result=new ListNode();
          ListNode tem_pointer=new ListNode();
          result.next=tem_pointer;
          ArrayList<Integer> nummap=new ArrayList<Integer>();
          while (k1.next!=null){
              nummap.add(k1.val);
              k1=k1.next;
          }
          nummap.add(k1.val);
          while (k2.next!=null){
              nummap.add(k2.val);
              k2=k2.next;
          }
          nummap.add(k2.val);
          nummap.sort(new Comparator<Integer>() {
              @Override
              public int compare(Integer o1, Integer o2) {
                  return o1>=o2?1:-1;
              }
          });
          while (nummap.size()>1){
              tem_pointer.val=nummap.get(0);
              nummap.remove(0);
              tem_pointer.next=new ListNode();
              tem_pointer=tem_pointer.next;
          }
          tem_pointer.val=nummap.get(0);
          return result.next;
    }
}
