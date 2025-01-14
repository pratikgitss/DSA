229. Majority Element II
Medium
Topics
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109

class Solution {
    public List<Integer> majorityElement(int[] v) {
       int n = v.length;
       int c1 = 0;
       int c2 = 0; 
       int el1 = Integer.MIN_VALUE;
       int el2 = Integer.MIN_VALUE;

       for (int i = 0; i < n; i++) {
        if(c1 == 0 && v[i] != el2) {
            c1 = 1;
            el1 = v[i];
        }
        else if(c2 == 0 && v[i] != el1) {
            c2 = 1;
            el2 = v[i];
        }
        else if(v[i] == el1) c1++;
        else if(v[i] == el2) c2++;
        else {
            c1--;
            c2--;
        } 

       } 

       List<Integer> ans = new ArrayList();
       c1 = 0;
       c2 = 0;
       int min = n/3 + 1;
       for(int i = 0; i < n; i++){
        if(v[i] == el1) c1++;
        
        if(v[i] == el2) c2++;
        
       }
       if (c1 >= min) ans.add(el1);
       if(c2 >= min) ans.add(el2);
       return ans;
    } 
}
TC = O(n) + O(n);
SC = O(1);
this is solved using the moores algorithm which in which we just cancels the reduces the counter if prev element is not equal to current else increases the counter. Then if the counter is greater than the required value we just check again just to verify.
