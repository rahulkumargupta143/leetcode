import java.util.*;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        inorder(node.left, result);     // Step 1: Left
        result.add(node.val);           // Step 2: Root
        inorder(node.right, result);    // Step 3: Right
    }
}
