public class BiTree {

    char data='-';
    public BiTree lchild,rchild;

    BiTree(char data,BiTree lchild,BiTree rchild){
        this.data=data;
        this.lchild=lchild;
        this.rchild=rchild;
    }

    BiTree(){
    }

    static public void PreOrderTraverse(BiTree T)
    {
        if(T==null)
            return;
        System.out.printf("%c", T.data);  /*显示结点数据，可以更改为其他对结点操作*/
        PreOrderTraverse(T.lchild);    /*再先序遍历左子树*/
        PreOrderTraverse(T.rchild);    /*最后先序遍历右子树*/
    }


    /*二叉树的中序遍历递归算法*/
    static public void InOrderTraverse(BiTree T)
    {
        if(T==null)
            return;
        InOrderTraverse(T.lchild); /*中序遍历左子树*/
        System.out.printf("%c", T.data);  /*显示结点数据，可以更改为其他对结点操作*/
        InOrderTraverse(T.rchild); /*最后中序遍历右子树*/
    }


    /*二叉树的后序遍历递归算法*/
    static public void PostOrderTraverse(BiTree T)
    {
        if(T==null)
            return;
        PostOrderTraverse(T.lchild);   /*先后序遍历左子树*/
        PostOrderTraverse(T.rchild);   /*再后续遍历右子树*/
        System.out.printf("%c", T.data);  /*显示结点数据，可以更改为其他对结点操作*/
    }

    public static void main(String[] args) {
        int count=0,counter=0;
        char data='a';
        BiTree T=new BiTree((char) (data),new BiTree(),new BiTree());
        BiTree tem=T;
        count++;
        for (int i = 0; i <= 10; i++) {
            if(counter<=5)
            tem=tem.lchild;
            else if(counter==6)
                tem=T.rchild;
            else {
                tem=tem.rchild;
                counter=0;
            }
            tem.lchild=new BiTree();
            tem.rchild=new BiTree();
            tem.data=(char) (data+(count));
            count++;
            counter++;
        }
        PreOrderTraverse(T);
        System.out.println();
        InOrderTraverse(T);
        System.out.println();
        PostOrderTraverse(T);
    }
}
