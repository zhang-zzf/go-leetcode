import unittest
from typing import List


class TestSolution(unittest.TestCase):

    def setUp(self) -> None:
        self.solution = Solution()

    def test_givenNormal_when_thenSuccess(self):
        duplicate = self.solution.containsNearbyDuplicate([1, 2, 3, 1], 3)
        self.assertTrue(duplicate)

    def test_givenNormalCase2_when_thenSuccess(self):
        duplicate = self.solution.containsNearbyDuplicate([1, 2, 3, 4, 1], 3)
        self.assertFalse(duplicate)


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        # 滑动窗口
        ans = False
        window: dict[int, bool] = {}
        for idx, item in enumerate(nums):
            if window.get(item):
                ans = True
                break
            else:
                window[item] = True
            if len(window) > k:
                del window[nums[idx - k]]
        return ans
        pass


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    unittest.main()
