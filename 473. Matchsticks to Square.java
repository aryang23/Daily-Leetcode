class Solution {
    public boolean makesquare(int[] nums) {
        if(nums.length < 4)
            return false;
        
        int perimeter = 0;
        for(int el : nums) {
            perimeter += el;
        }
        
        if(perimeter % 4 != 0)
            return false;
        
        int side = perimeter / 4;
        int[] sides = new int[] {side, side, side, side};
        
        return makesSquareHelper(nums, 0, sides);
    }
    
    private boolean makesSquareHelper(int[] nums, int i, int[] sides) {
        if(i == nums.length) {
            return sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0;
        }
        
        for(int j=0; j<4; j++) {
            if(nums[i] > sides[j])
                continue;
            sides[j] -= nums[i];
            if(makesSquareHelper(nums, i+1, sides))
                return true;
            sides[j] += nums[i];
        }
        
        return false;
    }
}
