/**
 * 1
 * Created by q on 17-7-21.
 */
public class P97 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }
}

class TreeNode {

    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

}
