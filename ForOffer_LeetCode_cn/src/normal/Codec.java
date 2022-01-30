package normal;

import java.util.Deque;

/**
 * todo 37 ÐòÁÐ»¯¶þ²æÊ÷
 * @author qyc
 * // Your Codec object will be instantiated and called as such:
 * // Codec codec = new Codec();
 * // codec.deserialize(codec.serialize(root));
 */
public class Codec {
    // Encodes a tree to a single string.

    private TreeNode root;

    public String serialize(TreeNode root) {
        this.root = root;
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return root;
    }

    public class TreeNode {
        int val;
        Solution.TreeNode left;
        Solution.TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, Solution.TreeNode left, Solution.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
