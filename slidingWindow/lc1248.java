1248. Count Number of Nice Subarrays
Medium
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.

Example 1:
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.

Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
         int ans = sumLessOrEqual(nums, k) - sumLessOrEqual(nums, k - 1);
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
            sum+= nums[r]%2;
            while(sum > goal) {
                sum -= nums[l] % 2;
                l += 1;
            }

            count += r-l+1;
            r += 1;
        }
        return count;
    }
}

//this question is the same as binary subarray question just we need to consider 1 as odd and 0 as even
//and the question is same just we add % 2 while adding and subtracting
//
//
