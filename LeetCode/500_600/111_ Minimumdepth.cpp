/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
//二叉树的最小深度
class Solution {
	public:
		int minDepth(TreeNode* root) {
			int thereturn = 0;
			if(!root) {
				return thereturn;
			}
			if(!root->left  && !root->right ) {
				thereturn = 1;
			}
			if(root->left&&root->right) {
				return std::min(minDepth(root->left),minDepth(root->right))+1;
			}
			if( root->left) {
				return minDepth(root->left)+1;
			}
			if( root->right) {
				return minDepth(root->right)+1;
			}
			return thereturn;
		}
};
