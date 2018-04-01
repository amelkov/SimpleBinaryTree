public class Node<E> {
    int key;
    int value;
    Node parent;
    Node left;
    Node right;

    public Node(int key, int value, Node parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node(" + key + ": " + value + ")";
    }
}
