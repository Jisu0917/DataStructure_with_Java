package nonlinear_structure;
import java.util.LinkedList;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {  // Constructor
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree(int n) {
        root = null;
        for (int i = 1; i <= n; i++) {
            root = insertNode(root, i);  // 트리에 노드 삽입
        }
    }

    private TreeNode insertNode(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }

        if (value < node.value) {
            node.left = insertNode(node.left, value);  // 왼쪽 자식에 재귀적으로 삽입
        } else if (value > node.value) {
            node.right = insertNode(node.right, value);  // 오른쪽 자식에 재귀적으로 삽입
        }

        return node;
    }

    // 전위 순회 : Root - Left - Right
    public void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // 중위 순회 : Left - Root - Right
    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.value + " ");
            inorderTraversal(node.right);
        }
    }

    // 후위 순회 : Left - Right - Root
    public void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }
}

public class Tree1 {
//    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree(9);  // 1부터 9까지의 값으로 이진 트리 생성
//
//        System.out.println("Preorder traversal:");
//        tree.preorderTraversal(tree.root);
//
//        System.out.println("\nInorder traversal:");
//        tree.inorderTraversal(tree.root);
//
//        System.out.println("\nPostorder traversal:");
//        tree.postorderTraversal(tree.root);
//    }
}
