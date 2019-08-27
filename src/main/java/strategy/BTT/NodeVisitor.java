package strategy.BTT;

public abstract class NodeVisitor {
    void beforeVisitingLeftChild(TreeNode node) {
    }

    void afterVisitingLeftChild(TreeNode node) {
    }

    void beforeVisitingRightChild(TreeNode node) {
    }

    void afterVisitingRightChild(TreeNode node) {
    }

    abstract void visit(TreeNode node);
};

//Action : It just displays the node on console.
class DisplayVisitor extends NodeVisitor {
    void visit(TreeNode node) {
        System.out.print(node.value + " -> ");
    }
};

//Action : It displays the expression on console.
class ExpressionVisitor extends NodeVisitor {

    void beforeVisitingLeftChild(TreeNode node) {
        System.out.print("( ");
    }

    void afterVisitingRightChild(TreeNode node) {
        System.out.print(") ");
    }

    void visit(TreeNode node) {
        if (node.value == '+')
            System.out.print("+ ");
        else if (node.value == '-')
            System.out.print("- ");
        else if (node.value == '*')
            System.out.print("* ");
        else
            System.out.print(node.value + " ");
    }
};


// Action : It just swaps the left and right child to visiting TreeNode.
class MirrorCreator extends NodeVisitor {

    void visit(TreeNode node) {
        TreeNode pTemp = node.pLeft;
        node.pLeft = node.pRight;
        node.pRight = pTemp;
    }
};


//Action : It just counts each visiting TreeNode.
class CountingVisitor extends NodeVisitor {
    private int count;

    public CountingVisitor() {
        count = 0;
    }

    public void visit(TreeNode node) {
        count++;
    }

    int getCount() {
        return count;
    }
};