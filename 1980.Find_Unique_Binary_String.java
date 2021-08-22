class Solution {
    public String findDifferentBinaryString(String[] nums) {
        // String ans = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nums.length;i++)
        {
            sb.append((nums[i].charAt(i)=='0')?"1":"0");
        }
        return sb.toString();
        
    }
}

//Idea here is simply checking the ith character of the ith string and reversing that
//And in this way we will definetly get the unique string
//01, 11 -> 10
//Simillarly for all
