//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1866 👎 0


import model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;


class BinaryTreeInorderTraversalTest {

    final Solution solution = new Solution();

    @Test
    void givenNormal_when_thenSuccess() {
        TreeNode tree = TreeNode.decode("[1,null,2,3]");
        List<Integer> ans = solution.inorderTraversal(tree);
        then(ans).containsExactly(1, 3, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>(0);
            while (root != null) {
                // left -> Node -> right
                // left
                if (root.left != null) {
                    TreeNode predecessor = root.left;
                    while (predecessor.right != null && predecessor.right != root) {
                        predecessor = predecessor.right;
                    }
                    if (predecessor.right == null) {
                        // iterate left
                        predecessor.right = root;
                        root = root.left;
                        continue;
                    } else {
                        // left was already iterated
                        // roll back changes to the tree
                        predecessor.right = null;
                    }
                }
                // Node
                ans.add(root.val);
                // right
                root = root.right;
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}