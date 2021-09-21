/**
 * Problem
 * https://leetcode.com/problems/find-pivot-index/
 * 
 * ************************************************************* 
 * 
 * Input: nums = [1,7,3,6,5,6]
 * 
 * Output: 3
 * 
 * Explanation:
 *  The pivot index is 3.
 *  Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 *  Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * 
 * *************************************************************  
 * 
 * Input: nums = [1,2,3]
 * 
 * Output: -1
 * 
 * Explanation:
 *  There is no index that satisfies the conditions in the problem statement.
 * 
 * *************************************************************  
 * 
 * Input: nums = [2,1,-1]
 * 
 * Output: 0
 * 
 * Explanation:
 *  The pivot index is 0.
 *  Left sum = 0 (no elements to the left of index 0)
 *  Right sum = nums[1] + nums[2] = 1 + -1 = 0
 * 
 * ************************************************************* 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class FindPivotIndex {
  public int pivotIndex(int[] nums) {
    int leftSum = 0;
    int rightSum = 0;
    
    /**
     * Time Complexity: O(n)
     */
    for (int i : nums) {
      rightSum += i;
    }
    
    /**
     * Time Complexity: O(n)
     */
    for (int i = 0; i < nums.length; i++) {
      leftSum += (i == 0 ? 0 : nums[i - 1]);
      rightSum -= nums[i];
      
      if (leftSum == rightSum) {
        return i;
      }
    }
    
    return -1;
  }
}