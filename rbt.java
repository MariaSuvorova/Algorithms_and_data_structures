package Homework4;

public class rbt {
    
    public Node root;

    public boolean add(int value){
        if (root != null){
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }
    private boolean addNode(Node node, int value){
        if (node.value == value){
            return false;
        } else {
            if (node.value > value){
                if (node.leftChild != null){
                    boolean result = addNode((rbt.Node) node.leftChild, value);
                    node.leftChild = rebalance((rbt.Node) node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null){
                    boolean result = addNode((rbt.Node) node.rightChild, value);
                    node.rightChild = rebalance((rbt.Node) node.rightChild);
                    return result;
            } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }
    private Node rebalance(Node node){
        Node result = node;
        boolean needRebalance;
        do{
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                    needRebalance = true;
                    result = rightSwap(result);
                }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                    needRebalance = true;
                    result = lefttSwap(result);
                }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                result.rightChild != null && result.rightChild.color == Color.RED) {
                    needRebalance = true;
                    colorSwap(result);
                }
            }
    while (needRebalance);
    return result;
    }
    private Node rightSwap(Node node){
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }
    private Node lefttSwap(Node node){
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }
    private void colorSwap(Node node){
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    public String treeToString(Node root) {
        if(root == null) {
            return "-";
        }
        String leftSubTree = treeToString(root.getLeftChild());
        String rightSubTree = treeToString(root.getRightChild());
        return "(" + leftSubTree + root.getValue() + rightSubTree + ")";
    }

    private enum Color {
		RED,
		BLACK
	}

    public class Node {
		int value;
		Color color;
		Node leftChild;
		Node rightChild;
		
    @Override
    public String toString(){
        return "Node{" +
                "Value=" + value +
                ", color=" + color +
                "}";
        }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
    }

    public Node getRoot() {
        return root;
    }
}