class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // Case 1: dono null hain
        if (p == null && q == null) {
            return true;
        }
        
        // Case 2: ek null aur ek non-null
        if (p == null || q == null) {
            return false;
        }
        
        // Case 3: value match nahi karti
        if (p.val != q.val) {
            return false;
        }
        
        // Case 4: left aur right subtree check karo
        return isSameTree(p.left, q.left) 
                && isSameTree(p.right, q.right);
    }
}
