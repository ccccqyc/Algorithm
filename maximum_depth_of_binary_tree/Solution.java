package maximum_depth_of_binary_tree;

/**
 * 1
 * Created by q on 17-7-21.
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }
}
