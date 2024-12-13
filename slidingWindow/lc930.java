930. Binary Subarrays With Sum -> https://leetcode.com/problems/binary-subarrays-with-sum/
Medium
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
A subarray is a contiguous part of the array.

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]

Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length


prerequisite for this question is https://leetcode.com/problems/subarray-sum-equals-k/submissions/1477821583/



class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = sumLessOrEqual(nums, goal) - sumLessOrEqual(nums, goal - 1);
        return ans;
    }
    public int sumLessOrEqual(int[] nums, int goal) {
        int count = 0; 
        int r = 0; 
        int l = 0;
        int sum = 0;
        if (goal < 0) {
            return 0;
        }

        while (r < nums.length) {
            sum+= nums[r];
            while(sum > goal) {
                sum -= nums[l];
                l += 1;
            }

            count += r-l+1;
            r += 1;
        }
        return count;
    }
}

// it's a good question and easy if you catch the intuition of it.
// first find less than equal and then find less than the goal required
// the subtraction of which give you the sum equal to goal subarrays.
