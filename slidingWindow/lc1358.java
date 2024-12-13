
1358. Number of Substrings Containing All Three Characters

Medium

Given a string s consisting only of characters a, b and c.
Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

Example 2:
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

Example 3:
Input: s = "abc"
Output: 1


class Solution {
    public int numberOfSubstrings(String s) {
        int hash[] = new int[3];
        Arrays.fill(hash, -1);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
            count += 1 + Math.min(hash[0], Math.min(hash[1], hash[2]));
        }
        return count;
    }
}

Time complexity: O(n)
Space complexity: O(1)


// we just traverse the string given and recording the string with a single pointer 
// and add the index to the hash array.
//
// simple question
// can be done by sliding window(l and r pointer) but will take a bit more time complexity than this.
//
//
