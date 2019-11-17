package pattern.strategy.BTT;

class TreeNode {
    int value;
    TreeNode pLeft;
    TreeNode pRight;

    TreeNode(int val) {
        value = val;
        pLeft = null;
        pRight = null;
    }
};

abstract public class BTTraversal {
    NodeVisitor nodeVisitor;

    BTTraversal() {
        nodeVisitor = new DisplayVisitor();
    }

    abstract void traverse(TreeNode node, NodeVisitor nodeVisitor);

    void traverse(TreeNode node) {
        traverse(node, nodeVisitor);
    }
};

class PreOrderTraversal extends BTTraversal {

    void traverse(TreeNode node, NodeVisitor nodeVisitor) {
        if (node == null)
            return;
        nodeVisitor.visit(node);
        nodeVisitor.beforeVisitingLeftChild(node);
        traverse(node.pLeft, nodeVisitor);
        nodeVisitor.afterVisitingLeftChild(node);
        nodeVisitor.beforeVisitingRightChild(node);
        traverse(node.pRight, nodeVisitor);
        nodeVisitor.afterVisitingRightChild(node);
    }
};


class PostOrderTraversal extends BTTraversal {
    void traverse(TreeNode node, NodeVisitor nodeVisitor) {
        if (node == null)
            return;
        nodeVisitor.beforeVisitingLeftChild(node);
        traverse(node.pLeft, nodeVisitor);
        nodeVisitor.afterVisitingLeftChild(node);
        nodeVisitor.beforeVisitingRightChild(node);
        traverse(node.pRight, nodeVisitor);
        nodeVisitor.afterVisitingRightChild(node);
        nodeVisitor.visit(node);
    }
};


class InOrderTraversal extends BTTraversal {
    void traverse(TreeNode node, NodeVisitor nodeVisitor) {
        if (node == null)
            return;
        nodeVisitor.beforeVisitingLeftChild(node);
        traverse(node.pLeft, nodeVisitor);
        nodeVisitor.afterVisitingLeftChild(node);
        nodeVisitor.visit(node);
        nodeVisitor.beforeVisitingRightChild(node);
        traverse(node.pRight, nodeVisitor);
        nodeVisitor.afterVisitingRightChild(node);
    }
};

