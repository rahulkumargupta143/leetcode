class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n= nums.length;
        int diff = solve(nums ,0 ,n-1);
        return diff>=0;
    }
    private int solve(int[] nums , int i , int j ){
        if(i>j) return 0;

        if(i==j) return nums[i];

        int pickleft  = nums[i] - solve( nums ,i+1 ,j);
        int pickright = nums[j] - solve(nums , i ,j-1);

        return Math.max(pickleft , pickright);

    }
}