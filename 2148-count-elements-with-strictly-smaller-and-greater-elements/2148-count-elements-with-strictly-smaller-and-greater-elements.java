class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n==1)
            return 0;
        int min = nums[0];
        int i = 1;
        while(i<n && nums[i] == nums[0])
            i++;
        
        int j = n-1;
        while(j>=0 && nums[j] == nums[n-1])
            j--;
        // System.out.println(i);
        // System.out.println(j);
        if(j<i)
            return 0;
        return (j-i+1);
    }
}