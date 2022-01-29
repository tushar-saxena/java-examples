package com.ts.javaexamples.employee;

// Java program to construct a tree using inorder
// and postorder traversals

/* A binary tree node has data, pointer to left
child and a pointer to right child */
class Node {
    int data;
    TreeNode left, right;

    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

// Class Index created to implement pass by reference of Index
class Index {
    int index;
}

class BinaryTree {
    /* Recursive function to construct binary of size n
    from Inorder traversal in[] and Postrder traversal
    post[]. Initial values of inStrt and inEnd should
    be 0 and n -1. The function doesn't do any error
    checking for cases where inorder and postorder
    do not form a tree */
    TreeNode buildUtil(int in[], int post[], int inStrt,
                       int inEnd, TreeIndex pTreeIndex)
    {
        // Base case
        if (inStrt > inEnd)
            return null;

		/* Pick current node from Postrder traversal using
		postIndex and decrement postIndex */
        TreeNode treeNode = new TreeNode(post[pTreeIndex.index]);
        (pTreeIndex.index)--;

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return treeNode;

		/* Else find the index of this node in Inorder
		traversal */
        int iIndex = search(in, inStrt, inEnd, treeNode.data);

		/* Using index in Inorder traversal, construct left and
		right subtress */
        treeNode.right = buildUtil(in, post, iIndex + 1, inEnd, pTreeIndex);
        treeNode.left = buildUtil(in, post, inStrt, iIndex - 1, pTreeIndex);

        return treeNode;
    }

    // This function mainly initializes index of root
    // and calls buildUtil()
    TreeNode buildTree(int in[], int post[], int n)
    {
        TreeIndex pTreeIndex = new TreeIndex();
        pTreeIndex.index = n - 1;
        return buildUtil(in, post, 0, n - 1, pTreeIndex);
    }

    /* Function to find index of value in arr[start...end]
    The function assumes that value is postsent in in[] */
    int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }

    /* This funtcion is here just to test */
    void preOrder(TreeNode treeNode)
    {
        if (treeNode == null)
            return;
        System.out.print(treeNode.data + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
        int n = in.length;
        TreeNode root = tree.buildTree(in, post, n);
        System.out.println("Preorder of the constructed tree : ");
        tree.preOrder(root);
    }
}

// This code has been contributed by Mayank Jaiswal(mayank_24)
