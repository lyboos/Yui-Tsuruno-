  public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null) return null;
        ListNode fast = head, slow = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        if(fast==null){
            return head.next;
        }

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//    }

    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        func(res,"",0,0,n);
        return res;
    }

    void func(List<String> res,String str,int l,int r,int n){
        if(l>n||r>n||r>l) return;
        if(l==n&&r==n) {
            res.add(str);
            return;
        }
        func(res,str+'(',l+1,r,n);
        func(res,str+')',l,r+1,n);
        return;
    }


    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        head.next=swapPairs(next.next);
        next.next=head;
        return next;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode() {}
         *     TreeNode(int val) { this.val = val; }
         *     TreeNode(int val, TreeNode left, TreeNode right) {
         *         this.val = val;
         *         this.left = left;
         *         this.right = right;
         *     }
         * }
         */

        class ReturnNode{
            boolean isB;
            int depth;
            //构造方法
            public ReturnNode(boolean isB, int depth){
                this.isB = isB;
                this.depth = depth;
            }
        }

        public boolean isBalanced(TreeNode root) {

                return isB(root).isB;

        }

        private ReturnNode isB(TreeNode root){
            if(root==null){
                return new ReturnNode(true,0);
            }
            ReturnNode left=isB(root.left);
            ReturnNode right=isB(root.right);
            if(left.isB == false || right.isB == false){
                return new ReturnNode(false, 0);
            }
            if(Math.abs(left.depth - right.depth) > 1){
                return new ReturnNode(false, 0);
            }
            return new ReturnNode(true,Math.max(left.depth,right.depth)+1);
        }

    public TreeNode invertTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return root;
        }
        if(root.left!=null)
        invertTree(root.left);
        if(root.right!=null)
            invertTree(root.right);
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return compare(root.left,root.right);
    }

    private boolean compare(TreeNode node1,TreeNode node2){
            if(node1==null&&node2==null) return true;
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return compare(node1.left,node2.right)&&compare(node2.left,node1.right);
    }

    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        // null节点不参与比较
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }

    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 先合并根节点
        t1.val += t2.val;
        // 再递归合并左右子树
        t1.left = mergeTrees1(t1.left, t2.left);
        t1.right = mergeTrees1(t1.right, t2.right);
        return t1;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        // 先合并根节点
        TreeNode root = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        // 再递归合并左右子树
        root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return root;
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums,0,nums.length-1);
    }

    public TreeNode maxTree(int[] nums, int l, int r){
        if(l > r){
            return null;
        }
        //bond为当前数组中最大值的索引
        int bond = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[bond]);
        root.left = maxTree(nums, l, bond - 1);
        root.right = maxTree(nums, bond + 1, r);
        return root;
    }

    //找最大值的索引
    public int findMax(int[] nums, int l, int r){
        int max = Integer.MIN_VALUE, maxIndex = l;
        for(int i = l; i <= r; i++){
            if(max < nums[i]){
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        head.next=deleteDuplicates(head.next);
        if(head.val==head.next.val) head=head.next;
        return head;
    }
