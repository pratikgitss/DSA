992. Subarrays with K Different Integers
Hard
Given an integer array nums and an integer k, return the number of good subarrays of nums.
A good array is an array where the number of different integers in that array is exactly k.
For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

Example 1:
Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length


class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans = subarrWithLessEqualToK(nums, k) - subarrWithLessEqualToK(nums, k-1);
        return ans;
    }
    public int subarrWithLessEqualToK(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int count = 0; 
        int r = 0; 
        int l = 0;
        HashMap<Integer, Integer> hm = new HashMap();

        while( r < nums.length) {
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);

            while(hm.size() > k) {
               hm.put(nums[l], hm.get(nums[l]) - 1);
               if(hm.get(nums[l]) == 0){
                hm.remove(nums[l]);
               }
               l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
}

//same as binary subarray with sum question lc930.
//same to same no difference in the logic just a small change.
//
