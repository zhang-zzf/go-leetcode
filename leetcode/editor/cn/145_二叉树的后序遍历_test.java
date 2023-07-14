//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1053 👎 0


import model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;


class BinaryTreePostorderTraversalTest {

    final Solution solution = new Solution();

    @Test
    void givenNormal_when_thenSuccess() {
        TreeNode tree = TreeNode.decode("[1, null, 2, 3, null, 5]");
        List<Integer> ans = solution.postorderTraversal(tree);
        then(ans).containsExactly(5, 3, 2, 1);
    }

    @Test
    void givenNormal_whenDecode_thenSuccess() {
        TreeNode tree = TreeNode.decode("[1, null, 2, 3, null, 5]");
        then(tree).isNotNull();
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

        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> ans = new ArrayList<>();
            ans.addAll(postorderTraversal(root.left));
            ans.addAll(postorderTraversal(root.right));
            ans.add(root.val);
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}