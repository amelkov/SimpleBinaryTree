public class BinaryTree {
    Node root;

    public Node find(int key) {
        return find(key, root);
    }

    private Node find(int key, Node node) {
        if (node == null || key == node.key) {
            return node;
        } else if (key > node.key) {
            return find(key, node.right);
        } else {
            return find(key, node.left);
        }
    }

    public void insert(int key, int value) {
        root = insert(key, value, root, null);
    }

    private Node insert(int key, int value, Node node, Node parent) {
        if (node == null) {
            node = new Node(key, value, parent);
        } else if (key > node.key) {
            node.right = insert(key, value, node.right, node);
        } else if (key < node.key) {
            node.left = insert(key, value, node.left, node);
        } else {
            node.value = value;
        }
        return node;
    }

    public void remove(int key) {
        remove(key, find(key));
    }

    private void remove(int key, Node node) {
        if (node != null) {
            if (node.left != null && node.right != null) {
                Node replaceNode = node.right;
                while (replaceNode.left != null) {
                    replaceNode = replaceNode.left;
                }
                remove(replaceNode.key, replaceNode);
                node.key = replaceNode.key;
                node.value = replaceNode.value;
            } else if (node.left != null) {
                replace(node, node.left);
            } else if (node.right != null) {
                replace(node, node.right);
            } else {
                replace(node, null);
            }
        }
    }

    private void replace(Node oldNode, Node newNode) {
        if (oldNode.parent != null) {
            if (oldNode.parent.right == oldNode) {
                oldNode.parent.right = newNode;
            } else {
                oldNode.parent.left = newNode;
            }
            if (newNode != null) {
                newNode.parent = oldNode.parent;
            }
        } else {
            root = newNode;
            newNode.parent = null;
        }
    }

    public void infixTraverse() {
        infixTraverse(root);
    }

    private void infixTraverse(Node node) {
        if (node != null) {
            infixTraverse(node.left);
            System.out.println(node);
            infixTraverse(node.right);
        }
    }

    public void prefixTraverse() {
        prefixTraverse(root);
    }
    private void prefixTraverse(Node node) {
        if (node != null) {
            System.out.println(node);
            prefixTraverse(node.left);
            prefixTraverse(node.right);
        }
    }

    public void postfixTraverse() {
        postfixTraverse(root);
    }
    private void postfixTraverse(Node node) {
        if (node != null) {
            postfixTraverse(node.left);
            postfixTraverse(node.right);
            System.out.println(node);
        }
    }
}
