class Solution {
    public int minMoves2 (int[] nums) {
        Arrays.sort (nums);
        int left = 0, right = nums.length - 1, moves = 0;
        while (left < right)
            moves += nums [right--] - nums [left++];
        return moves;
    }
}