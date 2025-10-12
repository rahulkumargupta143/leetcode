import java.util.*;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        // Current node value add karo path me
        path += node.val;

        // Agar leaf node hai
        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            // Leaf nahi hai to path me arrow add karo
            path += "->";
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
    }
}
