package nonlinear_structure;

import java.util.LinkedList;

class TreeNode2 {
    String value;
    TreeNode2 left;
    TreeNode2 right;

    public TreeNode2(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree2 {
    TreeNode2 root;

    BinaryTree2(String[] data) {
        for (String item : data) {
            root = insertData(root, item);
        }
    }

    private TreeNode2 insertData(TreeNode2 node, String value) {
        if (node == null) {
            return new TreeNode2(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.left = insertData(node.left, value);
        } else {
            node.right = insertData(node.right, value);
        }
        return node;
    }

    // 전위 순회 : Root - Left - Right
    public void preorderTraversal(TreeNode2 node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // 중위 순회 : Left - Root - Right
    public void inorderTraversal(TreeNode2 node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.value + " ");
            inorderTraversal(node.right);
        }
    }

    // 후위 순회 : Left - Right - Root
    public void postorderTraversal(TreeNode2 node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }
}

public class Tree2 {
	/*
    public static void main(String[] args) {
        String[] data = {
            "Karina", "Suzy", "Wonyoung", "Jiwon", "Dohyun", 
            "Minhee", "Jisu", "Winter", "V"
        };
        BinaryTree2 tree = new BinaryTree2(data);

        System.out.println("Preorder traversal:");
        tree.preorderTraversal(tree.root);

        System.out.println("\nInorder traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPostorder traversal:");
        tree.postorderTraversal(tree.root);
    }*/
}
