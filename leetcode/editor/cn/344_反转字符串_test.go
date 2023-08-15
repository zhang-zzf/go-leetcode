package leetcode

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_givenNormal_when344_thenSuccess(t *testing.T) {
	aStr := []byte{'h', 'e', 'l', 'l', 'o'}
	reverseString(aStr)
	assert.Equal(t, "olleh", string(aStr))
}

//leetcode submit region begin(Prohibit modification and deletion)
func reverseString(s []byte) {
	for left, right := 0, len(s)-1; left < right; left, right = left+1, right-1 {
		s[left], s[right] = s[right], s[left]
	}
}

//leetcode submit region end(Prohibit modification and deletion)
