package com.ts.javaexamples.employee;

public class CheckIfBST {
    TreeNode buildTreeUtil(int[] inorderTree, int[] postorderTree, int instruct,
                           int inEnd, TreeIndex pTreeIndex)
    {
        if (instruct > inEnd)
            return null;
        TreeNode treeNode = new TreeNode(postorderTree[pTreeIndex.index]);
        (pTreeIndex.index)--;

        if (instruct == inEnd)
            return treeNode;

        int iIndex = search(inorderTree, instruct, inEnd, treeNode.data);
        treeNode.right = buildTreeUtil(inorderTree, postorderTree, iIndex + 1, inEnd, pTreeIndex);
        treeNode.left = buildTreeUtil(inorderTree, postorderTree, instruct, iIndex - 1, pTreeIndex);
        return treeNode;
    }

    TreeNode buildBSTTree(int[] inorder, int[] postorder, int size)
    {
        TreeIndex pTreeIndex = new TreeIndex();
        pTreeIndex.index = size - 1;
        return buildTreeUtil(inorder, postorder, 0, size - 1, pTreeIndex);
    }

    int search(int[] array, int struct, int end, int value)
    {
        int i;
        for (i = struct; i <= end; i++) {
            if (array[i] == value)
                break;
        }
        return i;
    }

    void preBSTOrder(TreeNode treeNode)
    {
        if (treeNode == null)
            return;
        System.out.print(treeNode.data + " ");
        preBSTOrder(treeNode.left);
        preBSTOrder(treeNode.right);
    }

    boolean isBST(TreeNode root)  {
        return isBSTTreeUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    boolean isBSTTreeUtil(TreeNode treeNode, int minimum, int maximum)
    {
        if (treeNode == null)
            return true;
        if (treeNode.data < minimum || treeNode.data > maximum)
            return false;
        return (isBSTTreeUtil(treeNode.left, minimum, treeNode.data-1) &&
                isBSTTreeUtil(treeNode.right, treeNode.data+1, maximum));
    }


    public static void main(String[] args)
    {
        CheckIfBST tree = new CheckIfBST();
        int[] post = new int[] { 1,3,2,5,7,6,4 };
        int[] in = new int[] { 1,2,3,4,5,6,7 };
        int n = in.length;
        TreeNode root = tree.buildBSTTree(in, post, n);
        System.out.println("Preorder of the constructed tree : ");
        tree.preBSTOrder(root);
        Boolean result = tree.isBST(root);
        System.out.println("Given tree is BST="+result);
    }
}

class TreeNode {
    int data;
    TreeNode left, right;
    public TreeNode(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

class TreeIndex {
    int index;
}

