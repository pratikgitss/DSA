15. 3Sum
Medium
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105


// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> list = new ArrayList();
//         int n = nums.length;
//         Set<List<Integer>> hs = new HashSet();
//         for(int i = 0; i < n; i++) {
//             for (int j = i+1; j < n; j++) {
//                 for (int k = j+1; k < n; k++) {
//                     if(nums[i] + nums[j] + nums[k] == 0) {      
//                         List<Integer> ans = new ArrayList();
//                         ans.add(nums[i]);
//                         ans.add(nums[j]);
//                         ans.add(nums[k]);
//                         Collections.sort(ans);
//                         if(!hs.contains(ans)){
//                             list.add(ans);
//                         }
//                         hs.add(ans);  
//                     }
//                 }
//             }
//         }
//         return list;
//     }
// }
// class Solution {
//     public List<List<Integer>> threeSum(int[] arr) {
//         int n = arr.length;
//        Set<List<Integer>> st = new HashSet<>();
//         for (int i = 0; i < n; i++) {
//             Set<Integer> hashset = new HashSet<>();
//             for (int j = i + 1; j < n; j++) {
//                 //Calculate the 3rd element:
//                 int third = -(arr[i] + arr[j]);

//                 //Find the element in the set:
//                 if (hashset.contains(third)) {
//                     List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
//                     temp.sort(null);
//                     st.add(temp);
//                 }
//                 hashset.add(arr[j]);
//             }
//         }
//         // store the set elements in the answer:
//         List<List<Integer>> ans = new ArrayList<>(st);
//         return ans;
//     }
// }
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int target = nums[i] + nums[j] + nums[k];
                if (target < 0) {
                    j++;
                } else if (target > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return ans;
    }
}
