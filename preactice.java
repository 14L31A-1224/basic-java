public class preactice
{
static class Node{
    int data;
    Node left,right;
    Node (int data)
    {
        this.data=data;
    }
}
public static Node insert(Node root, int val)
{
    if(root == null)
    {
     root = new Node(val);
     return root;   
    }
    if(root.data > val)
    root.left=insert(root.left, val);
    if(root.data < val)
    root.right = insert(root.right, val);
    return root;
}
public static void inorder(Node root)
{
    if(root == null)
    return;
    inorder(root.left);
    System.out.print(root.data+ " ");
    inorder(root.right);
}
public static Node delete(Node root, int val)
{
    if(root.data > val)
    root.left = delete(root.left, val);
    if(root.data < val)
    root.right = delete(root.right, val);
    else{
        if(root.left == null && root.right == null)
        return null;
        if(root.left == null)
        return root.right;
        if(root.right == null)
        return root.left;
        Node IS= inordersuccessor(root.right);
        root.data = IS.data;
        root.right = delete(root.right, IS.data);
    }
    return root;
}
public static Node inordersuccessor(Node root)
{
    while (root.left != null) {
        root = root.left;
    }
    return root;
}
public static void printinran(Node root, int X, int Y)
{
    if(root == null)
    return;
    if(root.data >= X && root.data <= Y)
    {
        printinran(root.left, X, Y);
        System.out.print(root.data+" ");
        printinran(root.right, X, Y);
    }
    else if(root.data <= X)
    printinran(root.right, X, Y);
    else
    printinran(root.left, X, Y);
    
}
public static void main(String[] args) {
    int values[]= {2,3,4,5,7,8,9,10,11,12};
    Node root =null;
    for (int i=0;i<values.length;i++)
    {
        root = insert(root, values[i]);
    }
    inorder(root);
    System.out.println();
   delete(root, 12);
    printinran(root, 2, 4);
   inorder(root);
    
}
}