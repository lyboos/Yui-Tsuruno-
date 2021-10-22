public class Solution {
    public static void main(String[] args) {

    }

    class LinkedlistDemo{
        private HeroNode head=new HeroNode(0,"");

        public HeroNode gethead(){
            return head;
        }

        //添加数据
        public void add_next(HeroNode new_heronode) {
            //head无法移动，需要辅助节点
            HeroNode temp=head;
            //添加数据从链表最后添加，想确认位置就需要在节点.next遍历下去，直到null
            while (true){
                if(temp.next==null)
                    break;
                temp=temp.next;
            }
            temp.next=new_heronode;
        }
        //显示链表
        public void show_linkedlist(HeroNode head){
            if(head.next==null) { System.out.println("linked list is empty!"); }
            else {
                HeroNode temp=head.next;
                while (true){
                    if(temp.next==null)
                        break;
                    System.out.println(temp.toString());
                    temp=temp.next;
                }
            }
        }

        //修改链表内容 根据链表中id修改
        public void modify_linkedlist(HeroNode heroNode){
            if(head.next==null) { System.out.println("linked list is empty!"); }
            else {
                HeroNode temp = head.next;
                boolean checkflag=false;
                while (true) {
                    if (temp.next == null)
                        break;
                    else if (temp.id == heroNode.id) {
                        checkflag = true;
                        break;
                    }
                    temp = temp.next;
                }
                if(checkflag){
                    temp.name=heroNode.name;
                }
                else {
                    System.out.println("fail to modify the linkedlist with id:"+heroNode.id);
                }
            }
        }

        //删除链表内容
        public void delete_linkedlist(int id){
            HeroNode temp=head;
            boolean checkflag=false;
            while (true){if (temp.next == null)
                break;
            else if (temp.id == id) {
                checkflag = true;
                break;
            }
                temp = temp.next;
            }
            if(checkflag){
                //  前一个-->现在指向的-->后一个  这个操作让前一个的next直接指向后一个
                temp.next=temp.next.next;
            }
            else {
                System.out.println("fail to delete the linkedlist with id:"+id);
            }
        }
    }



    class HeroNode{
        private int id;
        private String name;
        public HeroNode next;

        public HeroNode(int id,String name) {
            super();
            this.id=id;
            this.name=name;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
