package leetcode

import (
	"github.com/stretchr/testify/assert"
	"strings"
	"testing"
)

func Test_givenNormal_when929_thenSuccess(t *testing.T) {
	ans := numUniqueEmails([]string{
		"test.email+alex@leetcode.com",
		"test.e.mail+bob.cathy@leetcode.com",
		"testemail+david@lee.tcode.com"})
	assert.Equal(t, 2, ans)
}

//leetcode submit region begin(Prohibit modification and deletion)
func numUniqueEmails(emails []string) int {
	emailCnt := map[string]int{}
	for _, e := range emails {
		s := strings.Builder{}
		ignore, after := false, false
		for _, c := range e {
			if c == '@' {
				after = true
			}
			if after {
				s.WriteRune(c)
				continue
			}
			if c == '+' {
				ignore = true
			}
			if ignore || c == '.' {
				continue
			}
			s.WriteRune(c)
		}
		emailCnt[s.String()] += 1
	}
	return len(emailCnt)
}

//leetcode submit region end(Prohibit modification and deletion)
