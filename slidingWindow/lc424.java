424. Longest Repeating Character Replacement
Medium

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length


class Solution {
    public int characterReplacement(String s, int k) {
        int hash[] = new int[26];
        int maxfreq = 0;
        int ans = 0;
        int l = 0;
        int r = 0;

        while(r < s.length()) {
            maxfreq = Math.max(maxfreq, ++hash[s.charAt(r) - 'A']);
            // while((r-l+1) - maxfreq > k ) {
            //     hash[l]--;
            //     maxfreq = 0;
            //     for(int i = 0; i < 26; i++) {
            //         maxfreq = Math.max(maxfreq, hash[i]);
            //     }
            //     l = l+1;
            // }
            // so the above takes more TC than the below approach.
             if((r-l+1) - maxfreq > k ) {
                hash[s.charAt(l) - 'A']--;
                // maxfreq = 0;
                // for(int i = 0; i < 26; i++) {
                //     maxfreq = Math.max(maxfreq, hash[i]);
                // }
                l = l+1;
            }
            ans = Math.max(ans, r-l+1);
            r = r+1;
        }
        return ans;

    }
}

// it's a standard sliding window problem which involves a singles condition check and then everything remains the same as the other SW questions with r and l pointer.
//At this time it seems easy as similar questions i have solved before, but it can be done as it seems a 
//easy one.
//
