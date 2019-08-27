package strategy.BTT;

public class driver {
    static TreeNode createTree(int left, int val, int right) {
        TreeNode pNode = new TreeNode(val);
        pNode.pLeft = new TreeNode(left);
        pNode.pRight = new TreeNode(right);
        return pNode;
    }

    public static void main(String[] args) {
        TreeNode root = createTree(4, 8, 9);
        root.pLeft.pLeft = createTree(1, 2, 3);
        root.pLeft.pRight = createTree(5, 6, 7);


        // Default NodeVisitor i.e. DisplayVisitor will be used to display the elements of tree using in order
        BTTraversal pInOrderTraversal = new InOrderTraversal();
        NodeVisitor pVisitor = new DisplayVisitor();
        pInOrderTraversal.traverse(root, pVisitor);
        System.out.println();

        // Counting the number of nodes using In order Traversal
        CountingVisitor pCountingVisitor = new CountingVisitor();
        pInOrderTraversal.traverse(root, pCountingVisitor);
        System.out.println("Total Nodes in tree = " + pCountingVisitor.getCount());
        System.out.println();

        // Converting tree into mirror image
        NodeVisitor pMrrCreator = new MirrorCreator();
        BTTraversal pPreOrderTraversal = new PreOrderTraversal();
        pInOrderTraversal.traverse(root);
        System.out.println();

        pPreOrderTraversal.traverse(root, pMrrCreator);
        // Default NodeVisitor i.e. DisplayVisitor will be used to display the elements of tree using in order
        pInOrderTraversal.traverse(root);
        System.out.println();


        // ((((1)+(3))-((5)+(7)))+(2))
        TreeNode pExpRoot = createTree('-', '+', 2);
        pExpRoot.pLeft.pLeft = createTree(1, '+', 3);
        pExpRoot.pLeft.pRight = createTree(5, '+', 7);

        // Displaying expression with brackets using Expression Visitor through In Order Traversal
        NodeVisitor pExpVisitor = new ExpressionVisitor();
        pInOrderTraversal.traverse(pExpRoot, pExpVisitor);

    }
}
