//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 
// 👍 4004 👎 0


import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


class ValidParenthesesTest {

    final Solution solution = new Solution();

    @Test
    void givenNormal_when_thenSuccess() {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {
            boolean ans = true;
            Deque<Integer> stack = new LinkedList<>();
            Map<Integer, Integer> pairs = new HashMap<Integer, Integer>() {{
                put((int) '(', (int) ')');
                put((int) '[', (int) ']');
                put((int) '{', (int) '}');
            }};
            for (int c : s.toCharArray()) {
                if (pairs.containsKey(c)) {
                    stack.push(c);
                } else if (stack.isEmpty() || c != pairs.get(stack.pop())) {
                    ans = false;
                    break;
                } else {
                    // match
                }
            }
            if (!stack.isEmpty()) {
                ans = false;
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}